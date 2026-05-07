package repository;

import model.Factura;
import model.Furnizor;
import model.Plata;

import java.util.Date;
import java.util.List;

public class TestPlataRepository {
    public static void main(String[] args) {
        runTest();
    }
    public static void runTest() {
        System.out.println(">>> Testare unitară: PlataRepository");
        PlataRepository plataRepo = new PlataRepository();
        MasterRepository masterRepo = new MasterRepository();

        try {
            // 1. Test findFacturiNeachitateByFurnizor
            // Luam primul furnizor din baza pentru a avea un ID valid
            List<Furnizor> furnizori = masterRepo.findAllFurnizori();
            if (furnizori.isEmpty()) {
                System.out.println("Sarit test: Nu exista furnizori in baza.");
                return;
            }

            Long idFurnizor = furnizori.get(0).getId();
            List<Factura> neachitate = plataRepo.findFacturiNeachitateByFurnizor(idFurnizor);

            System.out.println("1. Test Filtrare Facturi: SUCCES");
            System.out.println("   - Facturi neachitate gasite: " + neachitate.size());

            // 2. Test ProceseazaPlata (Simulare flux complet)
            System.out.println("2. Test ProceseazaPlata (Simulare tranzactie):");
            plataRepo.beginTransaction();

            if (!neachitate.isEmpty()) {
                Factura f = neachitate.get(0);
                Furnizor furnizor = furnizori.get(0);

                Plata p = new Plata();
                p.setSumaPlata(100.0);
                p.setDataDocument(new Date());
                p.setFactura(f);

                // Modificam simbolic obiectele pentru update
                f.setStatusFactura("Achitata partial");
                furnizor.setSold(furnizor.getSold() - 100.0);

                plataRepo.proceseazaPlata(p, f, furnizor);
                System.out.println("   - Metoda proceseazaPlata executata fara erori.");
            }

            // Dam ROLLBACK pentru a nu strica datele de test din baza
            plataRepo.rollbackTransaction();
            System.out.println("   - Rollback executat (datele bazei au ramas intacte).");

            System.out.println("REZULTAT FINAL: SUCCES");

        } catch (Exception e) {
            System.err.println("REZULTAT FINAL: EȘUAT");
            System.err.println("Eroare: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

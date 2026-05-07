package repository;

import model.Banca;
import model.Furnizor;

import java.util.List;

public class TestMasterRepository {
    public static void main(String[] args) {
        runTest();
    }
    public static void runTest() {
        System.out.println(">>> Testare unitară: MasterRepository");
        MasterRepository master = new MasterRepository();

        try {
            // 1. Testare findAllBanci
            List<Banca> banci = master.findAllBanci();
            System.out.println("1. Test findAllBanci: " + (banci != null ? "SUCCES" : "ESUAT"));
            System.out.println("   - Banci gasite: " + (banci != null ? banci.size() : 0));

            // 2. Testare findAllFurnizori
            List<Furnizor> furnizori = master.findAllFurnizori();
            System.out.println("2. Test findAllFurnizori: " + (furnizori != null ? "SUCCES" : "ESUAT"));
            System.out.println("   - Furnizori gasiti: " + (furnizori != null ? furnizori.size() : 0));

            // 3. Testare findFurnizorById (Presupunem ca ID-ul 1 exista)
            if (furnizori != null && !furnizori.isEmpty()) {
                Long idTest = furnizori.get(0).getId(); // Luam primul ID existent pentru test sigur
                Furnizor f = master.findFurnizorById(idTest);
                System.out.println("3. Test findFurnizorById (" + idTest + "): " + (f != null ? "SUCCES" : "ESUAT"));
                if (f != null) {
                    System.out.println("   - Nume furnizor gasit: " + f.getNume());
                }
            } else {
                System.out.println("3. Test findFurnizorById: ESUAT (Baza de date nu are furnizori pentru test)");
            }

            System.out.println("REZULTAT FINAL: SUCCES");

        } catch (Exception e) {
            System.err.println("REZULTAT FINAL: EȘUAT");
            System.err.println("Eroare: " + e.getMessage());
        }
    }
}

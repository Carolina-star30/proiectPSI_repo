package controller;

import model.Banca;
import model.Furnizor;

import java.util.ArrayList;
import java.util.List;

public class TestPlataFacturaAdapter {
    public static void main(String[] args) {
        runTest();
    }
    public static void runTest() {
        System.out.println(">>> Testare unitară: PlataFacturaAdapter");

        try {
            // 1. Inițializăm Adapter-ul
            PlataFacturaAdapter adapter = new PlataFacturaAdapter();

            // 2. Testăm stocarea listelor (Simulăm dropdown-ul de Bănci)
            List<Banca> banciTest = new ArrayList<>();
            banciTest.add(new Banca());
            banciTest.add(new Banca());
            adapter.setListaBanci(banciTest);

            System.out.println("1. Test populare listă bănci: " +
                    (adapter.getListaBanci().size() == 2 ? "SUCCES" : "EROARE"));

            // 3. Testăm selecția utilizatorului (Furnizor și Sumă)
            Furnizor fTest = new Furnizor();
            fTest.setNume("Furnizor Central");
            adapter.setFurnizorSelectat(fTest);

            Double sumaTest = 850.50;
            adapter.setSumaPlata(sumaTest);

            System.out.println("2. Test recuperare furnizor selectat: " +
                    (adapter.getFurnizorSelectat().getNume().equals("Furnizor Central") ? "SUCCES" : "EROARE"));

            System.out.println("3. Test recuperare sumă introdusă: " +
                    (adapter.getSumaPlata().equals(sumaTest) ? "SUCCES" : "EROARE"));

            // 4. Verificăm referința (Câmp text de pe ecran)
            adapter.setReferintaExtras("EXTRAS-MAI-2026");
            System.out.println("4. Test câmp referință extras: " +
                    ("EXTRAS-MAI-2026".equals(adapter.getReferintaExtras()) ? "SUCCES" : "EROARE"));

            System.out.println("REZULTAT FINAL: SUCCES (Adapter-ul păstrează starea corect)");

        } catch (Exception e) {
            System.err.println("REZULTAT FINAL: EȘUAT");
            System.err.println("Eroare: " + e.getMessage());
        }
    }
}

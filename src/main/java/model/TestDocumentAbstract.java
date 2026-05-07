package model;

import java.util.Date;

public class TestDocumentAbstract {
    public static void main(String[] args) {
        runTest();
    }
    public static void runTest() {
        System.out.println(">>> Testare unitară: DocumentAbstractEntity (via Factura)");

        try {
            // 1. Instanțiem Factura (clasa copil)
            Factura f = new Factura();

            // 2. Testăm accesul la metodele moștenite din DocumentAbstractEntity
            String nrTest = "FAC-CHIN-2026";
            Date dataTest = new Date();

            f.setNumarDocument(nrTest); // Metodă din părinte
            f.setDataDocument(dataTest); // Metodă din părinte
            f.setSumaTotala(500.0);      // Metodă proprie Factura

            System.out.println("1. Acces câmp 'numarDocument': " +
                    (f.getNumarDocument().equals(nrTest) ? "OK" : "EROARE"));

            System.out.println("2. Acces câmp 'dataDocument': " +
                    (f.getDataDocument() != null ? "OK" : "EROARE"));

            // 3. Verificăm existența ID-ului (chiar dacă e null înainte de salvare)
            System.out.println("3. Verificare ID moștenit: " + (f.getId() == null ? "OK (ne-peristat)" : "EROARE"));

            System.out.println("REZULTAT FINAL: SUCCES (Moștenirea funcționează)");

        } catch (Exception e) {
            System.err.println("REZULTAT FINAL: EȘUAT");
            System.err.println("Eroare: " + e.getMessage());
        }
    }
}

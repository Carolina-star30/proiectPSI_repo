package repository;

import jdk.swing.interop.SwingInterOpUtils;

public class TestAbstractRepository {
    public static void main(String[] args) {
        runTest();
    }

    public static void runTest(){
        System.out.println(">>>> Testare Unitara: AbstracTRepository");
        try{
            // 1. Testare conexiune (EntityManager)
            boolean isConnected = AbstractRepository.getEm().isOpen();
            System.out.println("1. Status Conexiune JPA: " + (isConnected ? "ACTIVĂ" : "INACTIVĂ"));

            // 2. Testare flux tranzacțional (fără a scrie în bază, doar verificăm starea)
            AbstractRepository testRepo = new AbstractRepository() {}; // Clasă anonimă pentru testare

            testRepo.beginTransaction();
            System.out.println("2. Start Tranzacție: OK");

            boolean isActive = AbstractRepository.getEm().getTransaction().isActive();
            System.out.println("3. Tranzacție activă în memorie: " + isActive);

            testRepo.rollbackTransaction();
            System.out.println("4. Rollback Tranzacție (Curățare): OK");

            System.out.println("REZULTAT FINAL: SUCCES");

        } catch (Exception e) {
            System.err.println("REZULTAT FINAL: EȘUAT");
            System.err.println("Motiv eroare: " + e.getMessage());
            e.printStackTrace();
        }

    }
}

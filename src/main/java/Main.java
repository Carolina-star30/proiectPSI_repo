import repository.AbstractRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pornim aplicatia si ne conectam la baza de date...");

        AbstractRepository.getEm();

        System.out.println("Gata! Verifica in pgAdmin daca au aparut tabelele.");
    }
}

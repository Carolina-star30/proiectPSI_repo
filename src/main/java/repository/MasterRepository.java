package repository;

import model.Banca;
import model.Furnizor;

import java.util.List;

/**
 * Clasa responsabila pentru gestionarea nomenclatoarelor (Furnizori, Banci, Localitati).
 * Extinde AbstractRepository pentru a folosi EntityManager-ul comun.
 */

public class MasterRepository extends AbstractRepository {
    public List<Banca> findAllBanci(){
        return getEm().createQuery("SELECT b FROM Banca b", Banca.class)
                      .getResultList();
    }

    //Pentru Obiectul 3 & 4: Incarca lista furnizorilor pentru selectia in formular
    public List<Furnizor> findAllFurnizori(){
        //Retrurneaza lista completa a partenerilor comerciali
        return getEm().createQuery("SELECT f FROM Furnizor f", Furnizor.class)
                      .getResultList();

    }

    //Returneaza detaliile unui furnizor specific (ID, IBAN, Sold curent)
    public Furnizor findFurnizorById(Long id){
        //Cautare directa dupa cheia primara
        return getEm().find(Furnizor.class, id);
    }

}

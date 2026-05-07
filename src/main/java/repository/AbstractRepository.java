package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractRepository {

    private static EntityManager em;
    public static EntityManager getem(){
        if(em ==null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("proiectPSI");
            em= emf.createEntityManager();
        }
        return em;
    }

    //Inițiază tranzacția
    public void beginTransaction(){
        getem().getTransaction().begin();
    }

    //Insert in baza de date
    public Object create ( Object entity){
        getem().persist(entity);
        return entity;
    }

    //UPDATE IN BD
    public Object update (Object entity){
        return getem().merge(entity);
    }

}

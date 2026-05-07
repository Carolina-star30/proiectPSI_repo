package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractRepository {

    private static EntityManager em;
    public static EntityManager getEm(){
        if(em ==null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("proiectPSI");
            em= emf.createEntityManager();
        }
        return em;
    }

    //Inițiază tranzacția
    public void beginTransaction(){
        getEm().getTransaction().begin();
    }

    //Salveaza comanda
    public void commitTransaction(){
        if(getEm().getTransaction().isActive()){
            getEm().getTransaction().commit();
        }
    }

    //Insert in baza de date
    public Object create ( Object entity){
        getEm().persist(entity);
        return entity;
    }

    //UPDATE IN BD
    public Object update (Object entity){
        return getEm().merge(entity);
    }

}

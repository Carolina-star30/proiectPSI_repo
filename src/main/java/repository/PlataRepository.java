package repository;

import model.Factura;
import model.Furnizor;
import model.Plata;

import java.util.List;

public class PlataRepository extends AbstractRepository {
    //1. Metoda pentru Obiectul 7 din formular: Căutare facturi neachitate
    public List<Factura> findFacturiNeachitateByFurnizor(Long furnizorId){
        //Interogare JPA-QL care cauta facturile cu rest de plata >0
        return getEm().createQuery(
                "SELECT f FROM Factura f WHERE f.furnizor.id = :id" +
                        "AND f.statusFactura = 'Neachitat'", Factura.class)
                .setParameter("id", furnizorId)
                .getResultList();
    }

    //2. Metoda pentru Obiectul 20: Salvarea plății efective
    public Plata savePlata (Plata plata){
        //Foloseste metoda create din AbstractRepository pentru INSERT
        return (Plata) this.create(plata);
    }

    public void proceseazaPlata (Plata plataNoua, Factura factura){
        //1. Salvezi plata efectiva
        this.create(plataNoua);

        //2. Update status factura
        double restNou= factura.getRestPlata() - plataNoua.getSumaPlata();
        factura.setRestPlata(restNou);

        if(restNou <= 0){
            factura.setStatusFactura("Achitata integral");
        }else {
            factura.setStatusFactura("Achitata partial");
        }

        //3. Salvam modificarile facturii
        this.update(factura);
    }

}

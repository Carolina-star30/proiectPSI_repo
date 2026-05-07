package repository;

import model.Factura;
import model.Furnizor;
import model.Plata;

import java.util.List;

public class PlataRepository extends AbstractRepository {
    //Returneaza toate facturile din sistem
    public List<Factura> findFacturiAll(){
        return getEm().createQuery("SELECT f FROM Factura f", Factura.class).getResultList();
    }

    //2.  Căutare facturi neachitate pentru un anumit furnizor
    public List<Factura> findFacturiNeachitateByFurnizor(Long furnizorId){
        //Interogare JPA-QL care cauta facturile cu rest de plata >0
        return getEm().createQuery(
                "SELECT f FROM Factura f WHERE f.furnizor.id = :id" +
                        " AND f.statusFactura = 'Neachitat'", Factura.class)
                .setParameter("id", furnizorId)
                .getResultList();
    }

    public void proceseazaPlata (Plata plataNoua, Factura facturaActualizata, Furnizor furnizorActualizat){
        //1. Salvezi plata efectiva
        this.create(plataNoua);

        // Salvam modificarile facturii
        this.update(facturaActualizata);
        // Salvez actualiz furn
        this.update(furnizorActualizat);
    }

}

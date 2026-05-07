package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "facturi")
public class Factura extends DocumentAbstractEntity {

    @Column(name = "suma_totala")
    private Double sumaTotala;

    @Column(name = "Rest_de_plata")
    private Double restPlata;

    @Column(name = "Status_factura")
    private String statusFactura;

    @ManyToOne
    @JoinColumn(name = "id_furnizor")
    private Furnizor furnizor;

    public Double getSumaTotala() {
        return sumaTotala;
    }

    public void setSumaTotala(Double sumaTotala) {
        this.sumaTotala = sumaTotala;
    }

    public Furnizor getFurnizor() {
        return furnizor;
    }

    public void setFurnizor(Furnizor furnizor) {
        this.furnizor = furnizor;
    }

    public Double getRestPlata() {
        return restPlata;
    }

    public void setRestPlata(Double restPlata) {
        this.restPlata = restPlata;
    }

    public String getStatusFactura() {
        return statusFactura;
    }

    public void setStatusFactura(String statusFactura) {
        this.statusFactura = statusFactura;
    }
}

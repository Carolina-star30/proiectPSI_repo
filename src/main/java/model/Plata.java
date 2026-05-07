package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "plati")
public class Plata extends DocumentAbstractEntity {

    @Column(name = "suma_platii")
    private Double sumaPlata;

    @Column(name = "cont_bancar")
    private String contBancar;

    @Column(name = "referinta")
    private String referinta;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

    public Double getSumaPlata() {
        return sumaPlata;
    }

    public void setSumaPlata(Double sumaPlata) {
        this.sumaPlata = sumaPlata;
    }

    public String getContBancar() {
        return contBancar;
    }

    public void setContBancar(String contBancar) {
        this.contBancar = contBancar;
    }

    public String getReferinta() {
        return referinta;
    }

    public void setReferinta(String referinta) {
        this.referinta = referinta;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}

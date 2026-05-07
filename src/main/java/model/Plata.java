package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PLati")
public class Plata extends AbstractEntity{

    @Temporal(TemporalType.DATE)
    @Column(name = "data_platii")
    private Date datPlatii;

    @Column(name = "suma_platii")
    private Double sumaPlata;

    @Column(name = "cont_bancar")
    private String contBancar;

    @Column(name = "Referinta")
    private String referinta;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

    public Date getDatPlatii() {
        return datPlatii;
    }

    public void setDatPlatii(Date datPlatii) {
        this.datPlatii = datPlatii;
    }

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

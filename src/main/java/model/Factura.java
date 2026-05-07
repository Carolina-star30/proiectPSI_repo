package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "facturi")
public class Factura extends AbstractEntity{

    @Column(name = "numar_factura")
    private String numarFactura;

    @Temporal(TemporalType.DATE)
    private Date dataFactura;

    @Column(name = "suma_totala")
    private Double sumaTotala;

    @Column(name = "Rest_de_plata")
    private Double restPlata;

    @Column(name = "Status_factura")
    private String stastusFactura;

    @ManyToOne
    @JoinColumn(name = "id_furnizor")
    private Furnizor furnizor;

    public String getNumarFactura() {
        return numarFactura;
    }

    public void setNumarFactura(String numarFactura) {
        this.numarFactura = numarFactura;
    }

    public Date getDataFactura() {
        return dataFactura;
    }

    public void setDataFactura(Date dataFactura) {
        this.dataFactura = dataFactura;
    }

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

    public String getStastusFactura() {
        return stastusFactura;
    }

    public void setStastusFactura(String stastusFactura) {
        this.stastusFactura = stastusFactura;
    }
}

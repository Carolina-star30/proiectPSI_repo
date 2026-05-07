package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Facturi")
public class Factura extends AbstractEntity{

    @Column(name = "numar_factura")
    private String numarFactura;

    @Temporal(TemporalType.DATE)
    private Date dataFactura;

    @Column(name = "suma_totala")
    private Double sumaTotala;

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
}

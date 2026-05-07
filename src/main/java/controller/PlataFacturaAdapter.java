package controller;

import model.Banca;
import model.Factura;
import model.Furnizor;

import java.util.Date;
import  java.util.List;

public class PlataFacturaAdapter {

    //liste pt dropdown-uri, tabele din formular
    private List<Banca> listaBanci;
    private List<Furnizor> listaFurnizori;
    private List<Factura> listaFacturiNeachitate;

    //elem selctate de utiliz
    private Banca bancaSelectata;
    private Furnizor furnizorSelectat;
    private Factura facturaSelectata;
    private Double sumaPlata;
    private Date dataPlatii;
    private String referintaExtras;
    private Double soldDisponibilCont;

    public List<Banca> getListaBanci() {
        return listaBanci;
    }

    public void setListaBanci(List<Banca> listaBanci) {
        this.listaBanci = listaBanci;
    }

    public List<Furnizor> getListaFurnizori() {
        return listaFurnizori;
    }

    public void setListaFurnizori(List<Furnizor> listaFurnizori) {
        this.listaFurnizori = listaFurnizori;
    }

    public List<Factura> getListaFacturiNeachitate() {
        return listaFacturiNeachitate;
    }

    public void setListaFacturiNeachitate(List<Factura> listaFacturiNeachitate) {
        this.listaFacturiNeachitate = listaFacturiNeachitate;
    }

    public Banca getBancaSelectata() {
        return bancaSelectata;
    }

    public void setBancaSelectata(Banca bancaSelectata) {
        this.bancaSelectata = bancaSelectata;
    }

    public Furnizor getFurnizorSelectat() {
        return furnizorSelectat;
    }

    public void setFurnizorSelectat(Furnizor furnizorSelectat) {
        this.furnizorSelectat = furnizorSelectat;
    }

    public Factura getFacturaSelectata() {
        return facturaSelectata;
    }

    public void setFacturaSelectata(Factura facturaSelectata) {
        this.facturaSelectata = facturaSelectata;
    }

    public Double getSumaPlata() {
        return sumaPlata;
    }

    public void setSumaPlata(Double sumaPlata) {
        this.sumaPlata = sumaPlata;
    }

    public Date getDataPlatii() {
        return dataPlatii;
    }

    public void setDataPlatii(Date dataPlatii) {
        this.dataPlatii = dataPlatii;
    }

    public String getReferintaExtras() {
        return referintaExtras;
    }

    public void setReferintaExtras(String referintaExtrs) {
        this.referintaExtras = referintaExtrs;
    }

    public Double getSoldDisponibilCont() {
        return soldDisponibilCont;
    }

    public void setSoldDisponibilCont(Double soldDisponibilCont) {
        this.soldDisponibilCont = soldDisponibilCont;
    }
}

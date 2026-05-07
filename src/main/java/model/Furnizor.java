package model;

import javax.persistence.*;

@Entity
@Table(name = "furnizori")
public class Furnizor extends AbstractEntity{

    @Column(name = "nume_furnizor", nullable = false)
    private String nume;

    @Column(unique = true)
    private String CUI;

    private String adresa;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}

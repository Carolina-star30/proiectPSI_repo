package model;

import javax.persistence.*;

@Entity
@Table(name = "banci")

public class Banca extends AbstractEntity {

    @Column(name = "nume_banci")
    private String numeBanca;

    @Column(name = "iban")
    private String iban;

    public String getNumeBanca() {
        return numeBanca;
    }

    public void setNumeBanca(String numeBanca) {
        this.numeBanca = numeBanca;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}

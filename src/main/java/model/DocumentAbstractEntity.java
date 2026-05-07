package model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class DocumentAbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    protected Integer version;

    @Column(name = "numar_document", nullable = false)
    protected String numarDocument;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_document")
    protected Date dataDocument;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getNumarDocument() {
        return numarDocument;
    }

    public void setNumarDocument(String numarDocument) {
        this.numarDocument = numarDocument;
    }

    public Date getDataDocument() {
        return dataDocument;
    }

    public void setDataDocument(Date dataDocument) {
        this.dataDocument = dataDocument;
    }
}

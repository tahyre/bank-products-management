package edu.uqam.tp.bank.common.model;

import javax.persistence.*;

@Entity
@Table(name="produits")
@Access(value= AccessType.FIELD)
public class Produit {

    @Id
    @Column(name = "PRODUCT_ID", unique = true, nullable = false, columnDefinition="varchar2(40)")
    private String idProduit;

    @Column(name = "PRODUCT_DESCRIPTION", unique = false, nullable = true, columnDefinition="varchar2(200)")
    private String description;

    @Column(name = "PRODUCT_AUTO", unique = false, nullable = true, columnDefinition="BOOLEAN DEFAULT TRUE")
    private Boolean isAutomatique = Boolean.TRUE;

    public Produit() {

    }

    public Produit(String idProduit, String description, Boolean isAutomatique) {
        this.idProduit = idProduit;
        this.description = description;
        this.isAutomatique = isAutomatique;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

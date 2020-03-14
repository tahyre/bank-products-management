package edu.uqam.tp.bank.client.model;

public class Produit {

    private String idProduit;
    private String description;

    public Produit(String idProduit, String description) {
        this.idProduit = idProduit;
        this.description = description;
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

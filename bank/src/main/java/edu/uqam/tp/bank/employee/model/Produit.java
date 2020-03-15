package edu.uqam.tp.bank.employee.model;

public class Produit {

    private String idProduit;
    private String description;
    private Boolean isAutomatique;

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

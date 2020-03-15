package edu.uqam.tp.bank.client.model;

import java.util.List;

public class BankClient {
    private String name;
    private List<Produit> produits;

    public BankClient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}

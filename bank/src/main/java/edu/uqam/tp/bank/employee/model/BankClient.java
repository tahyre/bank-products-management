package edu.uqam.tp.bank.employee.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clients")
public class BankClient {

    @Id
    @Column(name = "CLIENT_NAME", nullable = false,columnDefinition="varchar2(40)")
    private String clientName;
    private List<Produit> produits;

    public BankClient() {
    }

    public BankClient(String clientName, List<Produit> produits) {
        this.clientName = clientName;
        this.produits = produits;
    }

    public BankClient(String name) {
        this.clientName = clientName;
    }

    public String getName() {
        return clientName;
    }

    public void setName(String name) {
        this.clientName = clientName;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

}

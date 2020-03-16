package edu.uqam.tp.bank.common.model;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Client.findByName", query = "SELECT client FROM Client client WHERE LOWER(client.clientName) = LOWER(?1)")
@Table(name="clients")
@Access(value= AccessType.FIELD)
public class Client {

    @Id
    @Column(name = "CLIENT_NAME", unique = true, nullable = false, columnDefinition="varchar2(40)")
    private String clientName;

    @ElementCollection
    @CollectionTable(name = "clients_produits", joinColumns = @JoinColumn(name = "CLIENT_NAME"))
    private List<Produit> produits;

    public Client() {
    }

    public Client(String clientName, List<Produit> produits) {
        this.clientName = clientName;
        this.produits = produits;
    }

    public Client(String clientName) {
        this.clientName = clientName;
        this.produits = new ArrayList<>();
    }

    public String getName() {
        return clientName;
    }

    public void setName(String clientName) {
        this.clientName = clientName;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

}

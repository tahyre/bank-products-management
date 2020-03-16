package edu.uqam.tp.bank.client;

import edu.uqam.tp.bank.common.dao.ClientRepository;
import edu.uqam.tp.bank.common.dao.ProductRepository;
import edu.uqam.tp.bank.common.model.Client;
import edu.uqam.tp.bank.common.model.Produit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class ClientRestServiceTest {

    @Autowired
    protected ClientRepository clientRepository;

    @Autowired
    protected ProductRepository productRepository;


    @Test
    void testGetClientProducts(){
        Client client = new Client("Jhon Smith");
        List<Produit> listProduits = new ArrayList<>();

        Produit produit1 = new Produit("Visa", "Carte Visa S", Boolean.TRUE);
        productRepository.save(produit1);

        Produit produit2 = new Produit("Master", "Carte Master", Boolean.TRUE);
        productRepository.save(produit2);

        listProduits.add(produit1);
        listProduits.add(produit2);

        client.setProduits(listProduits);

        clientRepository.save(client);

        List<Produit> test = productRepository.findAll();

        String clientName = test.get(0).getIdProduit();

        assertEquals(clientName, "Visa");
    }
}

package edu.uqam.tp.bank.client.service;


import edu.uqam.tp.bank.common.dao.ClientRepository;
import edu.uqam.tp.bank.common.dao.ProductRepository;
import edu.uqam.tp.bank.common.model.Client;
import edu.uqam.tp.bank.common.model.Produit;
import edu.uqam.tp.bank.employee.service.ApiBankEmployeeRestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ApiBankClientRestServiceImpl implements ApiBankClientRestService {
    private static final Logger logger = LoggerFactory.getLogger(ApiBankEmployeeRestServiceImpl.class);

    private ClientRepository clientRepository;

    private ProductRepository productRepository;

    public ApiBankClientRestServiceImpl(ClientRepository clientRepository, ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Object> getClientProductsByName(String clientName) throws IOException {

        logger.trace( "Client name dans GET : " + clientName);

        List<Client> ourClients = clientRepository.findByName(clientName);

        if (CollectionUtils.isEmpty(ourClients)) {
            initialize(clientName);
        }
        Client ourClient = clientRepository.findByName(clientName).get(0);

        return new ResponseEntity<Object>(ourClient, HttpStatus.OK);
    }

    private void initialize(String ClientName) {
        Client client = new Client(ClientName);
        List<Produit> listProduits = new ArrayList<>();

        Produit produit1 = new Produit("Visa", "Carte Visa S", Boolean.TRUE);
        productRepository.save(produit1);

        Produit produit2 = new Produit("Master", "Carte Master", Boolean.TRUE);
        productRepository.save(produit2);

        listProduits.add(produit1);
        listProduits.add(produit2);

        client.setProduits(listProduits);

        clientRepository.save(client);
    }

}

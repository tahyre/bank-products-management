package edu.uqam.tp.bank.employee.service;

import edu.uqam.tp.bank.employee.service.ApiBankEmployeeRestService;
import edu.uqam.tp.bank.common.dao.ClientRepository;
import edu.uqam.tp.bank.common.dao.ProductRepository;
import edu.uqam.tp.bank.common.model.Client;
import edu.uqam.tp.bank.common.model.Produit;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ApiBankEmployeeRestServiceImpl implements ApiBankEmployeeRestService {
    private static final Logger logger = LoggerFactory.getLogger(ApiBankEmployeeRestServiceImpl.class);
    private static final String PROPER_FILE = "client-mocked-data.properties";

    private ClientRepository clientRepository;

    private ProductRepository productRepository;

    public ApiBankEmployeeRestServiceImpl(ClientRepository clientRepository, ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<String> putClientByName(String clientName) throws IOException {

        logger.trace( "Client name dans PUT : " + clientName);

        clientRepository.save(new Client(clientName));

        return new ResponseEntity<String>("SUCCES", HttpStatus.OK);
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

        //Produit produit3 = new Produit("Hypoteque", "Sweet Home", Boolean.TRUE);
        //productRepository.save(produit3);

        listProduits.add(produit1);
        listProduits.add(produit2);
        //listProduits.add(produit3);

        client.setProduits(listProduits);

        clientRepository.save(client);
    }
}

package edu.uqam.tp.bank.client;


import edu.uqam.tp.bank.BankApplication;
import edu.uqam.tp.bank.common.dao.ClientRepository;
import edu.uqam.tp.bank.common.dao.ProductRepository;
import edu.uqam.tp.bank.common.model.Client;
import edu.uqam.tp.bank.common.model.Produit;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BankApplication.class)
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ClientRestControllerTest {

    @Value("${server.port}")
    int port;

    @Autowired
    private TestRestTemplate restTemplate;


    /**
     *  Ici on test que on demande la liste des produits d'un client a la Bank en utilisant la methode GET
     */
    @Test
    public void testGetClientProducts() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        String clientName = "Jhon Smith";

        ResponseEntity<String> response = restTemplate.exchange( "http://localhost:9999/api/bank/client/list-client-products/" + clientName ,
                HttpMethod.GET, entity, String.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response.getBody());

    }
}

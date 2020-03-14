package edu.uqam.tp.bank.employee;

import com.jayway.restassured.RestAssured;
import edu.uqam.tp.bank.BankApplication;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BankApplication.class)
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeRestControllerTest {

    @Value("${server.port}")
    int port;

    @Autowired
    private TestRestTemplate restTemplate;

     /**
     *  Ici on test que on ajout un client a la Bank en utilisant la methode POST
     */
    @Test
    public void testPutClientByName() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange( "http://localhost:9999/api/bank/employee/add-client/{name}",
                HttpMethod.PUT, entity, String.class);

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    /**
     *  Ici on test que on ajout un client a la Bank en utilisant la methode POST
     */
    @Test
    public void testGetClientProducts() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange( "http://localhost:9999/api/bank/employee/list-client-products/{name}",
                HttpMethod.GET, entity, String.class);

        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


}

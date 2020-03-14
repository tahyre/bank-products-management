package edu.uqam.tp.bank.client.controller;

/*
*  Rest API pour les fonctions de Employee
*/

import edu.uqam.tp.bank.client.service.ApiBankEmployeeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Api(value = "bank-employee")
@RestController
@RequestMapping(value = "/api/bank")
public class ApiBankEmployeeController {
    @Autowired
    private ApiBankEmployeeService apiBankEmployeeService;

    @RequestMapping(value = "/employee/add-client/{clientName}", produces = {"application/json"}, method = RequestMethod.PUT)
    public ResponseEntity<String> putClientByNameUsingPUT(@PathVariable("clientName") String clientName) throws IOException {
        return apiBankEmployeeService.putClientByName(clientName);
    }

    @RequestMapping(value = "/employee/list-client-products/{clientName}", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<String> getClientProductsByNameUsingGET(@PathVariable("clientName")  String clientName) throws IOException {
        return apiBankEmployeeService.getClientProductsByName(clientName);
    }
}

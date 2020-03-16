package edu.uqam.tp.bank.client.controller;

/*
 *  Rest API pour les fonctions de Client
 */

import edu.uqam.tp.bank.client.service.ApiBankClientRestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Api(value = "bank-client")
@RestController
@RequestMapping(value = "/api/bank")
public class ApiBankClientRestController {
    @Autowired
    private ApiBankClientRestService apiBankClientRestService;

    @RequestMapping(value = "/client/list-client-products/{clientName}", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<Object> getClientProductsByNameUsingGET(@PathVariable("clientName")  String clientName) throws IOException {
        return apiBankClientRestService.getClientProductsByName(clientName);
    }
}

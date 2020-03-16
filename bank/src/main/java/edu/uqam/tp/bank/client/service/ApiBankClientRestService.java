package edu.uqam.tp.bank.client.service;

import org.springframework.http.ResponseEntity;
import java.io.IOException;

public interface ApiBankClientRestService {
    ResponseEntity<Object> getClientProductsByName(String clientName) throws IOException;
}
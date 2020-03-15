package edu.uqam.tp.bank.client.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ApiBankEmployeeService {
    ResponseEntity<String> putClientByName(String clientName) throws IOException;
    ResponseEntity<String> getClientProductsByName(String clientName) throws IOException;
}

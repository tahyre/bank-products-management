package edu.uqam.tp.bank.employee.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

public interface ApiBankEmployeeRestService {
    ResponseEntity<String> putClientByName(String clientName) throws IOException;
    ResponseEntity<Object> getClientProductsByName(String clientName) throws IOException;
}

package edu.uqam.tp.bank.employee.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uqam.tp.bank.client.controller.ApiBankEmployeeController;
import edu.uqam.tp.bank.employee.model.BankClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

@Service
public class ApiBankEmployeeServiceImpl implements edu.uqam.tp.bank.client.service.ApiBankEmployeeService {
    private static final Logger LOG = LoggerFactory.getLogger(ApiBankEmployeeServiceImpl.class);
    private static final String PROPER_FILE = "client-mocked-data.properties";

    @Autowired
    private ObjectMapper objectMapper;

    private BankClientRepository bankClientRepository;

    public ApiBankEmployeeServiceImpl(BankClientRepository bankClientRepository) {
        this.bankClientRepository = bankClientRepository;
    }

    @Override
    public ResponseEntity<String> putClientByName(String clientName) throws IOException {

        System.out.println("Client name  " + clientName);
        bankClientRepository.save(new BankClient(clientName));

        return new ResponseEntity<String>("SUCCES", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getClientProductsByName(String clientName) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        String responseString = new String(out.toByteArray());
        return new ResponseEntity<String>(responseString, HttpStatus.OK);
    }
}

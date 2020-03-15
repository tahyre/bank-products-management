package edu.uqam.tp.bank.employee.service;

import edu.uqam.tp.bank.employee.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ApiBankEmployeeServiceImpl implements edu.uqam.tp.bank.client.service.ApiBankEmployeeService {
    private static final Logger LOG = LoggerFactory.getLogger(ApiBankEmployeeServiceImpl.class);
    private static final String PROPER_FILE = "client-mocked-data.properties";

    private ClientRepository clientRepository;

    public ApiBankEmployeeServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ResponseEntity<String> putClientByName(String clientName) throws IOException {

        clientRepository.save(new Client(clientName));

        return new ResponseEntity<String>("SUCCES", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getClientProductsByName(String clientName) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        String responseString = new String(out.toByteArray());
        return new ResponseEntity<String>(responseString, HttpStatus.OK);
    }
}

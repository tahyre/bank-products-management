package edu.uqam.tp.bank.client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ApiBankEmployeeServiceImpl implements ApiBankEmployeeService {
    private static final Logger LOG = LoggerFactory.getLogger(ApiBankEmployeeServiceImpl.class);

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public ResponseEntity<String> putClientByName(String clientName) throws IOException {

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        String responseString = new String(out.toByteArray());
        return new ResponseEntity<String>(responseString, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getClientProductsByName(String clientName) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        String responseString = new String(out.toByteArray());
        return new ResponseEntity<String>(responseString, HttpStatus.OK);
    }
}

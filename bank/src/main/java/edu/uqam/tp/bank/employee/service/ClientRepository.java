package edu.uqam.tp.bank.employee.service;

import edu.uqam.tp.bank.employee.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Long> {

}

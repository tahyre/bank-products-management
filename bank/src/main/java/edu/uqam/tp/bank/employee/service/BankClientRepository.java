package edu.uqam.tp.bank.employee.service;

import edu.uqam.tp.bank.employee.model.BankClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bankClientRepository")
public interface BankClientRepository extends JpaRepository<BankClient, Long> {

}

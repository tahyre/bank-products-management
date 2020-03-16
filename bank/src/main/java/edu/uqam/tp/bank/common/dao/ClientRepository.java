package edu.uqam.tp.bank.common.dao;

import edu.uqam.tp.bank.common.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Long> {
    public List<Client> findByName(String clientName);
}

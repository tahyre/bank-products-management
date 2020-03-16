package edu.uqam.tp.bank.common.dao;

import edu.uqam.tp.bank.common.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Produit, Long> {

}
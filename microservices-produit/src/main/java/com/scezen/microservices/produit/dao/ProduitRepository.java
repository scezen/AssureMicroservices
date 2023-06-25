package com.scezen.microservices.produit.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.scezen.microservices.produit.model.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Integer> {

	Optional<Produit> findById(Integer Id);
	
}

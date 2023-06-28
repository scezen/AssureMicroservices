package com.scezen.microservices.assure.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.scezen.microservices.assure.model.*;

public interface AssureRepository extends CrudRepository<Assure, Integer> {
	
	List<Assure> findByPrenomAndNom(String prenom, String nom);
	List<Assure> findByNumeroPersonne(Long numeroPersonne); 

}

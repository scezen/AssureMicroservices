package com.scezen.microservices.dao;

import org.springframework.data.repository.CrudRepository;

import com.scezen.microservices.modele.*;

public interface AssureRepository extends CrudRepository<Assure, Integer> {
	
	void deleteById(Assure id);

}

package com.scezen.microservices.assure.dao;

import org.springframework.data.repository.CrudRepository;

import com.scezen.microservices.assure.model.*;

public interface AssureRepository extends CrudRepository<Assure, Integer> {
	
	void deleteById(Assure id);

}

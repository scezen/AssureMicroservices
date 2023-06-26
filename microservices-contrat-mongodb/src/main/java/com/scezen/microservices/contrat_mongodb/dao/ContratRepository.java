package com.scezen.microservices.contrat_mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.scezen.microservices.contrat_mongodb.model.Contrat;

public interface ContratRepository extends MongoRepository<Contrat, String> {

	Contrat findByNumeroContrat(Long numeroContrat);
    Contrat findByNumeroAssure(Long numeroAssure);
    Contrat findByNumeroProduit(Long numeroProduit);
	
}

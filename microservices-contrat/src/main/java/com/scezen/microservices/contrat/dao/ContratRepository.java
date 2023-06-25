package com.scezen.microservices.contrat.dao;

import org.springframework.data.repository.CrudRepository;

import com.scezen.microservices.contrat.model.Contrat;

public interface ContratRepository extends CrudRepository<Contrat, Integer>{

	Contrat findByNumeroContrat(Long numeroContrat);
    Contrat findByNumeroAssure(Long numeroAssure);
    Contrat findByNumeroProduit(Long numeroProduit);
	
}

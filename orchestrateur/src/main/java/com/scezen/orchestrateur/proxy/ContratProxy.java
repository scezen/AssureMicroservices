package com.scezen.orchestrateur.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.scezen.orchestrateur.dto.ContratDto;

@FeignClient(name = "microserviceContratMongodb", url = "localhost:9996/contrats")
public interface ContratProxy {
	
	@PostMapping(path = "/creerContrat")
	public ContratDto createContrat(@RequestBody ContratDto contrat);

}

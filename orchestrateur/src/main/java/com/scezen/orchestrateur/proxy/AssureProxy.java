package com.scezen.orchestrateur.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.scezen.orchestrateur.dto.AssureDto;

@FeignClient(name = "microserviceAssure", url = "localhost:9999/previt")
public interface AssureProxy {
	
	@GetMapping(path = "/cherchePrenomNom/{prenom}/{nom}")
	public List<AssureDto> findAssure(@PathVariable String prenom,@PathVariable String nom);
	
	@GetMapping(path = "/listerLesAssures")
	public List<AssureDto> getAllAssures();

}

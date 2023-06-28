package com.scezen.orchestrateur.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.scezen.orchestrateur.dto.ProduitDto;

@FeignClient(name = "microserviceProduit", url = "http://localhost:9998/produits")
public interface ProduitProxy {
	
    @GetMapping("/listerLesProduits")
    List<ProduitDto> getAllProduits();
    
    @GetMapping("/rechercherNumeroProduit/{numeroProduit}")
    List<ProduitDto> rechercherProduitNumeroProduit(@PathVariable("numeroProduit") Long numeroProduit);

}

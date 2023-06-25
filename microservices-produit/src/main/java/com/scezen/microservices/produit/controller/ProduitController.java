package com.scezen.microservices.produit.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.scezen.microservices.produit.dao.ProduitRepository;
import com.scezen.microservices.produit.model.Produit;

@RestController
@RequestMapping("/produits")
public class ProduitController {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@PostMapping(path = "/creerProduit")
	public ResponseEntity<Void> creerProduit(@RequestBody Produit produit) {
		Produit creerProduit = produitRepository.save(produit);
		
		if (creerProduit == null)
			return ResponseEntity.noContent() .build();
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(creerProduit.getId()).toUri();
		
		
		return ResponseEntity.created(uri).build();
	}	
	
    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Integer id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID Produit inexistant: " + id));
    }
	

}

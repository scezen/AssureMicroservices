package com.scezen.microservices.produit.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.scezen.microservices.produit.dao.ProduitRepository;
import com.scezen.microservices.produit.model.Produit;

@RestController
@RequestMapping("/produits")
public class ProduitController {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	
	// Crée un nouveau produit
	
	@PostMapping(path = "/creerProduit")
	public ResponseEntity<Void> creerProduit(@RequestBody Produit produit) {
		
		Produit creerProduit = produitRepository.save(produit);
		
		if (creerProduit == null)
			return ResponseEntity.noContent().build();
		
		// Construit l'URI de la ressource créée
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(creerProduit.getId()).toUri();
		
		// Retourne une réponse avec le code de statut 201 Created et l'URI de la ressource créée
		return ResponseEntity.created(uri).build();
	}	
	
	
	// Recherche un produit par son numéro
	
	@GetMapping(path="/rechercherNumeroProduit/{numeroProduit}")
	public List<Produit> rechercherProduitNumeroProduit(@PathVariable Long numeroProduit) {
		
		// Effectue la recherche des produits correspondant au numéro donné
		List<Produit> produits = produitRepository.findByNumeroProduit(numeroProduit);
		
		// Retourne la liste des produits trouvés
        return produits;
	}
	
	
	// Liste tous les produits
	
	@GetMapping(path="/listerLesProduits")
	public @ResponseBody Iterable<Produit> getAllProduits() {
		
		// Récupère tous les produits de la base de données
		return produitRepository.findAll();
	}
}

package com.scezen.microservices.assure.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.scezen.microservices.assure.dao.AssureRepository;
import com.scezen.microservices.assure.model.Assure;

@RestController
@RequestMapping(path = "/previt")
public class AssureController {

	@Autowired
	private AssureRepository assureRepository;

	// Créer un nouvel Assuré
	@PostMapping(path = "/ajouterAssure")
	public ResponseEntity<Void> creerAssure(@Valid @RequestBody Assure assure) {
		Assure assureAjoute = assureRepository.save(assure);

		if (assureAjoute == null)
			return ResponseEntity.noContent().build();

		// Créer l'URI pour le nouvel Assuré créé
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(assureAjoute.getId())
				.toUri();

		// Retourner une réponse avec l'URI créée
		return ResponseEntity.created(uri).build();
	}

	// Obtenir tous les Assurés
	@GetMapping(path = "/listerLesAssures")
	public @ResponseBody Iterable<Assure> getAllAssures() {
		return assureRepository.findAll();
	}

	// Supprimer un Assuré par ID
	@DeleteMapping(path = "/Assure/{id}")
	public void supprimerAssurer(@PathVariable Integer id) {
		assureRepository.deleteById(id);
	}

	// Mettre à jour un Assuré
	@PutMapping(path = "/modifierAssure")
	public void modifierAssure(@RequestBody Assure assure) {
		// Sauvegarder l'Assuré modifié
		assureRepository.save(assure);
	}

	// Trouver un Assuré par prénom et nom
	@GetMapping(path="/cherchePrenomNom/{prenom}/{nom}")
	public List<Assure> rechercherAssureNomPrenom(@PathVariable String prenom, @PathVariable String nom) {
		List<Assure> assuresList  = assureRepository.findByPrenomAndNom(prenom, nom);
		return assuresList;

	}

}

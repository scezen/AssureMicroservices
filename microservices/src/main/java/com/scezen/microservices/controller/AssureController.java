package com.scezen.microservices.controller;

import java.net.URI;
import java.util.Optional;

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

import com.scezen.microservices.dao.AssureRepository;
import com.scezen.microservices.modele.Assure;

@RestController
@RequestMapping(path = "/previt")
public class AssureController {
	
	@Autowired
	private AssureRepository assureRepository;

	@PostMapping(path = "/ajouterAssure")
	public ResponseEntity<Void> creerAssure(@RequestBody Assure assure) {
		Assure assureAjoute = assureRepository.save(assure);

		if (assureAjoute == null)
			return ResponseEntity.noContent().build();

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(assureAjoute.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping(path = "/listerLesAssures")
	public @ResponseBody Iterable<Assure> getAllAssures() {
		return assureRepository.findAll();
	}
	
	@DeleteMapping (path="/Assure/{id}")     
    public void supprimerAssurer(@PathVariable Integer id) {
     assureRepository.deleteById(id);        
    }
	
	@PutMapping (path="/modifierAssure")    
    public void modifierAssure(@RequestBody Assure assure) {

      assureRepository.save(assure);
    }
}

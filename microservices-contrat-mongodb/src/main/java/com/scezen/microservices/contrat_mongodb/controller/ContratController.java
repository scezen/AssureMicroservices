package com.scezen.microservices.contrat_mongodb.controller;

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

import com.scezen.microservices.contrat_mongodb.dao.ContratRepository;
import com.scezen.microservices.contrat_mongodb.model.Contrat;

@RestController
@RequestMapping("/contrats")
public class ContratController {

    private final ContratRepository contratRepository;

    @Autowired
    public ContratController(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    // Crée un contrat
    @PostMapping("/creerContrat")
    public ResponseEntity<Void> createContrat(@RequestBody Contrat contrat) {
        Contrat creerContrat = contratRepository.save(contrat);

        if (creerContrat == null)
            return ResponseEntity.noContent().build();

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(creerContrat.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    
    // Récupère un contrat en fonction de son identifiant
    
    @GetMapping("/{id}")
    public ResponseEntity<Contrat> findById(@PathVariable String id) {
        Optional<Contrat> optionalContrat = contratRepository.findById(id);
        return optionalContrat.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Récupère un contrat en fonction du numéro de contrat
    
    @GetMapping("/NumeroContrat/{numeroContrat}")
    public ResponseEntity<Contrat> getContratByNumeroContrat(@PathVariable Long numeroContrat) {
        Contrat contrat = contratRepository.findByNumeroContrat(numeroContrat);
        return ResponseEntity.of(Optional.ofNullable(contrat));
    }

    // Récupère un contrat en fonction du numéro d'assuré
    
    @GetMapping("/NumeroAssure/{numeroAssure}")
    public ResponseEntity<Contrat> getContratByNumeroAssure(@PathVariable Long numeroAssure) {
        Contrat contrat = contratRepository.findByNumeroAssure(numeroAssure);
        return ResponseEntity.of(Optional.ofNullable(contrat));
    }

    // Récupère un contrat en fonction du numéro de produit
    
    @GetMapping("/NumeroProduit/{numeroProduit}")
    public ResponseEntity<Contrat> getContratByNumeroProduit(@PathVariable Long numeroProduit) {
        Contrat contrat = contratRepository.findByNumeroProduit(numeroProduit);
        return ResponseEntity.of(Optional.ofNullable(contrat));
    }
}

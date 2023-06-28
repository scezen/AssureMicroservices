package com.scezen.orchestrateur.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.scezen.orchestrateur.dto.AssureDto;
import com.scezen.orchestrateur.dto.ProduitDto;
import com.scezen.orchestrateur.dto.ContratDto;
import com.scezen.orchestrateur.proxy.AssureProxy;
import com.scezen.orchestrateur.proxy.ContratProxy;
import com.scezen.orchestrateur.proxy.ProduitProxy;

@Controller
public class OrchestrateurController {

	@Autowired
	private AssureProxy assureProxy;

	@Autowired
	private ProduitProxy produitProxy;
	
	@Autowired
	private ContratProxy contratProxy;

	private Logger log = LoggerFactory.getLogger(OrchestrateurController.class);

	// Méthode gérant la requête GET sur "/"

	@GetMapping("/")
	public String home(Model model) {

		// Appel du proxy pour récupérer la liste des AssureDto
		List<AssureDto> assures = assureProxy.getAllAssures();

		// Ajout de la liste des AssureDto dans le modèle avec la clé "listeAssure"
		model.addAttribute("listeAssure", assures);

		// Instanciation d'un nouvel objet AssureDto dans le modèle avec la clé "assure"
		AssureDto assure = new AssureDto();

		model.addAttribute("assure", assure);
		// Renvoie du nom de la vue "index"
		return "index";
	}

	// Méthode gérant la requête POST sur "/saisir-assure"

	@PostMapping(value = "/saisir-assure")
	public String saisirAssure(AssureDto assure, Model model) {

		// Enregistrement d'un message de log
		log.info("Sending request to saisirAssure");

		// Appel du proxy pour rechercher des AssureDto en fonction du prénom et du nom
		List<AssureDto> assures = assureProxy.findAssure(assure.getPrenom(), assure.getNom());

		// Ajout de la liste des AssureDto dans le modèle avec la clé "listeAssure"
		model.addAttribute("listeAssure", assures);

		// Renvoie du nom de la vue "ListeAssure"
		return "ListeAssure";
	}


	@GetMapping("/Assure/numeroAssure/{numeroAssure}")
	public String getAssureDetails(@PathVariable Long numeroAssure, Model model) {

	    // Get the list of produits for the given assure
	    List<ProduitDto> produits = produitProxy.getAllProduits();
	    
	    // Add the produits to the model
	    model.addAttribute("produits", produits);
	    
	    // Pass the numeroAssure to the view
	    model.addAttribute("numeroAssure", numeroAssure);

	    // Return the name of the view Thymeleaf to display
	    return "assureDetails";
	}
	
	@GetMapping(value = "/affecterNumeroProduit/{numeroAssure}/{numeroProduit}")
	public String finaliserContract(@PathVariable Long numeroAssure, @PathVariable Long numeroProduit, Model model) {
		
		ContratDto contrat = new ContratDto();
		
		contrat.setNumeroAssure(numeroAssure);
		contrat.setNumeroProduit(numeroProduit);
		
		model.addAttribute("contrat",contrat);
		
		return "contratForm";
		
	}
	
	@PostMapping(value = "/valider-contrat")
	public String validerContrat(ContratDto contrat, Model model) {
		ContratDto createdContrat = contratProxy.createContrat(contrat);
		
		model.addAttribute("contrat",createdContrat);
		
		return "contratFinal";
	}

}

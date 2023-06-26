package com.scezen.orchestrateur.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.scezen.orchestrateur.dto.AssureDto;
import com.scezen.orchestrateur.proxy.AssureProxy;

@Controller
public class OrchestrateurController {

	@Autowired
	public AssureProxy assureProxy;
	
	// Même chose pour produit et contrat
	
	// Création d'un log
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	// Appel localhost:8080 (port par défaut)
	
	// Tomcat intercepte la requête "/"
	// On utilise Spring MVC (fournit des objets déjà pret à l'emploi)
				// Servlet (DispatcherServlet) --> Appelée en premier (avant la view) : met en place la sécurité
				// Model --> hashMap(type) | clé associée à un objet Java. Couche intermédiaire entre la View et le Controller
	
	@GetMapping("/")
	public String home(Model model) {
		
//		// On récupère la liste des AssureDto avec le proxy
		List<AssureDto> assures = assureProxy.getAllAssures();
//		
//		// On place le résultat dans le modèle en lui attribuant la clé listeAssure, qui sera passée à la View
		model.addAttribute("listeAssure",assures);
		
		// Instanciation d'un objet AssureDto qui sera rempli par le formulaire
		AssureDto assure = new AssureDto();
		
		model.addAttribute("assure",assure);
		
		return "index";
	}
	
	@PostMapping(value = "/saisir-assure")
	public String saisirAssure(AssureDto assure, Model model){
		log.info("---------------------------- Envoi requête vers saisirAssure");
		
		// On récupère la liste avec la méthode qui cherche en fonction du prénom et du nom de ce qui a été renseigné dans le formulaire
		List<AssureDto> assures =  assureProxy.findAssure(assure.getPrenom(), assure.getNom());
		
		model.addAttribute("assures", assures);
		return "ListeAssure";
	}
}


package com.scezen.microservices.modele;

import javax.persistence.Entity;

@Entity
public class Assure extends Personne {

	public String dossierMedical;
	public Long numeroAssure;
	
	public String getDossierMedical() {
		return dossierMedical;
	}
	public void setDossierMedical(String dossierMedical) {
		this.dossierMedical = dossierMedical;
	}
	public Long getNumeroAssure() {
		return numeroAssure;
	}
	public void setNumeroAssure(Long numeroAssure) {
		this.numeroAssure = numeroAssure;
	}

}
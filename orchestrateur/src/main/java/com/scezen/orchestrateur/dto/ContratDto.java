package com.scezen.orchestrateur.dto;

public class ContratDto {
	
	public String dateDebut;
	
	public Long numeroContrat;
	
	public Long numeroAssure;
	
	public Long numeroProduit;

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Long getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(Long numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public Long getNumeroAssure() {
		return numeroAssure;
	}

	public void setNumeroAssure(Long numeroAssure) {
		this.numeroAssure = numeroAssure;
	}

	public Long getNumeroProduit() {
		return numeroProduit;
	}

	public void setNumeroProduit(Long numeroProduit) {
		this.numeroProduit = numeroProduit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContratDto [dateDebut=");
		builder.append(dateDebut);
		builder.append(", numeroContrat=");
		builder.append(numeroContrat);
		builder.append(", numeroAssure=");
		builder.append(numeroAssure);
		builder.append(", numeroProduit=");
		builder.append(numeroProduit);
		builder.append("]");
		return builder.toString();
	}
	
}

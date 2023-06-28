package com.scezen.orchestrateur.dto;

public class ProduitDto {

	private String libelle;

	private Long numeroProduit;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
		builder.append("ProduitDto [libelle=");
		builder.append(libelle);
		builder.append(", numeroProduit=");
		builder.append(numeroProduit);
		builder.append("]");
		return builder.toString();
	}
}

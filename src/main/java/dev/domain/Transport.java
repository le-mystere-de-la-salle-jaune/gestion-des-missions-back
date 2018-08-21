package dev.domain;

public enum Transport {
	AVION("Avion"), COVOITURAGE("Covoiturage"), TRAIN("Train"), VOITURE_DE_SERVICE("Voiture de service");

	private String libelle;

	private Transport(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return this.libelle;
	}
}

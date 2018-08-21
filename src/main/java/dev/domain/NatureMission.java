package dev.domain;

import javax.persistence.Entity;

@Entity
public class NatureMission extends BaseEntity {

	private String libelle;
	private boolean facturee;
	private boolean versementPrime;
	private double tjm;
	private double pourcentage;

	public NatureMission() {
		super();
	}

	public NatureMission(String libelle, boolean facturee, boolean versementPrime, double tjm, double pourcentage) {
		super();
		this.libelle = libelle;
		this.facturee = facturee;
		this.versementPrime = versementPrime;
		this.tjm = tjm;
		this.pourcentage = pourcentage;
	}

	public NatureMission(String libelle) {
		super();
		this.libelle = libelle;
		this.facturee = false;
		this.versementPrime = false;
		this.tjm = 0;
		this.pourcentage = 0;
	}

	// NatureMission n'a pas de VM, on renvoit donc directement l'entité
	@Override
	public Base toVM() {
		return this;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public boolean isFacturee() {
		return facturee;
	}

	public void setFacturee(boolean facturee) {
		this.facturee = facturee;
	}

	public boolean isVersementPrime() {
		return versementPrime;
	}

	public void setVersementPrime(boolean versementPrime) {
		this.versementPrime = versementPrime;
	}

	public double getTjm() {
		return tjm;
	}

	public void setTjm(double tjm) {
		this.tjm = tjm;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}

}

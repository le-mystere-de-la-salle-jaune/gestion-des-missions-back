package dev.controller.vm;

import java.time.LocalDate;

import dev.domain.NatureMission;

public class NatureMissionVM extends BaseVM {

	private String libelle;
	private boolean facturee;
	private boolean versementPrime;
	private double tjm;
	private double pourcentage;
	private LocalDate debut;
	private LocalDate expiration;

	public NatureMissionVM() {
		super();
	}

	public NatureMissionVM(String libelle, boolean facturee, boolean versementPrime, double tjm, double pourcentage) {
		super();
		this.libelle = libelle;
		this.facturee = facturee;
		this.versementPrime = versementPrime;
		this.tjm = tjm;
		this.pourcentage = pourcentage;
	}

	public NatureMissionVM(String libelle) {
		super();
		this.libelle = libelle;
		this.facturee = false;
		this.versementPrime = false;
		this.tjm = 0;
		this.pourcentage = 0;
	}

	public NatureMissionVM(NatureMission natureMission) {
		this(natureMission.getLibelle(), natureMission.isFacturee(), natureMission.isVersementPrime(),
				natureMission.getTjm(), natureMission.getPourcentage());
		this.setId(natureMission.getId());
		this.setDebut(natureMission.getDebut());
		this.setExpiration(natureMission.getExpiration());
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

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public LocalDate getExpiration() {
		return expiration;
	}

	public void setExpiration(LocalDate expiration) {
		this.expiration = expiration;
	}

}

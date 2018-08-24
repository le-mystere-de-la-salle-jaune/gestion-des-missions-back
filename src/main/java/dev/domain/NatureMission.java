package dev.domain;

import java.time.LocalDate;

import javax.persistence.Entity;

import dev.controller.vm.NatureMissionVM;

@Entity
public class NatureMission extends BaseEntity {

	private String libelle;
	private boolean facturee;
	private boolean versementPrime;
	private double tjm;
	private double pourcentage;
	private LocalDate debut;
	private LocalDate expiration;

	public NatureMission() {
		super();
		this.debut = LocalDate.now();
	}

	public NatureMission(String libelle, boolean facturee, boolean versementPrime, double tjm, double pourcentage) {
		super();
		this.libelle = libelle;
		this.facturee = facturee;
		this.versementPrime = versementPrime;
		this.tjm = tjm;
		this.pourcentage = pourcentage;
		this.debut = LocalDate.now();
	}

	public NatureMission(String libelle) {
		super();
		this.libelle = libelle;
		this.facturee = false;
		this.versementPrime = false;
		this.tjm = 0;
		this.pourcentage = 0;
		this.debut = LocalDate.now();
	}

	public NatureMission(NatureMissionVM natureMissionVM) {
		this(natureMissionVM.getLibelle(), natureMissionVM.isFacturee(), natureMissionVM.isVersementPrime(),
				natureMissionVM.getTjm(), natureMissionVM.getPourcentage());
		this.setId(natureMissionVM.getId());
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

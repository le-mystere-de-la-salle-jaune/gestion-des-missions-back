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
	private LocalDate dateDebutValidite;
	private LocalDate dateFinValidite;

	public NatureMission() {
		super();
		this.dateDebutValidite = LocalDate.now();
	}

	public NatureMission(String libelle, boolean facturee, boolean versementPrime, double tjm, double pourcentage) {
		this();
		this.libelle = libelle;
		this.facturee = facturee;
		this.versementPrime = versementPrime;
		this.tjm = tjm;
		this.pourcentage = pourcentage;
	}

	public NatureMission(String libelle, boolean facturee, boolean versementPrime, double tjm, double pourcentage,
			LocalDate dateDebutValidite, LocalDate dateFinValidite) {
		this(libelle, facturee, versementPrime, tjm, pourcentage);
		this.dateDebutValidite = dateDebutValidite;
		this.dateFinValidite = dateFinValidite;
	}

	public NatureMission(NatureMissionVM natureMissionVM) {
		this(natureMissionVM.getLibelle(), natureMissionVM.isFacturee(), natureMissionVM.isVersementPrime(),
				natureMissionVM.getTjm(), natureMissionVM.getPourcentage(), natureMissionVM.getDateDebutValidite(),
				natureMissionVM.getDateFinValidite());
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

	public LocalDate getDateDebutValidite() {
		return dateDebutValidite;
	}

	public void setDateDebutValidite(LocalDate debut) {
		this.dateDebutValidite = debut;
	}

	public LocalDate getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(LocalDate expiration) {
		this.dateFinValidite = expiration;
	}

}

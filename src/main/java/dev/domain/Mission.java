package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import dev.controller.vm.MissionVM;

@Entity
public class Mission extends BaseEntity {
	private Statut statut;
	private LocalDateTime dateDebut;
	private LocalDateTime datefin;
	private String villeDepart;
	private String villeArrivee;
	private Transport transport;
	private Double montantPrime;

	public Mission() {
		super();
	}

	public Mission(LocalDateTime dateDebut, LocalDateTime datefin, String villeDepart, String villeArrivee,
			Transport transport, Double montantPrime) {
		super();
		this.statut = Statut.INITIALE;
		this.dateDebut = dateDebut;
		this.datefin = datefin;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.transport = transport;
		this.montantPrime = montantPrime;
	}

	public Mission(Statut statut, LocalDateTime dateDebut, LocalDateTime datefin, String villeDepart,
			String villeArrivee, Transport transport, Double montantPrime) {
		this(dateDebut, datefin, villeDepart, villeArrivee, transport, montantPrime);
		this.statut = statut;
	}

	public MissionVM toVM() {
		return new MissionVM(this);
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDatefin() {
		return datefin;
	}

	public void setDatefin(LocalDateTime datefin) {
		this.datefin = datefin;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Double getMontantPrime() {
		return montantPrime;
	}

	public void setMontantPrime(Double montantPrime) {
		this.montantPrime = montantPrime;
	}

}

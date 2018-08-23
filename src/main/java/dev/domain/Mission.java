package dev.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import dev.controller.vm.MissionVM;

@Entity
public class Mission extends BaseEntity {

	@Enumerated(EnumType.STRING)
	private Statut statut;

	private LocalDate dateDebut;

	private LocalDate dateFin;

	private String villeDepart;

	private String villeArrivee;

	@Enumerated(EnumType.STRING)
	private Transport transport;

	private Double montantPrime;

	public Mission() {
		super();
	}

	public Mission(LocalDate dateDebut, LocalDate dateFin, String villeDepart, String villeArrivee, Transport transport,
			Double montantPrime) {
		// super();
		this.statut = Statut.INITIALE;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.transport = transport;
		this.montantPrime = montantPrime;
	}

	public Mission(Statut statut, LocalDate dateDebut, LocalDate dateFin, String villeDepart, String villeArrivee,
			Transport transport, Double montantPrime) {
		this(dateDebut, dateFin, villeDepart, villeArrivee, transport, montantPrime);
		this.statut = statut;
	}

	public Mission(MissionVM missionVM) {
		this.id = missionVM.getId();
		this.statut = Statut.valueOf(missionVM.getStatut());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if (missionVM.getDateDebut().contains("/")) {
			this.dateDebut = LocalDate.parse(missionVM.getDateDebut(), formatter);
		} else {
			this.dateDebut = LocalDate.parse(missionVM.getDateDebut(), formatter2);
		}
		if (missionVM.getDateFin().contains("/")) {
			this.dateFin = LocalDate.parse(missionVM.getDateFin(), formatter);
		} else {
			this.dateFin = LocalDate.parse(missionVM.getDateFin(), formatter2);
		}
		this.villeDepart = missionVM.getVilleDepart();
		this.villeArrivee = missionVM.getVilleArrivee();
		this.transport = Transport.valueOf(missionVM.getTransport());
		this.montantPrime = missionVM.getMontantPrime();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{id: " + this.id + ", statut: " + this.statut.name() + ",\ndateDebut: " + this.dateDebut
				+ ", dateFin: " + this.dateFin + ",\nvilleDepart: " + this.villeDepart + ", villeArrivée: "
				+ this.villeArrivee + ",\nTransport: " + this.transport.getLibelle() + ", montantPrime: "
				+ this.montantPrime);
		return sb.toString();
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
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

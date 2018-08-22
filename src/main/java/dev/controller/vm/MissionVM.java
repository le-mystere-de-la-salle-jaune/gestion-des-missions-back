package dev.controller.vm;

import java.time.format.DateTimeFormatter;

import dev.domain.BaseEntity;
import dev.domain.Mission;

public class MissionVM extends BaseEntity {
	private String statut;
	private String dateDebut;
	private String datefin;
	private String villeDepart;
	private String villeArrivee;
	private String transport;
	private Double montantPrime;

	public MissionVM(Mission mission) {
		super();
		this.statut = mission.getStatut().toString();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dateDebut = mission.getDateDebut().format(formatter);
		this.datefin = mission.getDatefin().format(formatter);

		this.villeDepart = mission.getVilleDepart();
		this.villeArrivee = mission.getVilleArrivee();
		this.transport = mission.getTransport().getLibelle();
		this.montantPrime = mission.getMontantPrime();
	}

	@Override
	public BaseEntity toVM() {
		return this;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDatefin() {
		return datefin;
	}

	public void setDatefin(String datefin) {
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

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public Double getMontantPrime() {
		return montantPrime;
	}

	public void setMontantPrime(Double montantPrime) {
		this.montantPrime = montantPrime;
	}

}

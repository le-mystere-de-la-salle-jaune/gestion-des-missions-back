package dev.controller.vm;

import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.domain.Mission;

public class MissionVM extends BaseVM {
	private String statut;
	private String dateDebut;
	private String dateFin;
	private String villeDepart;
	private String villeArrivee;
	private String transport;
	private Double montantPrime;

	@JsonProperty("nature_mission_id")
	private Long natureMissionId;

	public MissionVM() {
	}

	public MissionVM(Mission mission) {
		super();
		this.setId(mission.getId());
		this.statut = mission.getStatut().name();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dateDebut = mission.getDateDebut().format(formatter);
		this.dateFin = mission.getDateFin().format(formatter);

		this.villeDepart = mission.getVilleDepart();
		this.villeArrivee = mission.getVilleArrivee();
		this.transport = mission.getTransport().name();
		this.montantPrime = mission.getMontantPrime();
		this.natureMissionId = mission.getNatureMission().getId();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{id: " + this.id + ", statut: " + this.statut + ",\ndateDebut: " + this.dateDebut + ", dateFin: "
				+ this.dateFin + ",\nvilleDepart: " + this.villeDepart + ", villeArrivée: " + this.villeArrivee
				+ ",\nTransport: " + this.transport + ", montantPrime: " + this.montantPrime + ",\nnature_mission: "
				+ this.natureMissionId);
		return sb.toString();
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

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
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

	public Long getNatureMissionId() {
		return this.natureMissionId;
	}

	public void setNatureMissionId(Long natureMissionId) {
		this.natureMissionId = natureMissionId;
	}

}

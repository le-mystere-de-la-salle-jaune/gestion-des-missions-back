package dev.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.controller.vm.MissionVM;
import dev.service.BaseService;

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

	@ManyToOne
	@JoinColumn(name = "natureMissionId")
	private NatureMission natureMission;

	public Mission() {
		super();
	}

	public Mission(LocalDate dateDebut, LocalDate dateFin, String villeDepart, String villeArrivee, Transport transport,
			Double montantPrime, NatureMission natureMission) {
		super();
		this.statut = Statut.INITIALE;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.transport = transport;
		this.montantPrime = montantPrime;
		this.natureMission = natureMission;
	}

	public Mission(Statut statut, LocalDate dateDebut, LocalDate dateFin, String villeDepart, String villeArrivee,
			Transport transport, Double montantPrime, NatureMission natureMission) {
		this(dateDebut, dateFin, villeDepart, villeArrivee, transport, montantPrime, natureMission);
		this.statut = statut;
	}

	public Mission(MissionVM missionVM, BaseService<NatureMission> service) {
		super();
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
		// System.out.println("\nId de missionVM: " + missionVM.getId());
		// System.out.println("\natureMissionService: " + natureMissionService);
		this.natureMission = service.findById(missionVM.getNatureMissionId());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{id: " + this.id + ", statut: " + this.statut.name() + ",\ndateDebut: " + this.dateDebut
				+ ", dateFin: " + this.dateFin + ",\nvilleDepart: " + this.villeDepart + ", villeArrivée: "
				+ this.villeArrivee + ",\nTransport: " + this.transport + ", montantPrime: " + this.montantPrime
				+ ", Nature de mission: " + this.natureMission.getLibelle());
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

	public NatureMission getNatureMission() {
		return natureMission;
	}

	public void setNatureMission(NatureMission natureMission) {
		this.natureMission = natureMission;
	}

}

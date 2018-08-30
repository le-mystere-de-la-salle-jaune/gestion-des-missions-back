package dev.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.controller.vm.LigneDeFraisVM;
import dev.service.BaseService;

@Entity
@Table(name = "ligne_de_frais")
public class LigneDeFrais extends BaseEntity {

	private LocalDate date;

	private String nature;

	private Double montant;

	@ManyToOne
	@JsonProperty("note_de_frais_id")
	@JoinColumn(name = "note_de_frais_id")
	private NoteDeFrais noteDeFrais;

	/**
	 * Constructeur
	 */
	public LigneDeFrais() {
		super();
	}

	public LigneDeFrais(LigneDeFraisVM vm, BaseService<NoteDeFrais> service) {
		super();
		this.date = vm.getDate();
		this.nature = vm.getNature();
		this.montant = vm.getMontant();
		this.noteDeFrais = service.findById(vm.getNoteDeFraisId());
	}

	/**
	 * Constructeur
	 * 
	 * @param date
	 * @param nature
	 * @param montant
	 * @param noteDeFrais
	 */
	public LigneDeFrais(LocalDate date, String nature, Double montant, NoteDeFrais noteDeFrais) {
		super();
		this.date = date;
		this.nature = nature;
		this.montant = montant;
		this.noteDeFrais = noteDeFrais;
	}

	/**
	 * Constructeur
	 * 
	 * @param date
	 * @param nature
	 * @param montant
	 */
	public LigneDeFrais(LocalDate date, String nature, Double montant) {
		super();
		this.date = date;
		this.nature = nature;
		this.montant = montant;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the nature
	 */
	public String getNature() {
		return nature;
	}

	/**
	 * @param nature
	 *            the nature to set
	 */
	public void setNature(String nature) {
		this.nature = nature;
	}

	/**
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * @return the noteDeFrais
	 */
	public NoteDeFrais getNoteDeFrais() {
		return noteDeFrais;
	}

	/**
	 * @param noteDeFrais
	 *            the noteDeFrais to set
	 */
	public void setNoteDeFrais(NoteDeFrais noteDeFrais) {
		this.noteDeFrais = noteDeFrais;
	}
}

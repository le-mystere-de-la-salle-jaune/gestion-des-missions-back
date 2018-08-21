package dev.controller.vm;

import java.time.LocalDate;

import dev.domain.LigneDeFrais;

public class LigneDeFraisVM extends BaseVM {

	private LocalDate date;

	private String nature;

	private Double montant;

	private Long noteDeFraisId;

	public LigneDeFraisVM(LigneDeFrais lf) {
		super(lf.getId());
		this.date = lf.getDate();
		this.nature = lf.getNature();
		this.montant = lf.getMontant();
		this.noteDeFraisId = lf.getNoteDeFrais().getId();
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
	 * @return the noteDeFraisId
	 */
	public Long getNoteDeFraisId() {
		return noteDeFraisId;
	}

	/**
	 * @param noteDeFraisId
	 *            the noteDeFraisId to set
	 */
	public void setNoteDeFraisId(Long noteDeFraisId) {
		this.noteDeFraisId = noteDeFraisId;
	}

}

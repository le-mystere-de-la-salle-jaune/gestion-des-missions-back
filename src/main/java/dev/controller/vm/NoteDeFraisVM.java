package dev.controller.vm;

import java.time.LocalDate;

import dev.domain.NoteDeFrais;

/**
 * Structure modélisant une note de frais servant à communiquer avec l'extérieur
 * (WEB API).
 */
public class NoteDeFraisVM extends BaseVM {

	private LocalDate dateCreation;

	private Double montantTotal;

	public NoteDeFraisVM() {

	}

	public NoteDeFraisVM(NoteDeFrais nf) {
		super(nf.getId());
		this.dateCreation = nf.getDateCreation();
		this.montantTotal = nf.getMontantTotal();
	}

	/**
	 * @return the dateCreation
	 */
	public LocalDate getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation
	 *            the dateCreation to set
	 */
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return the montantTotal
	 */
	public Double getMontantTotal() {
		return montantTotal;
	}

	/**
	 * @param montantTotal
	 *            the montantTotal to set
	 */
	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}

}

package dev.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dev.controller.vm.NoteDeFraisVM;

@Entity
@Table(name = "note_de_frais")
public class NoteDeFrais extends BaseEntity {

	private LocalDate dateCreation;

	private Double montantTotal;

	@OneToMany(mappedBy = "noteDeFrais", cascade = CascadeType.PERSIST)
	private List<LigneDeFrais> lignesDeFrais;

	/**
	 * Constructeur par défaut
	 */
	public NoteDeFrais() {
		super();
	}

	public NoteDeFrais(LocalDate dateCreation, Double montantTotal) {
		super();
		this.dateCreation = dateCreation;
		this.montantTotal = montantTotal;
		this.lignesDeFrais = new ArrayList<>();
	}

	/**
	 * Constructeur
	 * 
	 * @param dateCreation
	 * @param montantTotal
	 * @param lignesDeFrais
	 */
	public NoteDeFrais(LocalDate dateCreation, Double montantTotal, List<LigneDeFrais> lignesDeFrais) {
		this(dateCreation, montantTotal);
		this.lignesDeFrais = lignesDeFrais;
	}

	public NoteDeFrais(NoteDeFraisVM vm) {
		this(vm.getDateCreation(), vm.getMontantTotal());
		this.setId(vm.getId());
		this.lignesDeFrais = new ArrayList<>();
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

	/**
	 * @return the lignesDeFrais
	 */
	public List<LigneDeFrais> getLignesDeFrais() {
		return lignesDeFrais;
	}

	/**
	 * @param lignesDeFrais
	 *            the lignesDeFrais to set
	 */
	public void setLignesDeFrais(List<LigneDeFrais> lignesDeFrais) {
		this.lignesDeFrais = lignesDeFrais;
	}

}

package dev.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Collaborateur extends BaseEntity {

	private String nom;

	private String prenom;

	private String email;

	private String motDePasse;

	@OneToMany(mappedBy = "collaborateur", cascade = CascadeType.PERSIST)
	private List<RoleCollaborateur> roles;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<RoleCollaborateur> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleCollaborateur> roles) {
		this.roles = roles;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}

package dev.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RoleCollaborateur extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "collaborateur_id")
	private Collaborateur collaborateur;

	@Enumerated(EnumType.STRING)
	private Role role;

	public RoleCollaborateur() {
	}

	public RoleCollaborateur(Collaborateur collaborateur, Role role) {
		this.collaborateur = collaborateur;
		this.role = role;
	}

	// RoleCollaborateur n'a pas de VM, on renvoit donc directement l'entité
	@Override
	public RoleCollaborateur toVM() {
		return this;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Collaborateur getCollegue() {
		return collaborateur;
	}

	public void setCollegue(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

}

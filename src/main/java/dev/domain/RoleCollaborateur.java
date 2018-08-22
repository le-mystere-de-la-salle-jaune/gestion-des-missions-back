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

	@Override
	public BaseEntity toVM() {
		return this;
	}

	public RoleCollaborateur(Collaborateur collaborateur, Role role) {
		this.collaborateur = collaborateur;
		this.role = role;
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

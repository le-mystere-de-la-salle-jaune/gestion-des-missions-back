package dev.controller.vm;

import dev.domain.Collaborateur;
import dev.domain.Role;
import dev.domain.RoleCollaborateur;

public class RoleCollaborateurVM extends BaseVM {

	private Long collaborateur_id;

	private String role;

	public RoleCollaborateurVM() {
	}

	public RoleCollaborateurVM(Collaborateur collaborateur, Role role) {
		this.collaborateur_id = collaborateur.getId();
		this.role = role.name();
	}

	public RoleCollaborateurVM(RoleCollaborateur roleCollaborateur) {
		this.collaborateur_id = roleCollaborateur.getCollaborateur().getId();
		this.role = roleCollaborateur.getRole().name();
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getCollaborateurId() {
		return collaborateur_id;
	}

	public void setCollaborateurId(Long id) {
		this.collaborateur_id = id;
	}
}

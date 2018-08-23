package dev.controller.vm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.domain.Collaborateur;
import dev.domain.Role;

/**
<<<<<<< HEAD
 * Structure modèlisant un collègue servant à communiquer avec l'extérieur (WEB
 * API).
 */
public class CollaborateurVM extends BaseVM {
=======
 * Structure modélisant un collaborateur servant à communiquer avec l'extérieur
 * (WEB API).
 */
public class CollaborateurVM {
>>>>>>> merde

	private String email;
	private String nom;
	private String prenom;
	private List<Role> roles = new ArrayList<>();

	public CollaborateurVM(Collaborateur col) {
<<<<<<< HEAD
		super();
		this.setId(col.getId());
=======
>>>>>>> merde
		this.email = col.getEmail();
		this.nom = col.getNom();
		this.prenom = col.getPrenom();
		this.roles = col.getRoles().stream().map(roleCollegue -> roleCollegue.getRole()).collect(Collectors.toList());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
<<<<<<< HEAD

=======
>>>>>>> merde
}

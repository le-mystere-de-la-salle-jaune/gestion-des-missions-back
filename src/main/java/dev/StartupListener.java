package dev;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Collaborateur;
import dev.domain.NatureMission;
import dev.domain.Role;
import dev.domain.RoleCollaborateur;
import dev.domain.Version;
import dev.repository.CollaborateurRepo;
import dev.repository.NatureMissionRepo;
import dev.repository.VersionRepo;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
public class StartupListener {

	private String appVersion;
	private VersionRepo versionRepo;
	private PasswordEncoder passwordEncoder;
	private CollaborateurRepo collegueRepo;
	private NatureMissionRepo natureMissionrepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollaborateurRepo collegueRepo, NatureMissionRepo natureMissionrepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.natureMissionrepo = natureMissionrepo;

	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		this.versionRepo.save(new Version(appVersion));

		// Création de deux utilisateurs

		Collaborateur col1 = new Collaborateur();
		col1.setNom("Admin");
		col1.setPrenom("DEV");
		col1.setEmail("admin@dev.fr");
		col1.setMotDePasse(passwordEncoder.encode("superpass"));
		col1.setRoles(Arrays.asList(new RoleCollaborateur(col1, Role.ROLE_ADMINISTRATEUR),
				new RoleCollaborateur(col1, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col1);

		Collaborateur col2 = new Collaborateur();
		col2.setNom("User");
		col2.setPrenom("DEV");
		col2.setEmail("user@dev.fr");
		col2.setMotDePasse(passwordEncoder.encode("superpass"));
		col2.setRoles(Arrays.asList(new RoleCollaborateur(col2, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col2);

		NatureMission nat1 = new NatureMission();
		nat1.setFacturee(true);
		nat1.setLibelle("Nathan");
		nat1.setPourcentage(52);
		nat1.setTjm(5);
		nat1.setVersementPrime(true);
		this.natureMissionrepo.save(nat1);
	}

}

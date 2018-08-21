package dev;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Collaborateur;
import dev.domain.LigneDeFrais;
import dev.domain.NatureMission;
import dev.domain.NoteDeFrais;
import dev.domain.Role;
import dev.domain.RoleCollaborateur;
import dev.domain.Version;
import dev.repository.CollaborateurRepo;
import dev.repository.LigneDeFraisRepo;
import dev.repository.NatureMissionRepo;
import dev.repository.NoteDeFraisRepo;
import dev.repository.VersionRepo;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
public class StartupListener {

	private String appVersion;
	private VersionRepo versionRepo;
	private PasswordEncoder passwordEncoder;
	private CollaborateurRepo collaborateurRepo;
	private NatureMissionRepo natureMissionRepo;
	private LigneDeFraisRepo ligneDeFraisRepo;
	private NoteDeFraisRepo noteDeFraisRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollaborateurRepo collaborateurRepo, NatureMissionRepo natureMissionRepo,
			LigneDeFraisRepo ligneDeFraisRepo, NoteDeFraisRepo noteDeFraisRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collaborateurRepo = collaborateurRepo;
		this.natureMissionRepo = natureMissionRepo;
		this.ligneDeFraisRepo = ligneDeFraisRepo;
		this.noteDeFraisRepo = noteDeFraisRepo;
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
		this.collaborateurRepo.save(col1);

		Collaborateur col2 = new Collaborateur();
		col2.setNom("User");
		col2.setPrenom("DEV");
		col2.setEmail("user@dev.fr");
		col2.setMotDePasse(passwordEncoder.encode("superpass"));
		col2.setRoles(Arrays.asList(new RoleCollaborateur(col2, Role.ROLE_UTILISATEUR)));
		this.collaborateurRepo.save(col2);

		// Création d'une nature de mission

		NatureMission nat1 = new NatureMission();
		nat1.setFacturee(true);
		nat1.setLibelle("Nathan");
		nat1.setPourcentage(52);
		nat1.setTjm(5);
		nat1.setVersementPrime(true);
		this.natureMissionRepo.save(nat1);

		// Création d'une note de frais comportant deux lignes de frais

		LigneDeFrais lf1 = new LigneDeFrais();
		lf1.setDate(LocalDate.of(2018, 8, 21));
		lf1.setMontant(320d);
		lf1.setNature("Hôtel Machin");

		LigneDeFrais lf2 = new LigneDeFrais();
		lf2.setDate(LocalDate.of(2018, 8, 20));
		lf2.setMontant(105.80d);
		lf2.setNature("Location véhicule");

		NoteDeFrais nf1 = new NoteDeFrais();
		nf1.setDateCreation(LocalDate.of(2018, 8, 21));
		nf1.setMontantTotal(325.80d);

		this.noteDeFraisRepo.save(nf1);

		lf1.setNoteDeFrais(nf1);
		lf2.setNoteDeFrais(nf1);

		this.ligneDeFraisRepo.save(lf1);
		this.ligneDeFraisRepo.save(lf2);

	}

}

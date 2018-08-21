package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.NoteDeFraisVM;
import dev.domain.NoteDeFrais;
import dev.service.NoteDeFraisService;
import dev.service.vm.NoteDeFraisServiceVM;

@RestController
@RequestMapping("/api/noteDeFrais")
public class NoteDeFraisApiController {

	private NoteDeFraisService noteDeFraisService;
	private NoteDeFraisServiceVM noteDeFraisServiceVM;

	public NoteDeFraisApiController(NoteDeFraisService noteDeFraisService, NoteDeFraisServiceVM noteDeFraisServiceVM) {
		super();
		this.noteDeFraisService = noteDeFraisService;
		this.noteDeFraisServiceVM = noteDeFraisServiceVM;
	}

	/**
	 * Liste toutes les NoteDeFrais
	 * 
	 * @return ResponseEntity dont le corps est constitué de la liste de toutes
	 *         les NoteDeFrais
	 */
	@GetMapping
	public ResponseEntity<List<NoteDeFraisVM>> findAll() {
		// HttpStatus est une énumération regroupant les codes HTTP usuels
		return ResponseEntity.ok(noteDeFraisServiceVM.findAll());
	}

	/**
	 * Trouve une NoteDeFrais à partir de son id
	 *
	 * @return ResponseEntity dont le corps est la NoteDeFrais recherchée
	 */
	@GetMapping("/{id}")
	public ResponseEntity<NoteDeFraisVM> findById(@PathVariable Long id) {
		// HttpStatus est une énumération regroupant les codes HTTP usuels
		return ResponseEntity.ok(noteDeFraisServiceVM.findById(id));
	}

	/**
	 * Permet de créer une NoteDeFrais dont l'ID est spécifié dans l'URL
	 * 
	 * @param noteDeFrais:
	 *            NoteDeFrais à créer
	 * @return ResponseEntity dont le corps est l'id de la NoteDeFrais créée
	 */
	@PostMapping
	public ResponseEntity<Long> creer(@RequestBody NoteDeFrais noteDeFrais) {
		this.noteDeFraisService.save(noteDeFrais);
		return ResponseEntity.status(HttpStatus.OK).body(noteDeFrais.getId());
	}

	/**
	 * Permet de supprimer une NoteDeFrais à partir de son ID
	 * 
	 * @param id
	 *            l'id de la NoteDeFrais à supprimer
	 * @return ResponseEntity dont le corps est un message de succès/d'erreur
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> supprimer(@PathVariable Long id) {
		if (noteDeFraisService.exist(id)) {
			noteDeFraisService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body("La note de frais dont l'id est " + id + " a été supprimée");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cette note de frais n'existe pas");
		}
	}

}

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

import dev.controller.vm.LigneDeFraisVM;
import dev.domain.LigneDeFrais;
import dev.service.LigneDeFraisService;
import dev.service.NoteDeFraisService;
import dev.service.vm.LigneDeFraisServiceVM;

@RestController
@RequestMapping("/api/ligneDeFrais")
public class LigneDeFraisApiController {

	private LigneDeFraisService ligneDeFraisService;
	private LigneDeFraisServiceVM ligneDeFraisServiceVM;

	private NoteDeFraisService noteDeFraisService;

	public LigneDeFraisApiController(LigneDeFraisService ligneDeFraisService, NoteDeFraisService noteDeFraisService,
			LigneDeFraisServiceVM ligneDeFraisServiceVM) {
		super();
		this.ligneDeFraisService = ligneDeFraisService;
		this.noteDeFraisService = noteDeFraisService;
		this.ligneDeFraisServiceVM = ligneDeFraisServiceVM;
	}

	/**
	 * Liste toutes les LigneDeFrais
	 * 
	 * @return ResponseEntity dont le corps est constitué de la liste de toutes
	 *         les LigneDeFrais
	 */
	@GetMapping
	public ResponseEntity<List<LigneDeFraisVM>> findAll() {
		// HttpStatus est une énumération regroupant les codes HTTP usuels
		return ResponseEntity.ok(ligneDeFraisServiceVM.findAll());
	}

	/**
	 * Trouve une LigneDeFrais à partir de son id
	 *
	 * @return ResponseEntity dont le corps est la LigneDeFrais recherchée
	 */
	@GetMapping("/{id}")
	public ResponseEntity<LigneDeFraisVM> findById(@PathVariable Long id) {
		// HttpStatus est une énumération regroupant les codes HTTP usuels
		return ResponseEntity.ok(ligneDeFraisServiceVM.findById(id));
	}

	/**
	 * Permet de créer une LigneDeFrais dont l'ID est spécifié dans l'URL
	 * 
	 * @param ligneDeFrais:
	 *            LigneDeFrais à créer
	 * @return ResponseEntity dont le corps est l'id de la LigneDeFrais créée
	 */
	@PostMapping
	public ResponseEntity<Long> creer(@RequestBody LigneDeFrais ligneDeFrais) {
		this.ligneDeFraisService.save(ligneDeFrais);
		return ResponseEntity.status(HttpStatus.OK).body(ligneDeFrais.getId());
	}

	/**
	 * Permet de supprimer une LigneDeFrais à partir de son ID.
	 * 
	 * @param id
	 *            l'id de la LigneDeFrais à supprimer
	 * @return ResponseEntity dont le corps est un message de succès/d'erreur
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> supprimer(@PathVariable Long id) {
		if (ligneDeFraisService.exist(id)) {
			ligneDeFraisService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body("La ligne de frais dont l'id est " + id + " a été supprimée");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cette ligne de frais n'existe pas");
		}
	}

	/**
	 * Permet de modifier une ligne de frais existante
	 *
	 * @param ligneDeFraisVM:
	 *            view model de ligne de frais dont les attributs vont être
	 *            utilisés pout modifier ceux de la ligne de frais à modifier
	 * @param id:
	 *            ID de la ligne de frais à modifier
	 * @return ResponseEntity dont le corps est un message informant réussite ou
	 *         non de la modification
	 */
	@PostMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody LigneDeFraisVM ligneDeFraisVM, @PathVariable Long id) {
		if (this.ligneDeFraisService.exist(id)) {
			LigneDeFrais ligneDeFrais = ligneDeFraisService.findById(ligneDeFraisVM.getId());
			ligneDeFrais.setDate(ligneDeFraisVM.getDate());
			ligneDeFrais.setMontant(ligneDeFraisVM.getMontant());
			ligneDeFrais.setNature(ligneDeFraisVM.getNature());
			ligneDeFrais.setNoteDeFrais(noteDeFraisService.findById(ligneDeFraisVM.getNoteDeFraisId()));

			ligneDeFraisService.update(ligneDeFrais);

			return ResponseEntity.status(HttpStatus.OK)
					.body("La ligne de frais dont l'id est " + ligneDeFraisVM.getId() + " a été modifiée.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune ligne de frais trouvée avec l'id "
					+ ligneDeFraisVM.getId() + ". Aucune modification n'a été effectuée.");
		}
	}

}

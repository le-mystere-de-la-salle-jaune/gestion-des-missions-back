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

import dev.domain.NatureMission;
import dev.service.NatureMissionService;

@RestController
@RequestMapping("/api/natureMission")
public class NatureMissionApiController {

	private NatureMissionService natureMissionService;

	public NatureMissionApiController(NatureMissionService natureMissionService) {
		super();
		this.natureMissionService = natureMissionService;
	}

	/**
	 * Liste toutes les NatureMission
	 * 
	 * @return ResponseEntity dont le corps est constitué de la liste de toutes
	 *         les NatureMission
	 */
	@GetMapping
	public ResponseEntity<List<NatureMission>> findAll() {
		List<NatureMission> listeNatureMission = this.natureMissionService.list();

		// HttpStatus est une énumération regroupant les codes HTTP usuels
		return ResponseEntity.status(HttpStatus.OK).body(listeNatureMission);
	}

	/**
	 * Liste la nature de mission dont l'ID est spécifiée dans l'URL
	 * 
	 * @return ResponseEntity dont le corps est la NatureMission recherchée
	 */
	@GetMapping("/{id}")
	public ResponseEntity<NatureMission> findById(@PathVariable Long id) {
		// HttpStatus est une énumération regroupant les codes HTTP usuels
		return ResponseEntity.status(HttpStatus.OK).body(this.natureMissionService.findById(id));
	}

	/**
	 * Permet de créer une NatureMission dont l'ID est spécifié dans l'URL
	 * 
	 * @param natureMission:
	 *            NatureMission à créer
	 * @return ResponseEntity dont le corps est l'id de la NatureMission créée
	 */
	@PostMapping
	public ResponseEntity<Long> creer(@RequestBody NatureMission natureMission) {
		this.natureMissionService.save(natureMission);
		return ResponseEntity.status(HttpStatus.OK).body(natureMission.getId());
	}

	/**
	 * Permet de supprimer une nature de mission
	 * 
	 * @param id:
	 *            ID de la nature de mission à supprimer
	 * @return ResponseEntity dont le corps est un message informant réussite ou
	 *         non de la suppression
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> supprimer(@PathVariable Long id) {
		if (natureMissionService.exist(id)) {
			natureMissionService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body("La nature de mission dont l'id est " + id + " a été supprimée");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cette nature de mission n'existe pas");
		}
	}

	/**
	 * Permet de modifier une nature de mission existante
	 * 
	 * @param newNatureMission:
	 *            nouvelle nature de mission dont les attributs vont être
	 *            utilisés pout modifier ceux la nature de mission à modifier
	 * @param id:
	 *            ID de la nature de mission à modifier
	 * @return ResponseEntity dont le corps est un message informant réussite ou
	 *         non de la modification
	 */
	@PostMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody NatureMission newNatureMission, @PathVariable Long id) {
		if (this.natureMissionService.exist(id)) {
			newNatureMission.setId(id);
			this.natureMissionService.save(newNatureMission);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Nature de mission dont l'id est " + newNatureMission.getId() + " a été modifiée.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune nature de mission est en base avec l'id "
					+ newNatureMission.getId() + ". Aucune modification n'a été effectuée.");
		}
	}
}

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
	 * 
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

	@DeleteMapping("/{id}")
	public ResponseEntity<?> supprimer(@PathVariable Long id) {
		if (natureMissionService.exist(id)) {
			natureMissionService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Nature de mission correctement supprimée");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cette nature de mission n'existe pas");
		}
	}
}

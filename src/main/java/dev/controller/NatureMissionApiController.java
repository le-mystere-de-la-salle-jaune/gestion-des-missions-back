package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * @return ResponseEntity dont le coprs est constitué de la liste de toutes
	 *         les NatureMission
	 */
	@GetMapping
	public ResponseEntity<List<NatureMission>> findAll() {
		List<NatureMission> listeNatureMission = this.natureMissionService.list();

		// HttpStatus est une énumération regroupant les codes HTTP usuels
		return ResponseEntity.status(HttpStatus.OK).body(listeNatureMission);
	}

	/**
	 * Permet de lister la NatureMission dont l'ID est spécifié dans l'URL
	 * 
	 * @param id:
	 *            ID de la NatureMission recherchée
	 * @return ResponseEntity dont le corps est la NatureMission recherchée
	 */
	@GetMapping("/{id}")
	public ResponseEntity<NatureMission> getNatureMissionById(@PathVariable Long id) {
		return ResponseEntity.ok(this.natureMissionService.findById(id));
	}

}

package dev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.service.NatureMissionService;

@RestController
@RequestMapping("/api/natureMission")
public class NatureMissionApiController {

	private NatureMissionService natureMissionService;

	public NatureMissionApiController(NatureMissionService natureMissionService) {
		super();
		this.natureMissionService = natureMissionService;
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

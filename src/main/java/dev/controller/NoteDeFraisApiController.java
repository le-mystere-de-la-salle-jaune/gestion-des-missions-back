package dev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.NoteDeFraisVM;
import dev.domain.NoteDeFrais;
import dev.service.NoteDeFraisService;

@RestController
@RequestMapping("/api/noteDeFrais")
public class NoteDeFraisApiController extends BaseApiController<NoteDeFrais, NoteDeFraisVM> {
	public NoteDeFraisApiController(NoteDeFraisService noteDeFraisService) {
		super(noteDeFraisService, NoteDeFrais.class, NoteDeFraisVM.class);
	}

	// private NoteDeFraisService noteDeFraisService;
	// private NoteDeFraisServiceVM noteDeFraisServiceVM;
	//
	// public NoteDeFraisApiController(NoteDeFraisService noteDeFraisService,
	// NoteDeFraisServiceVM noteDeFraisServiceVM) {
	// super();
	// this.noteDeFraisService = noteDeFraisService;
	// this.noteDeFraisServiceVM = noteDeFraisServiceVM;
	// }
	//
	// /**
	// * Liste toutes les NoteDeFrais
	// *
	// * @return ResponseEntity dont le corps est constitué de la liste de
	// toutes
	// * les NoteDeFrais
	// */
	// @GetMapping
	// public ResponseEntity<List<NoteDeFraisVM>> findAll() {
	// // HttpStatus est une énumération regroupant les codes HTTP usuels
	// return ResponseEntity.ok(noteDeFraisServiceVM.findAll());
	// }
	//
	// /**
	// * Trouve une NoteDeFrais à partir de son id
	// *
	// * @return ResponseEntity dont le corps est la NoteDeFrais recherchée
	// */
	// @GetMapping("/{id}")
	// public ResponseEntity<NoteDeFraisVM> findById(@PathVariable Long id) {
	// // HttpStatus est une énumération regroupant les codes HTTP usuels
	// return ResponseEntity.ok(noteDeFraisServiceVM.findById(id));
	// }
	//
	// /**
	// * Permet de créer une NoteDeFrais dont l'ID est spécifié dans l'URL
	// *
	// * @param noteDeFrais:
	// * NoteDeFrais à créer
	// * @return ResponseEntity dont le corps est l'id de la NoteDeFrais créée
	// */
	// @PostMapping
	// public ResponseEntity<Long> creer(@RequestBody NoteDeFrais noteDeFrais) {
	// this.noteDeFraisService.save(noteDeFrais);
	// return ResponseEntity.status(HttpStatus.OK).body(noteDeFrais.getId());
	// }
	//
	// /**
	// * Permet de supprimer une NoteDeFrais à partir de son ID
	// *
	// * @param id
	// * l'id de la NoteDeFrais à supprimer
	// * @return ResponseEntity dont le corps est un message de succès/d'erreur
	// */
	// @DeleteMapping("/{id}")
	// public ResponseEntity<?> supprimer(@PathVariable Long id) {
	// if (noteDeFraisService.exist(id)) {
	// noteDeFraisService.deleteById(id);
	// return ResponseEntity.status(HttpStatus.OK)
	// .body("La note de frais dont l'id est " + id + " a été supprimée");
	// } else {
	// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cette note de
	// frais n'existe pas");
	// }
	// }
	//
	// /**
	// * Permet de modifier une note de frais existante
	// *
	// * @param noteDeFraisVM:
	// * view model de note de frais dont les attributs vont être
	// * utilisés pout modifier ceux de la note de frais à modifier
	// * @param id:
	// * ID de la note de frais à modifier
	// * @return ResponseEntity dont le corps est un message informant réussite
	// ou
	// * non de la modification
	// */
	// @PostMapping("/{id}")
	// public ResponseEntity<String> update(@RequestBody NoteDeFraisVM
	// noteDeFraisVM, @PathVariable Long id) {
	// if (this.noteDeFraisService.exist(id)) {
	// NoteDeFrais noteDeFrais =
	// noteDeFraisService.findById(noteDeFraisVM.getId());
	// noteDeFrais.setDateCreation(noteDeFraisVM.getDateCreation());
	// noteDeFrais.setMontantTotal(noteDeFraisVM.getMontantTotal());
	//
	// noteDeFraisService.update(noteDeFrais);
	//
	// return ResponseEntity.status(HttpStatus.OK)
	// .body("La note de frais dont l'id est " + noteDeFraisVM.getId() + " a été
	// modifiée.");
	// } else {
	// return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune note de
	// frais trouvée avec l'id "
	// + noteDeFraisVM.getId() + ". Aucune modification n'a été effectuée.");
	// }
	// }

}

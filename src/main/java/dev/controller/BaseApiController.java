package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.domain.BaseEntity;
import dev.service.BaseService;

public class BaseApiController<T extends BaseEntity> {

	private BaseService<T> service;

	private final Class<T> typeClass;

	public BaseApiController(BaseService<T> service, Class<T> typeClass) {
		this.service = service;
		this.typeClass = typeClass;
	}

	@GetMapping
	public ResponseEntity<List<T>> findAll() {
		List<T> listeEntity = this.service.list();
		return ResponseEntity.status(HttpStatus.OK).body(listeEntity);
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.findById(id));
	}

	@PostMapping
	public ResponseEntity<Long> create(@RequestBody T t) {
		this.service.save(t);
		return ResponseEntity.status(HttpStatus.OK).body(t.getId());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		if (this.service.exist(id)) {
			this.service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(
					"L'objet de type " + this.typeClass.getSimpleName() + " dont l'id est " + id + " a été supprimée");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aucun objet de type "
					+ this.typeClass.getSimpleName() + " n'a été trouvé en base. Rien n'a été supprimé");
		}
	}

	@PostMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody T t, @PathVariable Long id) {
		if (this.service.exist(id)) {
			t.setId(id);
			this.service.update(t);
			return ResponseEntity.status(HttpStatus.OK).body(
					"L'objet de type " + this.typeClass.getSimpleName() + "dont l'id est " + id + " a été modifiée.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Aucun Objet de type " + this.typeClass.getSimpleName() + "est en base avec l'id " + id
							+ ". Aucune modification n'a été effectuée.");
		}
	}
}

package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.controller.vm.BaseVM;
import dev.controller.vm.VMUtils;
import dev.domain.BaseEntity;
import dev.service.BaseService;

public class BaseApiController<T extends BaseEntity, S extends BaseVM> {

	private BaseService<T> service;

	private final Class<T> entityClass;

	private final VMUtils<T, S> vmUtils;

	public BaseApiController(BaseService<T> service, Class<T> entityClass, Class<S> VMClass) {
		this.service = service;
		this.entityClass = entityClass;
		this.vmUtils = new VMUtils<>(entityClass, VMClass);
	}

	@GetMapping
	public ResponseEntity<List<BaseVM>> findAll() {
		List<BaseVM> listeEntity = this.service.list().stream().map(t -> this.vmUtils.transformIntoVM(t))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(listeEntity);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BaseVM> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.vmUtils.transformIntoVM(this.service.findById(id)));
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody S s) {
		T entity = (T) this.vmUtils.transformIntoEntity(s);
		this.service.save(entity);
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.entityClass.getSimpleName() + " créé avec l'id " + entity.getId());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		if (this.service.exist(id)) {
			this.service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(
					"L'objet de type " + this.entityClass.getSimpleName() + " dont l'id est " + id + " a été supprimé");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aucun objet de type "
					+ this.entityClass.getSimpleName() + " n'a été trouvé en base. Rien n'a été supprimé.");
		}
	}

	@PostMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody S s, @PathVariable Long id) {
		if (this.service.exist(id)) {
			s.setId(id);
			this.service.update((T) this.vmUtils.transformIntoEntity(s));
			return ResponseEntity.status(HttpStatus.OK).body(
					"L'objet de type " + this.entityClass.getSimpleName() + "dont l'id est " + id + " a été modifié.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Aucun Objet de type " + this.entityClass.getSimpleName() + "trouvé avec l'id " + id
							+ ". Aucune modification n'a été effectuée.");
		}
	}

	protected BaseService<T> getService() {
		return this.service;
	}

}

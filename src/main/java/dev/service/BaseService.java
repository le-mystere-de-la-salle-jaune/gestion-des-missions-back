package dev.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dev.domain.BaseEntity;
import dev.repository.BaseRepository;

@Transactional(readOnly=true)
public abstract class BaseService<T extends BaseEntity> {

	protected BaseRepository<T> repository;

	public BaseService(BaseRepository<T> repository) {
		this.repository = repository;
	}

	@Transactional
	public List<T> list() {
		return (List<T>) this.repository.findAll();
	}

	@Transactional
	public T findById(Long id) {
		return this.repository.findById(id).orElse(null);
	}

	@Transactional(readOnly=false)
	public void save(T t) {
		this.repository.save(t);
	}

	@Transactional(readOnly=false)
	public void update(T t) {
		if (this.exist(t.getId())) {
			repository.save(t);
		} else {
			System.out.println("L'entité à modifier n'existe pas");
		}
	}

	@Transactional(readOnly=false)
	public void delete(T t) {
		this.repository.delete(t);
	}

	@Transactional(readOnly=false)
	public void delete(Long id) {
		this.repository.delete(this.findById(id));
	}

	@Transactional
	public boolean exist(BaseEntity entity) {
		return this.repository.findById(entity.getId()).isPresent();
	}

	@Transactional
	public boolean exist(Long id) {
		return this.repository.findById(id).isPresent();
	}
}
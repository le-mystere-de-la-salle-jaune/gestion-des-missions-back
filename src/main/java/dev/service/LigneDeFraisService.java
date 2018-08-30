package dev.service;

import org.springframework.stereotype.Service;

import dev.domain.LigneDeFrais;
import dev.repository.LigneDeFraisRepo;

@Service
public class LigneDeFraisService extends BaseService<LigneDeFrais> {

	public LigneDeFraisService(LigneDeFraisRepo ligneDeFraisRepo) {
		super(ligneDeFraisRepo);
	}
	// private LigneDeFraisRepo ligneDeFraisRepo;
	//
	// public LigneDeFraisService(LigneDeFraisRepo ligneDeFraisRepo) {
	// super();
	// this.ligneDeFraisRepo = ligneDeFraisRepo;
	// }
	//
	// @Transactional
	// public List<LigneDeFrais> list() {
	// return (List<LigneDeFrais>) ligneDeFraisRepo.findAll();
	// }
	//
	// @Transactional
	// public void save(LigneDeFrais ligneDeFraisToAdd) {
	// ligneDeFraisRepo.save(ligneDeFraisToAdd);
	// }
	//
	// @Transactional
	// public LigneDeFrais findById(Long id) {
	// return ligneDeFraisRepo.findById(id).orElse(null);
	// }
	//
	// @Transactional
	// public void update(LigneDeFrais updatedLigneDeFrais) {
	// if (this.exist(updatedLigneDeFrais.getId())) {
	// ligneDeFraisRepo.save(updatedLigneDeFrais);
	// } else {
	// System.out.println("L'entité à modifier n'existe pas");
	// }
	// }
	//
	// @Transactional
	// public void delete(LigneDeFrais ligneDeFraisToRemove) {
	// ligneDeFraisRepo.delete(ligneDeFraisToRemove);
	// }
	//
	// @Transactional
	// public void deleteById(Long id) {
	// ligneDeFraisRepo.delete(this.findById(id));
	// }
	//
	// @Transactional
	// public boolean exist(Long ligneDeFraisId) {
	// return ligneDeFraisRepo.findById(ligneDeFraisId).isPresent();
	// }
}

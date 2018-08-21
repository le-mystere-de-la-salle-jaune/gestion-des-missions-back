package dev.service;

import org.springframework.stereotype.Service;

import dev.domain.NatureMission;
import dev.repository.NatureMissionRepo;

@Service
public class NatureMissionService extends BaseService<NatureMission> {

	public NatureMissionService(NatureMissionRepo natureMissionRepo) {
		super(natureMissionRepo);
	}

	// @Override
	// public List<NatureMission> list() {
	// return (List<NatureMission>) natureMissionRepo.findAll();
	// }
	//
	// @Override
	// public void save(NatureMission natureMissionToAdd) {
	// natureMissionRepo.save(natureMissionToAdd);
	// }
	//
	// @Override
	// public NatureMission findById(Long id) {
	// return natureMissionRepo.findById(id).orElse(null);
	// }
	//
	// @Override
	// public void update(NatureMission updatedNatureMission) {
	// if (this.exist(updatedNatureMission.getId())) {
	// natureMissionRepo.save(updatedNatureMission);
	// } else {
	// System.out.println("L'entité à modifier n'existe pas");
	// }
	// }
	//
	// @Override
	// public void delete(NatureMission natureMissionToRemove) {
	// natureMissionRepo.delete(natureMissionToRemove);
	// }
	//
	// @Override
	// public void delete(Long id) {
	// natureMissionRepo.delete(this.findById(id));
	// }
	//
	// @Override
	// public boolean exist(Long natureMissionId) {
	// return natureMissionRepo.findById(natureMissionId).isPresent();
	// }
	//
	// @Override
	// public boolean exist(NatureMission natureMission) {
	// return natureMissionRepo.findById(natureMission.getId()).isPresent();
	// }

}

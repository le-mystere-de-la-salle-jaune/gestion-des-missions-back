package dev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.domain.NatureMission;
import dev.repository.NatureMissionRepo;

@Service
public class NatureMissionService {

	private NatureMissionRepo natureMissionRepo;

	public NatureMissionService(NatureMissionRepo natureMissionRepo) {
		super();
		this.natureMissionRepo = natureMissionRepo;
	}

	public List<NatureMission> list() {
		return (List<NatureMission>) natureMissionRepo.findAll();
	}

	public void add(NatureMission natureMissionToAdd) {
		natureMissionRepo.save(natureMissionToAdd);
	}

	public NatureMission getById(Long id) {
		return natureMissionRepo.findById(id).orElse(null);
	}

	public void update(NatureMission updatedNatureMission) {
		if (this.exist(updatedNatureMission.getId())) {
			natureMissionRepo.save(updatedNatureMission);
		} else {
			System.out.println("L'entité à modifier n'existe pas");
		}
	}

	public void delete(NatureMission natureMissionToRemove) {
		natureMissionRepo.delete(natureMissionToRemove);
	}

	public boolean exist(Long examenId) {
		return natureMissionRepo.findById(examenId).isPresent();
	}

	public void deleteById(Long id) {
		natureMissionRepo.delete(getById(id));
	}

}

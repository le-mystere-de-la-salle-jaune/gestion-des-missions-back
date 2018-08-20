package dev.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dev.domain.NatureMission;
import dev.repository.NatureMissionRepo;

public class NatureMissionService {

	private NatureMissionRepo natureMissionRepo;

	public NatureMissionService(NatureMissionRepo natureMissionRepo) {
		super();
		this.natureMissionRepo = natureMissionRepo;
	}

	@Transactional
	public List<NatureMission> list() {
		return (List<NatureMission>) natureMissionRepo.findAll();
	}

	@Transactional
	public void save(NatureMission natureMissionToAdd) {
		natureMissionRepo.save(natureMissionToAdd);
	}

	@Transactional
	public NatureMission findById(Long id) {
		return natureMissionRepo.findById(id).orElse(null);
	}

	@Transactional
	public void update(NatureMission updatedNatureMission) {
		if (this.exist(updatedNatureMission.getId())) {
			natureMissionRepo.save(updatedNatureMission);
		} else {
			System.out.println("L'entité à modifier n'existe pas");
		}
	}

	@Transactional
	public void delete(NatureMission natureMissionToRemove) {
		natureMissionRepo.delete(natureMissionToRemove);
	}

	@Transactional
	public boolean exist(Long natureMissionId) {
		return natureMissionRepo.findById(natureMissionId).isPresent();
	}

}

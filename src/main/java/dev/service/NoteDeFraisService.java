package dev.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.domain.NoteDeFrais;
import dev.repository.NoteDeFraisRepo;

@Service
public class NoteDeFraisService {
	private NoteDeFraisRepo noteDeFraisRepo;

	public NoteDeFraisService(NoteDeFraisRepo noteDeFraisRepo) {
		super();
		this.noteDeFraisRepo = noteDeFraisRepo;
	}

	@Transactional
	public List<NoteDeFrais> list() {
		return (List<NoteDeFrais>) noteDeFraisRepo.findAll();
	}

	@Transactional
	public void save(NoteDeFrais noteDeFraisToAdd) {
		noteDeFraisRepo.save(noteDeFraisToAdd);
	}

	@Transactional
	public NoteDeFrais findById(Long id) {
		return noteDeFraisRepo.findById(id).orElse(null);
	}

	@Transactional
	public void update(NoteDeFrais updatedNoteDeFrais) {
		if (this.exist(updatedNoteDeFrais.getId())) {
			noteDeFraisRepo.save(updatedNoteDeFrais);
		} else {
			System.out.println("L'entité à modifier n'existe pas");
		}
	}

	@Transactional
	public void delete(NoteDeFrais noteDeFraisToRemove) {
		noteDeFraisRepo.delete(noteDeFraisToRemove);
	}

	@Transactional
	public void deleteById(Long id) {
		noteDeFraisRepo.delete(this.findById(id));
	}

	@Transactional
	public boolean exist(Long noteDeFraisId) {
		return noteDeFraisRepo.findById(noteDeFraisId).isPresent();
	}
}

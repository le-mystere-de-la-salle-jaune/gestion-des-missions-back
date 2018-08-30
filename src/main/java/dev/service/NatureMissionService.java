package dev.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.domain.NatureMission;
import dev.repository.NatureMissionRepo;

@Service
public class NatureMissionService
		extends BaseService<NatureMission/* , NatureMissionVM */> {

	public NatureMissionService(NatureMissionRepo natureMissionRepo) {
		super(natureMissionRepo);
	}
	
	@Override
	@Transactional
	public void delete(NatureMission t) {
		t.setDateFinValidite(LocalDate.now());
		this.update(t);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		NatureMission t = this.findById(id);
		t.setDateFinValidite(LocalDate.now());
		this.update(t);
	}
	
}

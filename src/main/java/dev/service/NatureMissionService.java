package dev.service;

import org.springframework.stereotype.Service;

import dev.domain.NatureMission;
import dev.repository.NatureMissionRepo;

@Service
public class NatureMissionService
		extends BaseService<NatureMission/* , NatureMissionVM */> {

	public NatureMissionService(NatureMissionRepo natureMissionRepo) {
		super(natureMissionRepo);
	}
}

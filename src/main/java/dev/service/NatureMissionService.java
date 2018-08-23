package dev.service;

import org.springframework.stereotype.Service;

import dev.domain.NatureMission;
import dev.repository.NatureMissionRepo;

@Service
public class NatureMissionService extends BaseService<NatureMission> {

	public NatureMissionService(NatureMissionRepo natureMissionRepo) {
		super(natureMissionRepo);
	}
}

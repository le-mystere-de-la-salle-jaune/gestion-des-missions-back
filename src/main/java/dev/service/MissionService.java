package dev.service;

import org.springframework.stereotype.Service;

import dev.domain.Mission;
import dev.repository.MissionRepo;

@Service
public class MissionService extends BaseService<Mission/* , MissionVM */> {

	public MissionService(MissionRepo missionRepo) {
		super(missionRepo);
	}
}

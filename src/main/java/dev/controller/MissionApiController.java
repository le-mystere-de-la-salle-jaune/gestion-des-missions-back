package dev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.MissionVM;
import dev.domain.Mission;
import dev.domain.NatureMission;
import dev.service.MissionService;
import dev.service.NatureMissionService;

@RestController
@RequestMapping("/api/missions")
public class MissionApiController extends BaseApiController<Mission, NatureMission, MissionVM> {

	public MissionApiController(MissionService missionService, NatureMissionService natureMissionService) {
		super(missionService, Mission.class, MissionVM.class, natureMissionService);
	}
}

package dev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.MissionVM;
import dev.domain.Mission;
import dev.service.MissionService;

@RestController
@RequestMapping("/api/missions")
public class MissionApiController extends BaseApiController<Mission, MissionVM> {

	public MissionApiController(MissionService missionService) {
		super(missionService, Mission.class, MissionVM.class);
	}
}

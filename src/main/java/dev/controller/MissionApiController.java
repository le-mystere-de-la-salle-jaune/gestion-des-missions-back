package dev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Mission;
import dev.service.MissionService;

@RestController
@RequestMapping("/api/missions")
public class MissionApiController extends BaseApiController<Mission> {

	public MissionApiController(MissionService missionService) {
		super(missionService, Mission.class);
	}
}

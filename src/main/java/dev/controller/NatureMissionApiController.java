package dev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.NatureMission;
import dev.service.NatureMissionService;

@RestController
@RequestMapping("/api/natureMission")
public class NatureMissionApiController extends BaseApiController<NatureMission> {

	public NatureMissionApiController(NatureMissionService natureMissionService) {
		super(natureMissionService, NatureMission.class);
	}

}

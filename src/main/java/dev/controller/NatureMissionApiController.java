package dev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.service.NatureMissionService;

@RestController
@RequestMapping("/api/natureMission")
public class NatureMissionApiController {

	private NatureMissionService natureMissionService;

	public NatureMissionApiController(NatureMissionService natureMissionService) {
		super();
		this.natureMissionService = natureMissionService;
	}

}

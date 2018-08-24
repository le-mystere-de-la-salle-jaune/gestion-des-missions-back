package dev.controller.vm;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dev.DemoApplication;
import dev.domain.Mission;
import dev.domain.NatureMission;
import dev.domain.Statut;
import dev.domain.Transport;
import dev.service.NatureMissionService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class VMUtilsTest {

	VMUtils<Mission, NatureMission, MissionVM> vmUtils;
	Mission mission;
	MissionVM missionVM;

	@Autowired
	NatureMissionService natureMissionService;

	@Before
	public void setUp() {
		this.vmUtils = new VMUtils<>();
		this.vmUtils.setEntityClass(Mission.class);
		this.vmUtils.setVMClass(MissionVM.class);
		NatureMission natureMission = new NatureMission("Prestation dev", true, true, 56, 30);
		natureMission.setId(1L);
		this.mission = new Mission(Statut.VALIDEE, LocalDate.now(), LocalDate.of(2018, 12, 1), "Madrid", "Paris",
				Transport.AVION, 500d, natureMission);
		this.mission.setId(1L);
		this.missionVM = new MissionVM(mission);
	}

	@Test
	public void testTransformIntoVM() {
		System.out.println("@testTransformIntoVM\nresult: " + this.vmUtils.transformIntoVM(this.mission));
		assertThat(this.vmUtils.transformIntoVM(this.mission).equals(this.missionVM));
	}

	@Test
	public void testTransformIntoEntity() {
		System.out.println("\n@testTransformIntoEntity\nresult: "
				+ this.vmUtils.transformIntoEntity(this.missionVM, natureMissionService));
		assertThat(this.vmUtils.transformIntoEntity(this.missionVM, natureMissionService).equals(this.mission));
	}

	public NatureMissionService getMissionService() {
		return natureMissionService;
	}

	public void setMissionService(NatureMissionService missionService) {
		this.natureMissionService = missionService;
	}

}

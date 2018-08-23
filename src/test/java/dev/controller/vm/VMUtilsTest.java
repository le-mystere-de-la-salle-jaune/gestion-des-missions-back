package dev.controller.vm;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dev.domain.Mission;
import dev.domain.Statut;
import dev.domain.Transport;

public class VMUtilsTest {

	VMUtils<Mission, MissionVM> vmUtils;
	Mission mission;
	MissionVM missionVM;

	@Before
	public void setUp() {
		this.vmUtils = new VMUtils<>(Mission.class, MissionVM.class);
		this.mission = new Mission(Statut.VALIDEE, LocalDate.now(), LocalDate.of(2018, 12, 1), "Madrid", "Paris",
				Transport.AVION, 500d);
		this.mission.setId(1L);
		this.missionVM = new MissionVM(mission);
		// System.out.println("@onSetup:\n Mission: " + this.mission +
		// "\nMissionVM: " + this.missionVM);
	}

	@Test
	public void testTransformIntoVM() {
		// System.out.println("@testTransformIntoVM\nresult: " +
		// this.vmUtils.transformIntoVM(this.mission));
		assertThat(this.vmUtils.transformIntoVM(this.mission).equals(this.missionVM));
	}

	@Test
	public void testTransformIntoEntity() {
		// System.out.println("@testTransformIntoEntity\nresult: " +
		// this.vmUtils.transformIntoEntity(this.missionVM));
		assertThat(this.vmUtils.transformIntoEntity(this.missionVM).equals(this.mission));
	}

}

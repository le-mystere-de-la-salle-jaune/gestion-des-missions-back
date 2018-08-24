import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dev.DemoApplication;
import dev.controller.vm.MissionVM;
import dev.controller.vm.VMUtils;
import dev.domain.Mission;
import dev.domain.NatureMission;
import dev.domain.Statut;
import dev.domain.Transport;
import dev.service.MissionService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class VMUtilsTest {

	VMUtils<Mission, MissionVM> vmUtils;
	Mission mission;
	MissionVM missionVM;

	@Autowired
	MissionService missionService;

	@Before
	public void setUp() {
		this.vmUtils = new VMUtils<>();
		this.vmUtils.setEntityClass(Mission.class);
		this.vmUtils.setVMClass(MissionVM.class);
		this.vmUtils.setService(this.missionService);
		this.mission = new Mission(Statut.VALIDEE, LocalDate.now(), LocalDate.of(2018, 12, 1), "Madrid", "Paris",
				Transport.AVION, 500d, new NatureMission("Prestation dev", true, true, 56, 30));
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

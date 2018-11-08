package be.switchfully.gameoflife.backend.status;

import be.switchfully.gameoflife.backend.UnitTest;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class StatusServiceTest extends UnitTest{

    private StatusService statusService;

    @Before
    public void setupStatusService() {
        statusService = new StatusService();
    }

    @Test
    public void getStatus_thenUpAndRunning() {
        String actualStatus = statusService.getStatus();
        Assertions.assertThat(actualStatus).isEqualTo("Up and running!");
    }

}
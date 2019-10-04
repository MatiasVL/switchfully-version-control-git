package be.switchfully.gameoflife.backend.status;

import be.switchfully.gameoflife.backend.UnitTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatusServiceTest extends UnitTest {

    private StatusService statusService;

    @BeforeEach
    public void setupStatusService() {
        statusService = new StatusService();
    }

    @Test
    public void getStatus_thenUpAndRunning() {
        String actualStatus = statusService.getStatus();
        Assertions.assertThat(actualStatus).isEqualTo("Up and running!");
    }

}
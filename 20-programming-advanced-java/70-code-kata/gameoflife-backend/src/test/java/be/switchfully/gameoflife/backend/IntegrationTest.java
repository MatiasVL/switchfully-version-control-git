package be.switchfully.gameoflife.backend;

import be.switchfully.gameoflife.GameOfLifeApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(
        classes = GameOfLifeApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public abstract class IntegrationTest {

    @LocalServerPort
    protected int port;

}

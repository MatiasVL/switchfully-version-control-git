package solid.solution_codelab01_single_responsiblity_principle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarManagerTest {
    private CarManager carManager;

    @BeforeEach
    public void setUp() throws Exception {
        carManager = new CarManager(new CarDao());
    }

    @Test
    public void testGetCarById() throws Exception {
        Car car = carManager.getCarById("1");
        assertEquals("Volkswagen", car.getBrand());
        assertEquals("Golf III", car.getModel());
    }

    @Test
    public void testGetCarsNames() throws Exception {
        String carsNames = carManager.getCarsNames();
        assertEquals("Volkswagen Golf III, Fiat Multipla, Renault Megane", carsNames);
    }

    @Test
    public void testGetBestCar() throws Exception {
        Car bestCar = carManager.getBestCar();
        assertEquals("Fiat", bestCar.getBrand());
        assertEquals("Multipla", bestCar.getModel());
    }
}

package solid.codelab01_single_responsiblity_principle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarManagerTest {
    private CarManager carManager;

    @BeforeEach
    void setUp() throws Exception {
        carManager = new CarManager();
    }

    @Test
    void testGetFromDb() throws Exception {
        Car car = carManager.getFromDb("1");
        assertEquals("Volkswagen", car.getBrand());
        assertEquals("Golf III", car.getModel());
    }

    @Test
    void testGetCarsNames() throws Exception {
        String carsNames = carManager.getCarsNames();
        assertEquals("Volkswagen Golf III, Fiat Multipla, Renault Megane", carsNames);
    }

    @Test
    void testGetBestCar() throws Exception {
        Car bestCar = carManager.getBestCar();
        assertEquals("Fiat", bestCar.getBrand());
        assertEquals("Multipla", bestCar.getModel());
    }
}

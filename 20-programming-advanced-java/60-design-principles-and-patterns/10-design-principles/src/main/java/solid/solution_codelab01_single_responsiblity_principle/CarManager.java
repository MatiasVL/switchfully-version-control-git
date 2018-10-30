package solid.solution_codelab01_single_responsiblity_principle;

import java.util.stream.Collectors;

public class CarManager {
    private final CarDao carDao;

    public CarManager(CarDao carDao) {
        this.carDao = carDao;
    }

    public Car getCarById(final String carId) {
        return this.carDao.findById(carId);
    }

    public String getCarsNames() {
        return this.carDao.findAll().stream()
                .map(Car::printCar)
                .collect(Collectors.joining(", "));
    }

    public Car getBestCar() {
        return this.carDao.findAll().stream()
                .max(Car::compareTo)
                .orElse(null);
    }
}

package solid.solution_codelab01_single_responsiblity_principle;

public class CarManager {
    private final CarDao carDao;
    private final CarFormatter carFormatter;
    private final CarRater carRater;

    public CarManager(CarDao carDao, CarFormatter carFormatter, CarRater carRater) {
        this.carDao = carDao;
        this.carFormatter = carFormatter;
        this.carRater = carRater;
    }

    public Car getCarById(final String carId) {
        return this.carDao.findById(carId);
    }

    public String getCarsNames() {
        return this.carFormatter.getCarsNames(this.carDao.findAll());
    }

    public Car getBestCar() {
        return this.carRater.getBestCar(this.carDao.findAll());
    }
}

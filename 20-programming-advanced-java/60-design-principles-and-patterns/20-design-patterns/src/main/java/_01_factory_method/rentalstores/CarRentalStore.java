package _01_factory_method.rentalstores;

import _01_factory_method.cars.RentalCar;

/**
 * All Car Rental Store implementations will go through
 * the same rental process: inspect, refuel and drive the rental car to the front.
 * However, each concrete Rental Store independently decides which Rental Cars to create,
 * based on the TerrainType. Only the concrete Rental Stores have the knowledge to create
 * the correct Rental Cars, based on the TerrainType.
 */
public abstract class CarRentalStore {

    public RentalCar rentCar(TerrainType terrainType) {
        RentalCar rental;

        rental = createRentalCar(terrainType);

        rental.inspect();
        rental.refuel();
        rental.driveToFront();

        return rental;
    }

    /**
     * The factory method which handles the object creation
     * and encapsulates it in the subclasses
     */
    abstract RentalCar createRentalCar(TerrainType terrainType);

}

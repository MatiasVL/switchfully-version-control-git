package _01_factory_method.rentalstores;

import _01_factory_method.cars.HeavyDutyOffRoader;
import _01_factory_method.cars.HeavyDutySUV;
import _01_factory_method.cars.RentalCar;

public class AntarcticCarRentalStore extends CarRentalStore {

    @Override
    protected RentalCar createRentalCar(TerrainType terrainType) {
        switch (terrainType) {
            case SMOOTH:
                return new HeavyDutySUV();
            case ROUGH:
                return new HeavyDutyOffRoader();
            default:
                return new HeavyDutySUV();
        }
    }
}

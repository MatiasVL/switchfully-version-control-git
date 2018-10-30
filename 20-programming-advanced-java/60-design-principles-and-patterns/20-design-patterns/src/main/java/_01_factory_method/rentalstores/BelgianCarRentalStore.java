package _01_factory_method.rentalstores;

import _01_factory_method.cars.RentalCar;
import _01_factory_method.cars.SimpleMondeo;
import _01_factory_method.cars.SmallSUV;

public class BelgianCarRentalStore extends CarRentalStore {

    @Override
    protected RentalCar createRentalCar(TerrainType terrainType) {
        switch (terrainType) {
            case SMOOTH:
                return new SimpleMondeo();
            case ROUGH:
                return new SmallSUV();
            default:
                return new SimpleMondeo();
        }
    }
}

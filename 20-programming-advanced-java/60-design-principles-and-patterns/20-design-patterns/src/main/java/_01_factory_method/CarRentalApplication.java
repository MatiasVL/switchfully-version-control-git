package _01_factory_method;

import _01_factory_method.cars.RentalCar;
import _01_factory_method.rentalstores.AntarcticCarRentalStore;
import _01_factory_method.rentalstores.BelgianCarRentalStore;
import _01_factory_method.rentalstores.CarRentalStore;

import static _01_factory_method.rentalstores.TerrainType.ROUGH;

public class CarRentalApplication {

    public static void main(String[] args) {
        CarRentalStore antarcticStore = new AntarcticCarRentalStore();
        CarRentalStore belgianStore = new BelgianCarRentalStore();

        RentalCar rentalCar1 = belgianStore.rentCar(ROUGH);
        System.out.println("--> We first ordered " + rentalCar1);

        System.out.println("---------------");

        RentalCar rentalCar2 = antarcticStore.rentCar(ROUGH);
        System.out.println("--> We then ordered " + rentalCar2);

    }

}

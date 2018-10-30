package codelab04;

import codelab04.vehicles.Truck;

/**
 * Read the README.md file
 */
public class ServiceStation {

    // We don't won't to change the signature of this method,
    // nor do we want to change the implementation. (Imagine you really can't change this method, that it is part of
    // compiled code we don't own)
    // However, we want it to be able to work with Car and Bus instances...
    public static void fill(Truck vehicleToFill)
    {
        vehicleToFill.fillMyTank();
    }

}

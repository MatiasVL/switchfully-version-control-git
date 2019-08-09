package com.switchfully.springdi.codelab01.v5.entities;

import com.switchfully.springdi.codelab01.v5.enums.DeliveryVanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryVan {
    private Driver driver;
    private DeliveryVanType vanType;

    @Autowired // The @Autowired annotation is
    public DeliveryVan (Driver driver, DeliveryVanType vanType) {
        this.driver = driver;
        this.vanType = vanType;
    }

    public boolean canDeliveryParcels() {
        if (vanType == DeliveryVanType.BIG) {
            return driver.canDriveLargeTruck();
        } else {
            return driver.canDriveSmallTruck();
        }
    }

    public String getDriverInfo(){
        return driver.getName();
    }
}

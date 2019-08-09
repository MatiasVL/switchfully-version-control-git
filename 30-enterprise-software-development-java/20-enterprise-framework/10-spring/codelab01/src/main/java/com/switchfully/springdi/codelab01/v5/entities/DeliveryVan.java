package com.switchfully.springdi.codelab01.v5.entities;

import com.switchfully.springdi.codelab01.v5.enums.DeliveryVanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class DeliveryVan {
    private Driver driver;
    private DeliveryVanType vanType;

    @Autowired
    // The @Autowired annotation can be omitted here (since spring vX), but is better to be explicit about it.
    // - When Reading the code, it becomes clear what will happen
    // - The code will not break in the future when an additional constructor is added
    // Reference: https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-spring-beans-and-dependency-injection.html
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

package com.switchfully.springdi.codelab01.v5.entities;

import com.switchfully.springdi.codelab01.v5.enums.DeliveryVanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class DeliveryVan {
    private Driver driver;
    private DeliveryVanType vanType;

    @Autowired
    // The @Autowired annotation can be omitted when a class only has 1 constructor (since spring v4.3), but is better to be explicit about it.
    // - When Reading the code, it becomes clear what will happen/what the intention is
    // - Issues are avoided in the future when an additional constructor is added
    // Reference: https://docs.spring.io/spring/docs/4.3.x/spring-framework-reference/htmlsingle/#beans-autowired-annotation
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

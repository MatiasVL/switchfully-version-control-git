package com.switchfully.springdi.codelab01.v5.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Driver {
    private String name;
    private int age;
    private DriversLicense license;

    @Autowired
    public Driver(DriversLicense license, @Qualifier("DriverName") String name, int age) {
        this.license = license;
        this.name = name;
        this.age = age;
    }

    public boolean canDriveSmallTruck() {
        return license.isPermitForSmallVehicle();
    }

    public boolean canDriveLargeTruck() {
        return license.isPermitForLargeVehicle();
    }

    public String getName() {
        return name;
    }
}

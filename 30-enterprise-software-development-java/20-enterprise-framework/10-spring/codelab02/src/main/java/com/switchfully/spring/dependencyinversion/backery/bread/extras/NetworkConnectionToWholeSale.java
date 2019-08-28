package com.switchfully.spring.dependencyinversion.backery.bread.extras;

import com.switchfully.spring.dependencyinversion.backery.bread.Bread;

public class NetworkConnectionToWholeSale {

    public Bread getBreadByName(String name) {

        return new Bread(name, name, 1);
    }
}

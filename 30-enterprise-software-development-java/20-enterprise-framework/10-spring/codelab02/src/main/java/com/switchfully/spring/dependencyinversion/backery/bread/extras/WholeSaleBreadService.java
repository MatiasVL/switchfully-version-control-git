package com.switchfully.spring.dependencyinversion.backery.bread.extras;

import com.switchfully.spring.dependencyinversion.backery.bread.Bread;

public class WholeSaleBreadService {

    public Bread getBreadByName(String name) {
        return new NetworkConnectionToWholeSale().getBreadByName(name);
    }
}

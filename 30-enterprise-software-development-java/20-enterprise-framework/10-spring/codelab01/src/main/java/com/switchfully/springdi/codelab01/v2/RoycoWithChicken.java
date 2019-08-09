package com.switchfully.springdi.codelab01.v2;

import org.springframework.stereotype.Component;

@Component
public class RoycoWithChicken implements Soup {
    @Override
    public void drink() {
        System.out.println("Mmmh, chicken soup");
    }
}

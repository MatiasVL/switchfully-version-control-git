package com.switchfully.spring.dependencyinversion.backery.bread;

public class SelfMadeBreadService {
    public Bread getBreadByName(String name) {
        return new NormalBreadRepository().getBreadByName(name);
    }
}

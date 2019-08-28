package com.switchfully.spring.dependencyinversion.backery.bread;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class NormalBreadRepository {

    Map<String, Bread> breadRepo = ImmutableMap.<String, Bread>builder()
            .put("witbrood", new Bread("witbrood", "wit", 2.20))
            .put("bruinbrood", new Bread("bruinbrood", "bruin", 2.20))
            .put("volkorenbrood", new Bread("volkorenbrood", "bruin", 2.50))
            .build();

    public Bread getBreadByName(String name) {
        return breadRepo.get(name);
    }
}

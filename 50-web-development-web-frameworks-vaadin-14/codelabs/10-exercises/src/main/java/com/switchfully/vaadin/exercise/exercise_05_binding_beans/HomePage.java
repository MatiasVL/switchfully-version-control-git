package com.switchfully.vaadin.exercise.exercise_05_binding_beans;

import com.switchfully.vaadin.exercise.exercise_05_binding_beans.components.AccomodationAdmin;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/5")
public class HomePage extends VerticalLayout {

    private AccomodationService accomodationService;
    private CityService cityService;

    @Autowired
    public HomePage(AccomodationService accomodationService, CityService cityService) {
        this.accomodationService = accomodationService;
        this.cityService = cityService;
        add(new AccomodationAdmin(this.accomodationService, this.cityService));
    }

}
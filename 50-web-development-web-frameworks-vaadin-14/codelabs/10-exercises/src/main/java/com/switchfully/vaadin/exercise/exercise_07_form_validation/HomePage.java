package com.switchfully.vaadin.exercise.exercise_07_form_validation;

import com.switchfully.vaadin.exercise.exercise_07_form_validation.components.AccommodationAdmin;
import com.switchfully.vaadin.service.AccommodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/7")
public class HomePage extends VerticalLayout {

    private AccommodationService accommodationService;
    private CityService cityService;

    @Autowired
    public HomePage(AccommodationService accommodationService, CityService cityService) {
        this.accommodationService = accommodationService;
        this.cityService = cityService;
        add(new AccommodationAdmin(this.accommodationService, this.cityService));
    }

}
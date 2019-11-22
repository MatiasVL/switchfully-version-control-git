package com.switchfully.vaadin.exercise.exercise_13_model_view_presenter;

import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/13")
public class HomePage extends VerticalLayout {

    @Autowired
    public HomePage(AccomodationService accomodationService, CityService cityService) {
        // TODO 13-model-view-presenter: Take the solution from Exercise 7.
        // Try to implement it by using the Model-View-Presenter pattern.
    }

}
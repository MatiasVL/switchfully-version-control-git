package com.switchfully.vaadin.exercise.exercise_13_model_view_presenter;

import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.switchfully.vaadin.exercise.exercise_13_model_view_presenter.components.AccomodationAdminModel;
import com.switchfully.vaadin.exercise.exercise_13_model_view_presenter.components.AccomodationAdminPresenter;
import com.switchfully.vaadin.exercise.exercise_13_model_view_presenter.components.AccomodationAdminViewImpl;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/13")
public class HomePage extends AccomodationAdminViewImpl {

    @Autowired
    public HomePage(AccomodationService accomodationService, CityService cityService) {
        new AccomodationAdminPresenter(new AccomodationAdminModel(accomodationService, cityService), this);
    }

}
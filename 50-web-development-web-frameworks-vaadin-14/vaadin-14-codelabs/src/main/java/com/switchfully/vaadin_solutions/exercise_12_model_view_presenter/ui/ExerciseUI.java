package com.switchfully.vaadin_solutions.exercise_12_model_view_presenter.ui;

import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.switchfully.vaadin_solutions.exercise_12_model_view_presenter.ui.components.AccomodationAdminModel;
import com.switchfully.vaadin_solutions.exercise_12_model_view_presenter.ui.components.AccomodationAdminPresenter;
import com.switchfully.vaadin_solutions.exercise_12_model_view_presenter.ui.components.AccomodationAdminViewImpl;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class ExerciseUI extends AccomodationAdminViewImpl {

    @Autowired
    public ExerciseUI(AccomodationService accomodationService, CityService cityService) {
        new AccomodationAdminPresenter(new AccomodationAdminModel(accomodationService, cityService), this);
    }

}
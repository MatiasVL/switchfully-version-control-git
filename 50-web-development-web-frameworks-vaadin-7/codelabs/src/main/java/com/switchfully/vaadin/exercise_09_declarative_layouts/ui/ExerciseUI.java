package com.switchfully.vaadin.exercise_09_declarative_layouts.ui;

import com.switchfully.vaadin.exercise_09_declarative_layouts.ui.views.AccomodationDetailView;
import com.switchfully.vaadin.exercise_09_declarative_layouts.ui.views.SearchAccomodationView;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class ExerciseUI extends UI {

    public static final String VIEW_ACCOMODATION_HOME = "";
    public static final String VIEW_ACCOMODATION_DETAIL = "detail";

    private AccomodationService accomodationService;
    private Navigator navigator;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @Override
    protected void init(VaadinRequest request) {
        navigator = new Navigator(this, this);

        navigator.addView(VIEW_ACCOMODATION_HOME, new SearchAccomodationView(accomodationService));
        navigator.addView(VIEW_ACCOMODATION_DETAIL, new AccomodationDetailView(accomodationService));
    }

}
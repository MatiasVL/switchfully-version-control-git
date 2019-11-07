package com.switchfully.vaadin.exercise_07_images.ui;

import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class ExerciseUI {

    private AccomodationService accomodationService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

//    @Override
//    protected void init(VaadinRequest request) {
//        AccomodationResultList resultList = new AccomodationResultList();
//
//        TextField searchField = new TextField();
//        Button searchButton = new Button("Search",
//                event -> resultList.setAccomodations(
//                accomodationService.findAccomodations(searchField.getValue())
//        ));
//
//        HorizontalLayout searchLayout = new HorizontalLayout(searchField, searchButton);
//
//        VerticalLayout mainLayout = new VerticalLayout(searchLayout, resultList);
//        setContent(mainLayout);
//    }

}
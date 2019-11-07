package com.switchfully.vaadin_solutions.exercise_07_images.ui;

import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin_solutions.exercise_07_images.ui.components.AccomodationResultList;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class ExerciseUI extends VerticalLayout {

    private AccomodationService accomodationService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;

        AccomodationResultList resultList = new AccomodationResultList();

        TextField searchField = new TextField();
        Button searchButton = new Button("Search",
                event -> resultList.setAccomodations(
                accomodationService.findAccomodations(searchField.getValue())
        ));

        HorizontalLayout searchLayout = new HorizontalLayout(searchField, searchButton);

        add(searchLayout, resultList);
    }

}
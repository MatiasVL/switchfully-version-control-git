package com.switchfully.vaadin.exercise_08_navigation.ui;

import com.switchfully.vaadin.exercise_08_navigation.ui.components.AccomodationResultList;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class ExerciseUI extends VerticalLayout {

    private AccomodationService accomodationService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
        // TODO Exercise 8: Add an accomodation Detail view that is opened when you click on a result in the list.
        // TODO Exercise 8: Use the Vaadin Navigator to navigate between the list and detail views. Make the detail view have a different url, such as: /accomodation/{id} so that this view is bookmarkable and supports the back button.

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
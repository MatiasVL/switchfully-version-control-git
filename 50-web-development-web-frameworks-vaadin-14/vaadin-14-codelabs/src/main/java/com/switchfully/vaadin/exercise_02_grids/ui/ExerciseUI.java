package com.switchfully.vaadin.exercise_02_grids.ui;

import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class ExerciseUI extends VerticalLayout {

    private AccomodationService accomodationService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
        // TODO Exercise 2: Show the list of accomodations from accomodationService.getAccomodations() in a Grid.

        // Use BeanItemContainer as the ContainerDataSource for the Grid.

        // Try to only show the following properties of an accomodation:
        // - Name
        // - Star Rating
        // - City Name

        setMargin(true);
    }

}
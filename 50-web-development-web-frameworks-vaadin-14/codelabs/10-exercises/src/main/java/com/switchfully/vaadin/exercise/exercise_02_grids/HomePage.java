package com.switchfully.vaadin.exercise.exercise_02_grids;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/2")
public class HomePage extends VerticalLayout {

    private Grid<Accomodation> grid = new Grid<>(Accomodation.class);


    @Autowired
    public HomePage(AccomodationService accomodationService) {
        // TODO 02-grids: Show a grid on screen that shows the accomodations you get from accomodationService.getAccomodations().
        // Try to only show the following properties of an accomodation, in that order:
        // - Name
        // - Star Rating
        // - City Name
    }

}

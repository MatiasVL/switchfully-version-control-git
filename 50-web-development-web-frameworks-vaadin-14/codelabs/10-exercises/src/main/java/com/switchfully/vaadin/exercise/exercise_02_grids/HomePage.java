package com.switchfully.vaadin.exercise.exercise_02_grids;

import com.switchfully.vaadin.domain.Accommodation;
import com.switchfully.vaadin.service.AccommodationService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/2")
public class HomePage extends VerticalLayout {

    private Grid<Accommodation> grid = new Grid<>(Accommodation.class);


    @Autowired
    public HomePage(AccommodationService accommodationService) {
        // TODO 02-grids: Show a grid on screen that shows the accommodations you get from accommodationService.getAccommodations().
        // Try to only show the following properties of an accommodation, in that order:
        // - Name
        // - Star Rating
        // - City Name
    }

}

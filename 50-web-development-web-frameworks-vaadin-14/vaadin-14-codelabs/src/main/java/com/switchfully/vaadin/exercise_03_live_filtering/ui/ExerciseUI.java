package com.switchfully.vaadin.exercise_03_live_filtering.ui;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class ExerciseUI extends VerticalLayout {

    private Grid<Accomodation> grid = new Grid<>();

    private AccomodationService accomodationService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
        add(grid);

        grid.setItems(accomodationService.getAccomodations());

        grid.addColumn(accomodation -> accomodation.getCity().getName()).setHeader("City").setId("city.name");

        grid.setColumns("name", "starRating", "city.name");

        // TODO Exercise 3: Add a filter TextField to the top of the grid to filter the list of accomodations by name.
        // TODO Exercise 3: Add a button next to the filter TextField to clear the filter.

        setMargin(true);
    }

}
package com.switchfully.vaadin_solutions.exercise_02_grids.ui;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class ExerciseUI extends VerticalLayout {

    private AccomodationService accomodationService;
    private Grid<Accomodation> grid = new Grid<>();


    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;

        // Use BeanItemContainer as the ContainerDataSource for the Grid.

        // Try to only show the following properties of an accomodation:
        // - Name
        // - Star Rating
        // - City Name

        grid.setItems(accomodationService.getAccomodations());
        grid.addColumn(accomodation -> accomodation.getCity().getName()).setHeader("City").setId("city.name");
        grid.setColumns("name", "starRating", "city.name");

        add(grid);

        setMargin(true);
    }

}

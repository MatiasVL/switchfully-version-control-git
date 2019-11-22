package com.switchfully.vaadin.exercise.exercise_03_live_filtering;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/3")
//@Theme(value = Material.class, variant = Material.DARK)
public class HomePage extends VerticalLayout {

    private Grid<Accomodation> grid = new Grid<>(Accomodation.class);

    private AccomodationService accomodationService;
    private ListDataProvider<Accomodation> accomodationsDataProvider;

    @Autowired
    public HomePage(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;

        accomodationsDataProvider = DataProvider.ofCollection(accomodationService.getAccomodations());
        populateGrid(accomodationsDataProvider);

        // TODO 03-live_filtering: Add a filter TextField to the top of the grid to filter the list of accomodations by their name.
        // TODO 03-live_filtering: Add a button next to the filter TextField to clear the filter.
    }

    private void populateGrid(ListDataProvider<Accomodation> dataProvider) {
        grid.setDataProvider(dataProvider);
        grid.addColumn(accomodation -> accomodation.getCity().getName()).setHeader("City").setId("city.name");
        grid.setColumns("name", "starRating", "city.name");
    }

}
package com.switchfully.vaadin.exercise.exercise_03_live_filtering;

import com.switchfully.vaadin.domain.Accommodation;
import com.switchfully.vaadin.service.AccommodationService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/3")
//@Theme(value = Material.class, variant = Material.DARK)
public class HomePage extends VerticalLayout {

    private Grid<Accommodation> grid = new Grid<>(Accommodation.class);

    private AccommodationService accommodationService;
    private ListDataProvider<Accommodation> accommodationsDataProvider;

    @Autowired
    public HomePage(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;

        accommodationsDataProvider = DataProvider.ofCollection(accommodationService.getAccommodations());
        populateGrid(accommodationsDataProvider);

        // TODO 03-live_filtering: Add a filter TextField to the top of the grid to filter the list of accommodations by their name.
        // TODO 03-live_filtering: Add a button next to the filter TextField to clear the filter.
    }

    private void populateGrid(ListDataProvider<Accommodation> dataProvider) {
        grid.setDataProvider(dataProvider);
        grid.addColumn(accommodation -> accommodation.getCity().getName()).setHeader("City").setId("city.name");
        grid.setColumns("name", "starRating", "city.name");
    }

}
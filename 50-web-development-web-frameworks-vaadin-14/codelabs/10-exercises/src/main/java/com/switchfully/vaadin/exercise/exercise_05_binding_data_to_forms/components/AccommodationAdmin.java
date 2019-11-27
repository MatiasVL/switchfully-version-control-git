package com.switchfully.vaadin.exercise.exercise_05_binding_data_to_forms.components;

import com.switchfully.vaadin.domain.Accommodation;
import com.switchfully.vaadin.service.AccommodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;

import java.util.ArrayList;

public class AccommodationAdmin extends Composite<VerticalLayout> {

    private final AccommodationService accommodationService;
    private Grid<Accommodation> grid = new Grid(Accommodation.class, false);

    private TextField filter;
    private Button newAccommodationButton;
    private ListDataProvider<Accommodation> accommodationsDataProvider;

    public AccommodationAdmin(AccommodationService accommodationService, CityService cityService) {
        this.accommodationService = accommodationService;
        accommodationsDataProvider = DataProvider.ofCollection(new ArrayList<>(accommodationService.getAccommodations()));
        populateGrid(accommodationsDataProvider);
        Div filtering = createFilterComponent();

        // TODO 05-binding-data-to-forms: Part 1: Update an existing accommodation
        // Create an EditAccommodationForm and add it to the right of the grid to
        // edit details of an accommodation.

        // TODO 05-binding-data-to-forms: Part 2: Adding a new accommodation
        // Add a 'Add new accommodation button' that opens an empty EditAccommodationForm form to add a new Accommodation.
        // Create the new Accommodation when the save-button is clicked. Use AccommodationService.save() to save the entity.

        // TODO 05-binding-data-to-forms: Part 3: Deleting an accommodation
        // Add a Delete button to delete the entity (in EditAccommodationForm).
        // Use AccommodationService.delete() to delete the entity..

        // TODO 05-binding-data-to-forms: Part 4: Add a cancel button
        // Add a Cancel button to the form that closes the form.

        // TODO 05-binding-data-to-forms: Part 5: Notifications
        // Show notifications when adding, updating and deleting accommodations.  Use Notification.show().

        // TODO 05-binding-data-to-forms: Part 6: Extra credits
        // Add a DateField to the form for the 'dateCreated' property of Accommodation. Make this read-only.
        // Hide it when creating a new Accommodation.

        getContent().add(filtering, grid);
    }

    private Div createFilterComponent() {
        filter = new TextField();
        filter.setPlaceholder("Filter by name...");
        filter.addValueChangeListener(e -> {
            accommodationsDataProvider.setFilter(Accommodation::getName, name -> name.toLowerCase().contains(e.getValue().toLowerCase()));
        });

        Button clearFilterTextBtn = new Button(new Icon(VaadinIcon.CLOSE));
        clearFilterTextBtn.getElement().setProperty("title", "Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> {
            filter.clear();
            accommodationsDataProvider.clearFilters();
        });

        Div filtering = new Div();
        filtering.add(filter, clearFilterTextBtn);
        return filtering;
    }

    private void populateGrid(ListDataProvider<Accommodation> dataProvider) {
        grid.setDataProvider(dataProvider);
        grid.addColumn("name");
        grid.addColumn(accommodation -> accommodation.getStarRating().getNumberOfStars() + (accommodation.getStarRating().getNumberOfStars() == 1 ? " star" : " stars")).setHeader("Star Rating").setId("starRating");
        grid.addColumn("city.name").setHeader("City").setId("city");
    }

}

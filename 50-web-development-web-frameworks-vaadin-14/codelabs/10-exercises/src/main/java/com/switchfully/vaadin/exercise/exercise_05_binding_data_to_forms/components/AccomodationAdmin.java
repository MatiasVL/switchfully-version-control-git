package com.switchfully.vaadin.exercise.exercise_05_binding_data_to_forms.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;

import java.util.ArrayList;

public class AccomodationAdmin extends Composite<VerticalLayout> {

    private final AccomodationService accomodationService;
    private Grid<Accomodation> grid = new Grid(Accomodation.class, false);

    private TextField filter;
    private Button newAccomodationButton;
    private ListDataProvider<Accomodation> accomodationsDataProvider;

    public AccomodationAdmin(AccomodationService accomodationService, CityService cityService) {
        this.accomodationService = accomodationService;
        accomodationsDataProvider = DataProvider.ofCollection(new ArrayList<>(accomodationService.getAccomodations()));
        populateGrid(accomodationsDataProvider);
        Div filtering = createFilterComponent();

        // TODO 05-binding-data-to-forms: Part 1: Update an existing accomodation
        // Create an EditAccomodationForm and add it to the right of the grid to
        // edit details of an accomodation.

        // TODO 05-binding-data-to-forms: Part 2: Adding a new accomodation
        // Add a 'Add new accomodation button' that opens an empty EditAccomodationForm form to add a new Accomodation.
        // Create the new Accomodation when the save-button is clicked. Use AccomodationService.save() to save the entity.

        // TODO 05-binding-data-to-forms: Part 3: Deleting an accomodation
        // Add a Delete button to delete the entity (in EditAccomodationForm).
        // Use AccomodationService.delete() to delete the entity..

        // TODO 05-binding-data-to-forms: Part 4: Add a cancel button
        // Add a Cancel button to the form that closes the form.

        // TODO 05-binding-data-to-forms: Part 5: Notifications
        // Show notifications when adding, updating and deleting accomodations.  Use Notification.show().

        // TODO 05-binding-data-to-forms: Part 6: Extra credits
        // Add a DateField to the form for the 'dateCreated' property of Accomodation. Make this read-only.
        // Hide it when creating a new Accomodation.

        getContent().add(filtering, grid);
    }

    private Div createFilterComponent() {
        filter = new TextField();
        filter.setPlaceholder("Filter by name...");
        filter.addValueChangeListener(e -> {
            accomodationsDataProvider.setFilter(Accomodation::getName, name -> name.toLowerCase().contains(e.getValue().toLowerCase()));
        });

        Button clearFilterTextBtn = new Button(new Icon(VaadinIcon.CLOSE));
        clearFilterTextBtn.getElement().setProperty("title", "Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> {
            filter.clear();
            accomodationsDataProvider.clearFilters();
        });

        Div filtering = new Div();
        filtering.add(filter, clearFilterTextBtn);
        return filtering;
    }

    private void populateGrid(ListDataProvider<Accomodation> dataProvider) {
        grid.setDataProvider(dataProvider);
        grid.addColumn("name");
        grid.addColumn(accomodation -> accomodation.getStarRating().getNumberOfStars() + (accomodation.getStarRating().getNumberOfStars() == 1 ? " star" : " stars")).setHeader("Star Rating").setId("starRating");
        grid.addColumn("city.name").setHeader("City").setId("city");
    }

}

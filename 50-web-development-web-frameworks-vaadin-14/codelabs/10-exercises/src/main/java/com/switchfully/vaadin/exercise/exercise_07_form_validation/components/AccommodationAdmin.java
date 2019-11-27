package com.switchfully.vaadin.exercise.exercise_07_form_validation.components;

import com.switchfully.vaadin.domain.Accommodation;
import com.switchfully.vaadin.service.AccommodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;

import java.util.ArrayList;

import static com.switchfully.vaadin.domain.Accommodation.AccommodationBuilder.accommodation;

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

        // Add a form to the right of the grid to edit details of an accommodation.

        EditAccommodationForm form = new EditAccommodationForm(this, accommodationService, cityService);
        form.setVisible(false);
        form.setWidth("600px");

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setWidthFull();
        main.setFlexGrow(1, grid);

        grid.addSelectionListener(event -> {
            if (event.getAllSelectedItems().isEmpty()) {
                form.setVisible(false);
            } else {
                Accommodation accommodation = event.getAllSelectedItems().iterator().next();
                form.setAccommodation(accommodation);
            }
        });

        newAccommodationButton = new Button("Add new accommodation");
        newAccommodationButton.addClickListener(e -> form.setAccommodation(accommodation().build()));

        HorizontalLayout toolbar = new HorizontalLayout(filtering, newAccommodationButton);

        getContent().add(toolbar, main);
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

    void updateList() {
        filter.clear();
        accommodationsDataProvider.getItems().clear();
        accommodationsDataProvider.getItems().addAll(accommodationService.getAccommodations());
        accommodationsDataProvider.refreshAll();
    }

}

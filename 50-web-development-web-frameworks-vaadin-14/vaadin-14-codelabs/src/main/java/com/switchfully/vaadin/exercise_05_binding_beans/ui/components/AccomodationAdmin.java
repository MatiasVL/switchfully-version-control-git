package com.switchfully.vaadin.exercise_05_binding_beans.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
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

import java.util.List;

public class AccomodationAdmin extends Composite<VerticalLayout> {

    private Grid<Accomodation> grid = new Grid<>();

    private AccomodationService accomodationService;
    private CityService cityService;
    private TextField filter;
    private ListDataProvider<Accomodation> accomodationsDataProvider;

    public AccomodationAdmin(AccomodationService accomodationService, CityService cityService) {
        this.accomodationService = accomodationService;
        this.cityService = cityService;

        accomodationsDataProvider = DataProvider.ofCollection(accomodationService.getAccomodations());
        populateGrid(accomodationsDataProvider);
        Div filtering = createFilterComponent();

        // TODO Exercise 5: Add a 'New Accomodation' button.
        // TODO Exercise 5: Create an EditAccomodationForm and add it to the right of the grid to add a new accomodation.
        // TODO Exercise 5: When selecting an accomodation in the grid, load it in the EditAccomodationForm to update it.
        // TODO Exercise 5: Add a 'Delete' button to the form to delete an accomodation.
        // TODO Exercise 5: Add a 'Cancel' button to the form to close the form.
        // TODO Exercise 5 (Extra): Add ta DateField for creationDate to the form.

        HorizontalLayout toolbar = new HorizontalLayout(filtering);
        toolbar.setSpacing(true);

        getContent().add(toolbar, grid);
        getContent().setMargin(true);
    }

    private Div createFilterComponent() {
        filter = new TextField();
        filter.setPlaceholder("Filter by name...");
        filter.addValueChangeListener(e -> {
            accomodationsDataProvider.setFilter(Accomodation::getName, name -> name.toLowerCase().contains(e.getValue().toLowerCase()));
        });

        Button clearFilterTextBtn = new Button(new Icon(VaadinIcon.DEL));
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
        grid.addColumn(accomodation -> accomodation.getCity().getName()).setHeader("City").setId("city.name");
        grid.setColumns("name", "starRating", "city.name");
    }

}

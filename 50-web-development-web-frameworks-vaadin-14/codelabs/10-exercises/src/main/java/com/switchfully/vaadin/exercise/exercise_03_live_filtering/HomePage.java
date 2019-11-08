package com.switchfully.vaadin.exercise.exercise_03_live_filtering;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
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
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;
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

        // TODO 30-live_filtering: Add a filter TextField to the top of the grid to filter the list of accomodations by their name.
        // TODO 30-live_filtering: Add a button next to the filter TextField to clear the filter.

        // SOLUTION_START
        TextField filter = new TextField();
        filter.setPlaceholder("Filter by name...");
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> accomodationsDataProvider.setFilter(
                Accomodation::getName, name -> name.toLowerCase().contains(e.getValue().toLowerCase())));

        Button clearFilterTextBtn = new Button(new Icon(VaadinIcon.CLOSE));
        clearFilterTextBtn.getElement().setProperty("title", "Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> {
            filter.clear();
            accomodationsDataProvider.clearFilters();
        });

        Div filtering = new Div();
        filtering.add(filter, clearFilterTextBtn);

        add(filtering, grid);
        // SOLUTION_END
    }

    private void populateGrid(ListDataProvider<Accomodation> dataProvider) {
        grid.setDataProvider(dataProvider);
        grid.addColumn(accomodation -> accomodation.getCity().getName()).setHeader("City").setId("city.name");
        grid.setColumns("name", "starRating", "city.name");
    }

}
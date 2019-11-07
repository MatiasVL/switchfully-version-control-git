package com.switchfully.vaadin_solutions.exercise_06_validation.ui.components;

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

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.accomodation;

public class AccomodationAdmin extends Composite<VerticalLayout> {

    private Grid<Accomodation> grid = new Grid();

    private AccomodationService accomodationService;
    private CityService cityService;
    private TextField filter;
    private Button newAccomodationButton;
    private ListDataProvider<Accomodation> accomodationsDataProvider;

    public AccomodationAdmin(AccomodationService accomodationService, CityService cityService) {
        this.accomodationService = accomodationService;
        this.cityService = cityService;

        List<Accomodation> accomodations = accomodationService.getAccomodations();
        accomodationsDataProvider = DataProvider.ofCollection(accomodations);
        populateGrid(accomodationsDataProvider);
        Div filtering = createFilterComponent();

        // Add a form to the right of the grid to edit details of an accomodation.

        EditAccomodationForm form = new EditAccomodationForm(this, accomodationService, cityService);
        form.setVisible(false);

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setSpacing(true);
        main.setSizeFull();
        grid.setSizeFull();
        main.setFlexGrow(1, grid);

        grid.addSelectionListener(event -> {
            if (event.getAllSelectedItems().isEmpty()) {
                form.setVisible(false);
            } else {
                Accomodation accomodation = event.getAllSelectedItems().iterator().next();
                form.setAccomodation(accomodation);
            }
        });

        newAccomodationButton = new Button("Add new accomodation");
        newAccomodationButton.addClickListener(e -> form.setAccomodation(accomodation().build()));

        HorizontalLayout toolbar = new HorizontalLayout(filtering, newAccomodationButton);
        toolbar.setSpacing(true);

        getContent().add(toolbar, main);
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

    public void updateList() {
        filter.clear();
        populateGrid(accomodationsDataProvider);
    }

}

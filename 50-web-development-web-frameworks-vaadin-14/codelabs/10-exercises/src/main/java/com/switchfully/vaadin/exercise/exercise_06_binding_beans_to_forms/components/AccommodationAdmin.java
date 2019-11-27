package com.switchfully.vaadin.exercise.exercise_06_binding_beans_to_forms.components;

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

        // TODO 06-binding-beans-to-forms: Take your solution from exercise 5 and copy it in this exercise.
        //  Remove all the binding logic.
        //  Now use `Binder.bindInstanceFields()` to automatically bind the fields in `EditAccommodationForm` to the `Accommodation`
        //  bean based on the field names.
        //  Make sure that the java field names for the form components match the properties of `Accommodation`.
        //  Do not forget to register the DoubleToIntegerConverter for the number of rooms.  You can use `Binder.forMemberField()` for that.

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

    void updateList() {
        filter.clear();
        accommodationsDataProvider.getItems().clear();
        accommodationsDataProvider.getItems().addAll(accommodationService.getAccommodations());
        accommodationsDataProvider.refreshAll();
    }

}

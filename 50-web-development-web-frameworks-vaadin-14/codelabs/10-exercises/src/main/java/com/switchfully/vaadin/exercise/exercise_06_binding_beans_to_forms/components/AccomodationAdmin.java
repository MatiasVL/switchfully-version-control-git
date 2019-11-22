package com.switchfully.vaadin.exercise.exercise_06_binding_beans_to_forms.components;

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

import java.util.ArrayList;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.accomodation;

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

        // TODO 06-binding-beans-to-forms: Take your solution from exercise 5 and copy it in this exercise.
        //  Remove all the binding logic.
        //  Now use `Binder.bindInstanceFields()` to automatically bind the fields in `EditAccomodationForm` to the `Accomodation`
        //  bean based on the field names.
        //  Make sure that the java field names for the form components match the properties of `Accomodation`.
        //  Do not forget to register the DoubleToIntegerConverter for the number of rooms.  You can use `Binder.forMemberField()` for that.

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

    void updateList() {
        filter.clear();
        accomodationsDataProvider.getItems().clear();
        accomodationsDataProvider.getItems().addAll(accomodationService.getAccomodations());
        accomodationsDataProvider.refreshAll();
    }

}

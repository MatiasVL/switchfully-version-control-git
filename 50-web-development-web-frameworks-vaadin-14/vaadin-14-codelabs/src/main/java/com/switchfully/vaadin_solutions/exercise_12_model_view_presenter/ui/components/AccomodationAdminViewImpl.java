package com.switchfully.vaadin_solutions.exercise_12_model_view_presenter.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
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
import java.util.List;

public class AccomodationAdminViewImpl extends Composite<VerticalLayout> implements AccomodationAdminView, EditAccomodationForm.EditAccomodationFormListener {

    private Grid<Accomodation> grid = new Grid(Accomodation.class);

    private TextField filter;
    private Button newAccomodationButton;

    private List<Accomodation> accomodations = new ArrayList<>();
    private List<AccomodationAdminViewListener> listeners =
            new ArrayList<>();
    private final EditAccomodationForm form;
    private ListDataProvider<Accomodation> accomodationsDataProvider;

    public AccomodationAdminViewImpl() {
        accomodationsDataProvider = DataProvider.ofCollection(accomodations);
        populateGrid(accomodationsDataProvider);

        Div filtering = createFilterComponent();

        // Add a form to the right of the grid to edit details of an accomodation.

        form = new EditAccomodationForm();
        form.addListener(this);
        form.setVisible(false);

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setSpacing(true);
        main.setSizeFull();
        grid.setSizeFull();
        main.setFlexGrow(1, grid);

        grid.addSelectionListener(event -> {
            if (event.getAllSelectedItems().isEmpty()) {
                listeners.forEach(l -> l.accomodationSelected(null));
            } else {
                listeners.forEach(l -> l.accomodationSelected(event.getAllSelectedItems().iterator().next()));
            }
        });

        newAccomodationButton = new Button("Add new accomodation");
        newAccomodationButton.addClickListener(e -> listeners.forEach(l -> l.addNewAccomodationClicked()));

        HorizontalLayout toolbar = new HorizontalLayout(filtering, newAccomodationButton);
        toolbar.setSpacing(true);

        getContent().add(toolbar, main);
        getContent().setMargin(true);
    }

    @Override
    public void addListener(AccomodationAdminViewListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void setSearchResults(List<Accomodation> accomodations) {
        this.accomodations.clear();
        this.accomodations.addAll(accomodations);
        this.accomodationsDataProvider.refreshAll();
    }

    @Override
    public void setActiveAccomodation(Accomodation accomodation) {
        if (accomodation == null) {
            this.form.setVisible(false);
        } else {
            this.form.setVisible(true);
            this.form.setAccomodation(accomodation);
        }
    }

    @Override
    public void setSearchFilter(String searchFilter) {
        this.filter.setValue(searchFilter);
    }

    @Override
    public void setCities(List<City> cities) {
        this.form.setCities(cities);
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

    @Override
    public void saveAccomodationClicked(Accomodation accomodation) {
        listeners.forEach(l -> l.acccomodationSaved(accomodation));
    }

    @Override
    public void deleteAccomodationClicked(Accomodation accomodation) {
        listeners.forEach(l -> l.accomodationDeleted(accomodation));
    }

    @Override
    public void cancelClicked() {
        listeners.forEach(l -> l.accomodationFormCanceled());
    }
}


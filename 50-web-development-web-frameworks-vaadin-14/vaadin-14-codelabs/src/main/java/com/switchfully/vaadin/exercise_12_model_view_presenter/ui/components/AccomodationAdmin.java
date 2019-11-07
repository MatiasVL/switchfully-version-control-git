package com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;

public class AccomodationAdmin extends Composite<VerticalLayout> {

//    private Grid grid = new Grid();

    private AccomodationService accomodationService;
    private CityService cityService;
    private TextField filter;
    private Button newAccomodationButton;
    private ListDataProvider<Accomodation> dataProvider;

    public AccomodationAdmin(AccomodationService accomodationService, CityService cityService) {
//        this.accomodationService = accomodationService;
//        this.cityService = cityService;
//
//        List<Accomodation> accomodations = accomodationService.getAccomodations();
//        populateGrid(accomodations);
//        CssLayout filtering = createFilterComponent();
//
//        // Add a form to the right of the grid to edit details of an accomodation.
//
//        EditAccomodationForm form = new EditAccomodationForm(this, accomodationService, cityService);
//        form.setVisible(false);
//
//        HorizontalLayout main = new HorizontalLayout(grid, form);
//        main.setSpacing(true);
//        main.setSizeFull();
//        grid.setSizeFull();
//        main.setExpandRatio(grid, 1);
//
//        grid.addSelectionListener(event -> {
//            if (event.getSelected().isEmpty()) {
//                form.setVisible(false);
//            } else {
//                Accomodation accomodation = (Accomodation) event.getSelected().iterator().next();
//                form.setAccomodation(accomodation);
//            }
//        });
//
//        newAccomodationButton = new Button("Add new accomodation");
//        newAccomodationButton.addClickListener(e -> form.setAccomodation(accomodation().build()));
//
//        HorizontalLayout toolbar = new HorizontalLayout(filtering, newAccomodationButton);
//        toolbar.setSpacing(true);
//
//
//        VerticalLayout mainLayout = new VerticalLayout(toolbar, main);
//        mainLayout.setMargin(true);
//        setCompositionRoot(mainLayout);
    }
//
//    private CssLayout createFilterComponent() {
//        filter = new TextField();
//        filter.setInputPrompt("Filter by name...");
//        filter.addTextChangeListener(e -> {
//            dataProvider.removeAllContainerFilters();
//            dataProvider.addContainerFilter(new SimpleStringFilter("name", e.getText(), true, false));
//        });
//
//        Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
//        clearFilterTextBtn.setDescription("Clear the current filter");
//        clearFilterTextBtn.addClickListener(e -> {
//            filter.clear();
//            dataProvider.removeAllContainerFilters();
//        });
//
//        CssLayout filtering = new CssLayout();
//        filtering.addComponents(filter, clearFilterTextBtn);
//        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
//        return filtering;
//    }
//
//    private void populateGrid(List<Accomodation> accomodations) {
//        dataProvider = new BeanItemContainer<>(Accomodation.class, accomodations);
//
//        dataProvider.addNestedContainerProperty("city.name");
//
//        grid.setColumns("name", "starRating", "city.name");
//
//        grid.getColumn("city.name").setHeaderCaption("City");
//
//        grid.setContainerDataSource(dataProvider);
//    }
//
//    public void updateList() {
//        filter.clear();
//        populateGrid(accomodationService.getAccomodations());
//    }

}
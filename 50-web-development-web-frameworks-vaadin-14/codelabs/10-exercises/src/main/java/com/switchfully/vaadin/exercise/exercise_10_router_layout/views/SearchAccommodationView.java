package com.switchfully.vaadin.exercise.exercise_10_router_layout.views;

import com.switchfully.vaadin.exercise.exercise_10_router_layout.components.AccommodationResultList;
import com.switchfully.vaadin.service.AccommodationService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "exercises/10/accommodations/search")
public class SearchAccommodationView extends Composite<VerticalLayout> {

    public SearchAccommodationView(AccommodationService accommodationService) {
        AccommodationResultList resultList = new AccommodationResultList();

        TextField searchField = new TextField();
        Button searchButton = new Button("Search",
                event -> resultList.setAccommodations(
                accommodationService.findAccommodations(searchField.getValue())
        ));
        searchButton.addClickShortcut(Key.ENTER);

        HorizontalLayout searchLayout = new HorizontalLayout(searchField, searchButton);

        getContent().add(searchLayout, resultList);
    }

}

package com.switchfully.vaadin.exercise.exercise_10_router_layout.views;

import com.switchfully.vaadin.exercise.exercise_10_router_layout.components.AccomodationResultList;
import com.switchfully.vaadin.exercise.exercise_10_router_layout.layout.LayoutWithMenuBar;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;

@Route(value = "exercises/10/accomodations/search", layout = LayoutWithMenuBar.class)
public class SearchAccomodationView extends Composite<VerticalLayout> {

    public SearchAccomodationView(AccomodationService accomodationService) {
        AccomodationResultList resultList = new AccomodationResultList();

        TextField searchField = new TextField();
        Button searchButton = new Button("Search",
                event -> resultList.setAccomodations(
                accomodationService.findAccomodations(searchField.getValue())
        ));
        searchButton.addClickShortcut(Key.ENTER);

        HorizontalLayout searchLayout = new HorizontalLayout(searchField, searchButton);

        getContent().add(searchLayout, resultList);
    }

}

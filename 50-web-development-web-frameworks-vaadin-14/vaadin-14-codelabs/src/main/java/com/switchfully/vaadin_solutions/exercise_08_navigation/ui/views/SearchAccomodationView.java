package com.switchfully.vaadin_solutions.exercise_08_navigation.ui.views;

import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin_solutions.exercise_08_navigation.ui.components.AccomodationResultList;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class SearchAccomodationView extends Composite<VerticalLayout> {

    public SearchAccomodationView(AccomodationService accomodationService) {
        AccomodationResultList resultList = new AccomodationResultList();
        resultList.addItemClickListener(accomodation -> UI.getCurrent().navigate(AccomodationDetailView.class, accomodation.getId()));

        TextField searchField = new TextField();
        Button searchButton = new Button("Search",
                event -> resultList.setAccomodations(
                accomodationService.findAccomodations(searchField.getValue())
        ));

        HorizontalLayout searchLayout = new HorizontalLayout(searchField, searchButton);

        getContent().add(searchLayout, resultList);
    }

}

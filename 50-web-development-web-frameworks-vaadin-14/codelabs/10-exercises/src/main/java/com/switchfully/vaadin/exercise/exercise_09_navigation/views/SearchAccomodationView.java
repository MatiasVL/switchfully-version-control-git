package com.switchfully.vaadin.exercise.exercise_09_navigation.views;

import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.exercise.exercise_09_navigation.components.AccomodationResultList;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;

@Route("exercises/9")
@PreserveOnRefresh
public class SearchAccomodationView extends Composite<VerticalLayout> {

    public SearchAccomodationView(AccomodationService accomodationService) {
        AccomodationResultList resultList = new AccomodationResultList();
        resultList.addItemClickListener(accomodation -> UI.getCurrent().navigate(AccomodationDetailView.class, accomodation.getId().toString()));

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

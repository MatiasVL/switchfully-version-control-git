package com.switchfully.vaadin.exercise.exercise_08_images;

import com.switchfully.vaadin.exercise.exercise_08_images.components.AccommodationResultList;
import com.switchfully.vaadin.service.AccommodationService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/8")
public class HomePage extends VerticalLayout {

    private AccommodationService accommodationService;

    @Autowired
    public HomePage(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;

        AccommodationResultList resultList = new AccommodationResultList();

        TextField searchField = new TextField();
        Button searchButton = new Button("Search",
                event -> resultList.setAccommodations(
                        accommodationService.findAccommodations(searchField.getValue())
                ));
        searchButton.addClickShortcut(Key.ENTER);

        HorizontalLayout searchLayout = new HorizontalLayout(searchField, searchButton);

        add(searchLayout, resultList);
    }

}
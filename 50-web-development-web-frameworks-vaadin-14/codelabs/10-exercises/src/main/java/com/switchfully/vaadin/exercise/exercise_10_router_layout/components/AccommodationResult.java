package com.switchfully.vaadin.exercise.exercise_10_router_layout.components;

import com.switchfully.vaadin.domain.Accommodation;
import com.switchfully.vaadin.exercise.common.Paths;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AccommodationResult extends Composite<VerticalLayout> {

    private Accommodation accommodation;

    public AccommodationResult(Accommodation accommodation) {
        this.accommodation = accommodation;

        // Show the image in the application
        Image accommodationImage = new Image(Paths.IMAGES_PATH + accommodation.getImagePath(), "Accommodation Image");
        accommodationImage.setWidth("300px");

        AccommodationDetails accommodationDetails = new AccommodationDetails(this.accommodation);
        accommodationDetails.setWidth("100%");

        HorizontalLayout horizontalLayout = new HorizontalLayout(accommodationImage, accommodationDetails);
        horizontalLayout.setFlexGrow(1.0f, accommodationDetails);
        horizontalLayout.setWidth("100%");

        getContent().add(
                horizontalLayout
        );

    }

    public void addClickListener(ComponentEventListener<ClickEvent<VerticalLayout>> listener) {
        getContent().addClickListener(listener);
    }

    Accommodation getAccommodation() {
        return this.accommodation;
    }
}

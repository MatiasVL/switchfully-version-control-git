package com.switchfully.vaadin.exercise.exercise_08_images.components;

import com.switchfully.vaadin.domain.Accommodation;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AccommodationResult extends Composite<VerticalLayout> {

    private Accommodation accommodation;

    public AccommodationResult(Accommodation accommodation) {
        this.accommodation = accommodation;
        VerticalLayout main = new VerticalLayout();

        // TODO exercise-08-images: Show the image defined in (accommodation.getImagePath()) next to the AccommodationDetails
        // The path to the image is: Paths.IMAGES_PATH + accommodation.getImagePath()

        AccommodationDetails accommodationDetails = new AccommodationDetails(this.accommodation);
        accommodationDetails.setWidth("100%");

        getContent().add(accommodationDetails);

        getContent().add(main);
    }
}

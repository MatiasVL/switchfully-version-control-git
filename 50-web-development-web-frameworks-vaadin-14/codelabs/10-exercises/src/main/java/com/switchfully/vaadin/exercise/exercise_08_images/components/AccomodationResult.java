package com.switchfully.vaadin.exercise.exercise_08_images.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AccomodationResult extends Composite<VerticalLayout> {

    private Accomodation accomodation;

    public AccomodationResult(Accomodation accomodation) {
        this.accomodation = accomodation;
        VerticalLayout main = new VerticalLayout();

        // TODO exercise-08-images: Show the image defined in (accomodation.getImagePath()) next to the AccomodationDetails
        // The path to the image is: Paths.IMAGES_PATH + accomodation.getImagePath()

        AccomodationDetails accomodationDetails = new AccomodationDetails(this.accomodation);
        accomodationDetails.setWidth("100%");

        getContent().add(accomodationDetails);

        getContent().add(main);
    }
}

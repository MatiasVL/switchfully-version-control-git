package com.switchfully.vaadin.exercise.exercise_10_router_layout.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.exercise.common.Paths;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AccomodationResult extends Composite<VerticalLayout> {

    private Accomodation accomodation;

    public AccomodationResult(Accomodation accomodation) {
        this.accomodation = accomodation;

        // Show the image in the application
        Image accomodationImage = new Image(Paths.IMAGES_PATH + accomodation.getImagePath(), "Accomodation Image");
        accomodationImage.setWidth("300px");

        AccomodationDetails accomodationDetails = new AccomodationDetails(this.accomodation);
        accomodationDetails.setWidth("100%");

        HorizontalLayout horizontalLayout = new HorizontalLayout(accomodationImage, accomodationDetails);
        horizontalLayout.setFlexGrow(1.0f, accomodationDetails);
        horizontalLayout.setWidth("100%");

        getContent().add(
                horizontalLayout
        );

    }

    public void addClickListener(ComponentEventListener<ClickEvent<VerticalLayout>> listener) {
        getContent().addClickListener(listener);
    }

    Accomodation getAccomodation() {
        return this.accomodation;
    }
}

package com.switchfully.vaadin.exercise_07_images.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class AccomodationResult extends CustomComponent {

    private Accomodation accomodation;

    public AccomodationResult(Accomodation accomodation) {
        this.accomodation = accomodation;
        VerticalLayout main = new VerticalLayout();

        AccomodationDetails accomodationDetails = new AccomodationDetails(this.accomodation);

        // TODO Exercise 7: Add an image of the accomodation.

        main.addComponent(
                accomodationDetails
        );

        Panel panel = new Panel(main);

        setCompositionRoot(panel);
    }
}

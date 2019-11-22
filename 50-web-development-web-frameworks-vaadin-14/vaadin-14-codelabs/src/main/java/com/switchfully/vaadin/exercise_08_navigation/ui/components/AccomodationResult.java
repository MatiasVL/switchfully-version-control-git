package com.switchfully.vaadin.exercise_08_navigation.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AccomodationResult extends Composite<VerticalLayout> {

    private Accomodation accomodation;

//    public AccomodationResult(Accomodation accomodation) {
//        this.accomodation = accomodation;
//        VerticalLayout main = new VerticalLayout();
//
//        // Image as a file resource
//        FileResource resource = new FileResource(new File(
//                Paths.IMAGES_PATH + accomodation.getImagePath()));
//
//        // Show the image in the application
//        Image accomodationImage = new Image();
//        accomodationImage.setSource(resource);
//        accomodationImage.setWidth("300px");
//
//        AccomodationDetails accomodationDetails = new AccomodationDetails(this.accomodation);
//        accomodationDetails.setWidth("100%");
//
//        HorizontalLayout horizontalLayout = new HorizontalLayout(accomodationImage, accomodationDetails);
//        horizontalLayout.setExpandRatio(accomodationDetails, 1.0f);
//        horizontalLayout.setWidth("100%");
//
//        main.addComponent(
//                horizontalLayout
//        );
//
//        getContent().add(main);
//        getContent().setData(this.accomodation);
//
//        setCompositionRoot(panel);
//    }
//
//    public void addClickListener(MouseEvents.ClickListener listener) {
//        panel.addClickListener(listener);
//    }

    Accomodation getAccomodation() {
        return this.accomodation;
    }
}

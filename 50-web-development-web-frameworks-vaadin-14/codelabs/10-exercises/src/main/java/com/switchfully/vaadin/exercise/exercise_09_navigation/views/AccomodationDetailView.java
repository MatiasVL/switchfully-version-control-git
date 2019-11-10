package com.switchfully.vaadin.exercise.exercise_09_navigation.views;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.AccomodationId;
import com.switchfully.vaadin.exercise.common.Paths;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.exercise.exercise_09_navigation.components.AccomodationDetails;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("exercises/9/accomodations")
public class AccomodationDetailView extends Composite<VerticalLayout> implements HasUrlParameter<String> {

    private AccomodationService accomodationService;

    public AccomodationDetailView(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    private void init(AccomodationId accomodationId) {
        getContent().removeAll();
        Accomodation accomodation = accomodationService.getAccomodation(accomodationId);

        // Show the image in the application
        Image accomodationImage = new Image(Paths.IMAGES_PATH + accomodation.getImagePath(), "Accomodation Image");
        accomodationImage.setWidth("600px");

        AccomodationDetails accomodationDetails = new AccomodationDetails(accomodation);

        RouterLink backButton = new RouterLink("Back to search", SearchAccomodationView.class);

        getContent().add(backButton, accomodationImage, accomodationDetails);
    }

    @Override
    public void setParameter(BeforeEvent event, String accomodationId) {
        this.init(AccomodationId.fromString(accomodationId));
    }
}

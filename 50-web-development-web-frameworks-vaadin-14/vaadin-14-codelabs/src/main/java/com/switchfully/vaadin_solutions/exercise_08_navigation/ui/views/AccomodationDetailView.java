package com.switchfully.vaadin_solutions.exercise_08_navigation.ui.views;

import com.switchfully.vaadin.common.Paths;
import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.AccomodationId;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin_solutions.exercise_08_navigation.ui.components.AccomodationDetails;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("detail")
public class AccomodationDetailView extends Composite<VerticalLayout> implements HasUrlParameter<AccomodationId> {

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

        Button backButton = new Button("Back to search",
                e -> getUI().ifPresent(ui -> ui.navigate(SearchAccomodationView.class)));

        getContent().add(backButton, accomodationImage, accomodationDetails);
    }

    @Override
    public void setParameter(BeforeEvent event, AccomodationId accomodationId) {
        System.out.println("View parameters: " + accomodationId);
        this.init(accomodationId);
    }
}

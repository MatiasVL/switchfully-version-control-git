package com.switchfully.vaadin.exercise_08_navigation.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AccomodationDetails extends Composite<HorizontalLayout> {

    private Accomodation accomodation;

    public AccomodationDetails(Accomodation accomodation) {
        this.accomodation = accomodation;

        H3 name = new H3(accomodation.getName());

        StarRatingComponent rating = new StarRatingComponent(accomodation.getStarRating());
//        rating.addStyleName(ValoTheme.LABEL_H3);

        HorizontalLayout nameAndRating = new HorizontalLayout(name, rating);
        nameAndRating.setSpacing(true);

        Span city = new Span("In " + accomodation.getCity().getName());
        city.getElement().getStyle().set("font-weight", "bold");

        Html description = new Html(accomodation.getDescription());

        VerticalLayout mainLeft = new VerticalLayout(nameAndRating, city, description);
//        VerticalLayout mainRight = new VerticalLayout();

        getContent().add(mainLeft /*, mainRight*/);
        getContent().setWidth("100%");
    }

    public void setWidth(String width) {
        getContent().setWidth(width);
    }
}

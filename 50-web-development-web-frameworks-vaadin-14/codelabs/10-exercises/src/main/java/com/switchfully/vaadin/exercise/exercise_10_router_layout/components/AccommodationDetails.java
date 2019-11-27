package com.switchfully.vaadin.exercise.exercise_10_router_layout.components;

import com.switchfully.vaadin.domain.Accommodation;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AccommodationDetails extends Composite<HorizontalLayout> {

    private Accommodation accommodation;

    public AccommodationDetails(Accommodation accommodation) {
        this.accommodation = accommodation;

        H3 name = new H3(accommodation.getName());

        StarRatingComponent rating = new StarRatingComponent(accommodation.getStarRating());
//        rating.addStyleName(ValoTheme.LABEL_H3);

        HorizontalLayout nameAndRating = new HorizontalLayout(name, rating);
        nameAndRating.setSpacing(true);

        Span city = new Span("In " + accommodation.getCity().getName());
        city.getElement().getStyle().set("font-weight", "bold");

        Html description = new Html("<span>" + accommodation.getDescription() + "</span>");

        VerticalLayout mainLeft = new VerticalLayout(nameAndRating, city, description);
//        VerticalLayout mainRight = new VerticalLayout();

        getContent().add(mainLeft /*, mainRight*/);
        getContent().setWidth("100%");
    }

    public void setWidth(String width) {
        getContent().setWidth(width);
    }
}

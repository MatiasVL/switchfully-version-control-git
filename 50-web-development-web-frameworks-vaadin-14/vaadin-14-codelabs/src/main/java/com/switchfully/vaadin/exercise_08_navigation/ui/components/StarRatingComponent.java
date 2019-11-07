package com.switchfully.vaadin.exercise_08_navigation.ui.components;

import com.switchfully.vaadin.domain.StarRating;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class StarRatingComponent extends HorizontalLayout {

    public StarRatingComponent(StarRating starRating) {
        super();
        this.addStarIcons(starRating);
    }

    private void addStarIcons(StarRating starRating) {
        for (int i = 0; i < starRating.getNumberOfStars(); i++) {
            this.add(VaadinIcon.STAR.create());
        }
    }

}

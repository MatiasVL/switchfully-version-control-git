package com.switchfully.vaadin.exercise.exercise_08_images.components;

import com.switchfully.vaadin.domain.Accommodation;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class AccommodationResultList extends Composite<VerticalLayout> {

    private List<Accommodation> accommodations = new ArrayList<>();

    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
        refreshList();
    }

    private void refreshList() {
        getContent().removeAll();
        this.accommodations
                .stream()
                .map(AccommodationResult::new)
                .forEach(component -> this.getContent().add(component));
    }

}

package com.switchfully.vaadin.exercise.exercise_08_images.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class AccomodationResultList extends Composite<VerticalLayout> {

    private List<Accomodation> accomodations = new ArrayList<>();

    public void setAccomodations(List<Accomodation> accomodations) {
        this.accomodations = accomodations;
        refreshList();
    }

    private void refreshList() {
        getContent().removeAll();
        this.accomodations
                .stream()
                .map(AccomodationResult::new)
                .forEach(component -> this.getContent().add(component));
    }

}

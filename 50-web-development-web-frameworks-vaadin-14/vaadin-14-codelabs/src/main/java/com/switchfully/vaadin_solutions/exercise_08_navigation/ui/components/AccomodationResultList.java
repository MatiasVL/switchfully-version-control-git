package com.switchfully.vaadin_solutions.exercise_08_navigation.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AccomodationResultList extends Composite<VerticalLayout> {

    private List<Accomodation> accomodations = new ArrayList<>();
    private List<Consumer<Accomodation>> itemClickListeners = new ArrayList<>();

    public void setAccomodations(List<Accomodation> accomodations) {
        this.accomodations = accomodations;
        refreshList();
    }

    private void refreshList() {
        getContent().removeAll();
        this.accomodations
                .stream()
                .map(AccomodationResult::new)
                .forEach(component -> {
                    component.addClickListener(event ->
                            AccomodationResultList.this.itemClickListeners
                                    .forEach(icl -> icl.accept(component.getAccomodation())));
                    getContent().add(component);
                });
    }

    public void addItemClickListener(Consumer<Accomodation> itemClickListener) {
        this.itemClickListeners.add(itemClickListener);
    }
}

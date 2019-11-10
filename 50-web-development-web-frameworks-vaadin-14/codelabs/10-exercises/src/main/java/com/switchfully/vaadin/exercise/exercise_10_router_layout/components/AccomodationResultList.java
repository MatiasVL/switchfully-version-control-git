package com.switchfully.vaadin.exercise.exercise_10_router_layout.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@CssImport("styles/accomodation-result-list.css")
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
                    Div item = new Div(component);
//                    item.setClassName("search-result-item");
                    getContent().add(item);
                });
    }

    public void addItemClickListener(Consumer<Accomodation> itemClickListener) {
        this.itemClickListeners.add(itemClickListener);
    }
}

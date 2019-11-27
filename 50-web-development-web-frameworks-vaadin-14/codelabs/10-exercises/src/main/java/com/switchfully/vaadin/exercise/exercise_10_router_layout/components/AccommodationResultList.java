package com.switchfully.vaadin.exercise.exercise_10_router_layout.components;

import com.switchfully.vaadin.domain.Accommodation;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@CssImport("styles/accommodation-result-list.css")
public class AccommodationResultList extends Composite<VerticalLayout> {

    private List<Accommodation> accommodations = new ArrayList<>();
    private List<Consumer<Accommodation>> itemClickListeners = new ArrayList<>();

    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
        refreshList();
    }

    private void refreshList() {
        getContent().removeAll();
        this.accommodations
                .stream()
                .map(AccommodationResult::new)
                .forEach(component -> {
                    component.addClickListener(event ->
                            AccommodationResultList.this.itemClickListeners
                                    .forEach(icl -> icl.accept(component.getAccommodation())));
                    Div item = new Div(component);
//                    item.setClassName("search-result-item");
                    getContent().add(item);
                });
    }

    public void addItemClickListener(Consumer<Accommodation> itemClickListener) {
        this.itemClickListeners.add(itemClickListener);
    }
}

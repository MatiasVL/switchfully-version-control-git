package com.switchfully.vaadin.exercise.exercise_12_custom_fields.components;

import com.vaadin.flow.component.html.Div;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridLayout extends Div {

    public GridLayout(int columns) {
        this.getElement().getStyle().set("display", "grid");
        this.getElement().getStyle().set("grid-template-columns", IntStream.of(columns).mapToObj(i -> "auto").collect(Collectors.joining(" ")));
    }

}

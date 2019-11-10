package com.switchfully.vaadin.exercise.exercise_10_router_layout.views;

import com.switchfully.vaadin.exercise.exercise_10_router_layout.layout.LayoutWithMenuBar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "exercises/10", layout = LayoutWithMenuBar.class)
public class HomePageView extends VerticalLayout {

    public HomePageView() {
        add(new Span("Welcome to Vaadin Bookings!"));
    }

}

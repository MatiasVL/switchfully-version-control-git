package com.switchfully.vaadin.exercise.exercise_10_router_layout.views;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "exercises/10")
public class HomePageView extends VerticalLayout {

    public HomePageView() {
        add(new Span("Welcome to Vaadin Bookings!"));
    }

}

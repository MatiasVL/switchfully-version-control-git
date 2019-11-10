package com.switchfully.vaadin.exercise.exercise_10_router_layout.layout;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

import java.util.Objects;

public class MainLayout extends Composite<Div> implements RouterLayout {

    //Component to delegate content through.
    private Div content = new Div();

    private final VerticalLayout layout = new VerticalLayout(
            new Span("from MainLayout top") ,
            content ,
            new Span("from MainLayout bottom")
    );

    public MainLayout() {
        getContent().add(layout);
    }

    @Override
    public void showRouterLayoutContent(HasElement hasElement) {
        Objects.requireNonNull(hasElement);
        Objects.requireNonNull(hasElement.getElement());
        content.removeAll();
        content.getElement().appendChild(hasElement.getElement());
    }

}

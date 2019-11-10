package com.switchfully.vaadin.exercise.exercise_10_router_layout.layout;

import com.switchfully.vaadin.exercise.exercise_10_router_layout.views.HomePageView;
import com.switchfully.vaadin.exercise.exercise_10_router_layout.views.SearchAccomodationView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

import java.util.Objects;

@ParentLayout(value = MainLayout.class)
public class LayoutWithMenuBar extends Composite<Div> implements RouterLayout {

    private final Div content = new Div();

    private final HorizontalLayout menuBar = new HorizontalLayout(
            new RouterLink("Home" , HomePageView.class),
            new RouterLink("Accomodations" , SearchAccomodationView.class)
    );

    private final VerticalLayout root = new VerticalLayout(menuBar, content);

    public LayoutWithMenuBar() {
        getContent().add(root);
    }

    @Override
    public void showRouterLayoutContent(HasElement hasElement) {
        Objects.requireNonNull(hasElement);
        Objects.requireNonNull(hasElement.getElement());
        content.removeAll();
        content.getElement().appendChild(hasElement.getElement());
    }

}

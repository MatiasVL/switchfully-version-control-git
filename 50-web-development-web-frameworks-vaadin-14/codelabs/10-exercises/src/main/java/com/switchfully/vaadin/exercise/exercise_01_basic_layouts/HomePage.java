package com.switchfully.vaadin.exercise.exercise_01_basic_layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("exercises/1")
public class HomePage extends VerticalLayout {

    public HomePage() {
        // TODO 10-basic_layouts: Using VerticalLayout and HorizontalLayout, create a button layout resembling the buttons of an old school cellphone.

        // Use the Button component to create the buttons:
        // Button one = new Button("1");

        // SOLUTION_START
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");

        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");

        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");

        Button star = new Button("*");
        Button zero = new Button("0");
        Button hashtag = new Button("#");

        HorizontalLayout line1 = new HorizontalLayout(one, two, three);
        HorizontalLayout line2 = new HorizontalLayout(four, five, six);
        HorizontalLayout line3 = new HorizontalLayout(seven, eight, nine);
        HorizontalLayout line4 = new HorizontalLayout(star, zero, hashtag);

        add(line1, line2, line3, line4);
        // SOLUTION_END
    }

}
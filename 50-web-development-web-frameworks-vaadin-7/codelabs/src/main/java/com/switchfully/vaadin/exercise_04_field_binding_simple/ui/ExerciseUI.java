package com.switchfully.vaadin.exercise_04_field_binding_simple.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
public class ExerciseUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        // TODO Exercise 4: Create a TextField and a Label, both bound to the same 'name' Property.
        // TODO Exercise 4: Add a button to commit the field.
        // TODO Exercise 4: Clicking the button should update the Label with the value in the TextField.

        // TODO Exercise 4 (Extra): Add a checkbox to hide the button and make the TextField auto-commit.

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        setContent(mainLayout);
    }

}
package com.switchfully.vaadin.exercise_10_keyboard_shortcuts.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class ExerciseUI extends VerticalLayout {

    @Autowired
    public ExerciseUI() {
        add(new ExampleForm1(), new ExampleForm2());
        setMargin(true);
    }

}
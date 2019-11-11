package com.switchfully.vaadin.exercise.exercise_11_keyboard_shortcuts;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/11")
public class HomePage extends VerticalLayout {

    @Autowired
    public HomePage() {
        add(new ExampleForm1(), new ExampleForm2());
        setMargin(true);
    }

}
package com.switchfully.vaadin.exercise.exercise_11_keyboard_shortcuts;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ExampleForm2 extends Composite<VerticalLayout>
{

    private final Button submitButton;
    private final Button clearButton;
    private final TextField textField;
    private final Span result;

    public ExampleForm2() {
        result = new Span();

        textField = new TextField("Name");
        submitButton = new Button("Save", e -> result.setText("Submitted with name " + textField.getValue()));
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        clearButton = new Button("Clear", e -> {
            textField.clear();
            result.setText("");
        });

        HorizontalLayout buttons = new HorizontalLayout(submitButton, clearButton);
        buttons.setSpacing(true);

        getContent().add(textField, buttons, result);

        Shortcuts.addShortcutListener(this, () -> clearButton.click(), Key.KEY_C, KeyModifier.CONTROL).listenOn(this);
        Shortcuts.addShortcutListener(this, () -> submitButton.click(), Key.ENTER).listenOn(this);
    }

}

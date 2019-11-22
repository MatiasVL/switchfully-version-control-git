package com.switchfully.vaadin_solutions.exercise_04_field_binding_simple.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ReadOnlyHasValue;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class ExerciseUI extends VerticalLayout {

    private Button update;
    private TextField nameField;
    private MyFormData formData = new MyFormData();
//    private FieldEvents.TextChangeListener autoCommitTextChangeListener =
//            e -> nameField.getPropertyDataSource().setValue(e.getText());

    @Autowired
    public ExerciseUI() {
        // Create a TextField and a Label, both bound to the same 'name' Property.
        // Add a button to commit the nameField.
        // Clicking the button should update the Label with the value in the TextField.

        // Extra credits: Add a checkbox to hide the button and make the TextField auto-commit.

        nameField = new TextField("Name");
        nameField.setPlaceholder("Fill in name");
        Span nameSpan = new Span("");
        ReadOnlyHasValue<String> nameSpanValue =
                new ReadOnlyHasValue<>(text -> nameSpan.setText(text));

        Binder<MyFormData> formDataBinder = new Binder<>();
        formDataBinder.forField(nameField)
            .bind(MyFormData::getName, MyFormData::setName);
        formDataBinder.forField(nameSpanValue)
            .bind(MyFormData::getName, null);

//        CheckBox toggleAutoCommit = new CheckBox("Auto commit?");
//        toggleAutoCommit.addValueChangeListener(e -> {
//            Object value = e.getProperty().getValue();
//            boolean isCheck = (null == value) ? false : (Boolean) value;
//            if (isCheck) {
//                enableAutoCommit();
//            } else {
//                disableAutoCommit();
//            }
//        });

        update = new Button("Update");
        update.addClickListener(e -> {
            try {
                formDataBinder.writeBean(formData);
            } catch (ValidationException e1) {
                notifyValidationException(e1);
            }
        });

        add(nameField, nameSpan, /*toggleAutoCommit, */ update);
        setMargin(true);
    }

    private void notifyValidationException(ValidationException e) {
        Notification.show("Validation failed with message " + e.getLocalizedMessage());
    }

//    private void enableAutoCommit() {
//        update.setVisible(false);
////        nameField.setTextChangeEventMode(EAGER);
//        nameField.addTextChangeListener(autoCommitTextChangeListener);
//    }
//
//    private void disableAutoCommit() {
//        update.setVisible(true);
////        nameField.setTextChangeEventMode(LAZY);
//        nameField.removeTextChangeListener(autoCommitTextChangeListener);
//    }

    private static class MyFormData {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
package com.switchfully.vaadin.exercise.exercise_04_field_binding_simple;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ReadOnlyHasValue;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Route("exercises/4")
public class HomePage extends VerticalLayout {

    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Button update;
    private TextField nameField;
    private Binder<MyFormData> formDataBinder = new Binder<>();
    private MyFormData formData = new MyFormData();
    private boolean autoCommit = false;
    private boolean autoRefresh = false;
    private Registration autoRefreshListenerRegistration;
    private final Checkbox toggleAutoRefresh;
    //    private FieldEvents.TextChangeListener autoCommitTextChangeListener =
//            e -> nameField.getPropertyDataSource().setValue(e.getText());

    @Autowired
    public HomePage() {
        // Create a TextField and a Label, both bound to the same 'name' Property.
        // Add a button to commit the nameField.
        // Clicking the button should update the Label with the value in the TextField.

        // Extra credits: Add a checkbox to hide the button and make the TextField auto-commit.

        formData.setName("Initial Value");

        nameField = new TextField("Name");
        nameField.setPlaceholder("Fill in name");
        Span nameSpan = new Span("");
        ReadOnlyHasValue<String> nameSpanValue =
                new ReadOnlyHasValue<>(text -> nameSpan.setText(text));

        formDataBinder.forField(nameField)
            .bind(MyFormData::getName, MyFormData::setName)
        ;
        formDataBinder.forField(nameSpanValue)
            .bind(MyFormData::getName, null);

        if (autoCommit) {
            formDataBinder.setBean(formData);
        } else {
            formDataBinder.readBean(formData);
        }

        Checkbox toggleAutoCommit = new Checkbox("Auto commit?");
        toggleAutoCommit.setValue(autoCommit);
        toggleAutoCommit.addValueChangeListener(e -> {
            if (e.getValue()) {
                enableAutoCommit();
            } else {
                disableAutoCommit();
            }
        });

        toggleAutoRefresh = new Checkbox("Auto refresh?");
        toggleAutoRefresh.setValue(autoRefresh);
        toggleAutoRefresh.addValueChangeListener(e -> {
            if (e.getValue()) {
                enableAutoRefresh();
            } else {
                disableAutoRefresh();
            }
        });
        toggleAutoRefresh.setVisible(autoCommit);

        update = new Button("Update");
        update.addClickListener(e -> {
            if (!autoCommit) {
                try {
                    formDataBinder.writeBean(formData);
                } catch (ValidationException e1) {
                    notifyValidationException(e1);
                }
            }
            formDataBinder.readBean(formData);
        });

        add(nameField, nameSpan, toggleAutoCommit, toggleAutoRefresh, update);
        setMargin(true);
    }

    private void notifyValidationException(ValidationException e) {
        Notification.show("Validation failed with message " + e.getLocalizedMessage());
    }

    private void enableAutoCommit() {
        autoCommit = true;
        formDataBinder.setBean(formData);
        toggleAutoRefresh.setVisible(autoCommit);
    }

    private void disableAutoCommit() {
        autoCommit = false;
        formDataBinder.removeBean();
        formDataBinder.readBean(formData);
        toggleAutoRefresh.setVisible(autoCommit);
    }

    private void enableAutoRefresh() {
        autoRefresh = true;
        autoRefreshListenerRegistration = formDataBinder.addValueChangeListener(event -> formDataBinder.readBean(formData));
        nameField.setValueChangeMode(ValueChangeMode.LAZY);
        update.setVisible(false);
    }

    private void disableAutoRefresh() {
        autoRefresh = false;
        nameField.setValueChangeMode(ValueChangeMode.ON_CHANGE);
        autoRefreshListenerRegistration.remove();
        update.setVisible(true);
    }

    private static class MyFormData {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
            LocalDateTime time = LocalDateTime.now();
            Notification.show(String.format("%s: Name changed to '%s' in bean.", timeFormatter.format(time), name));
        }
    }

}
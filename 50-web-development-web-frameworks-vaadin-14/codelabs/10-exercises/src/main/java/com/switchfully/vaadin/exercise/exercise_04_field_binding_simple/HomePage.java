package com.switchfully.vaadin.exercise.exercise_04_field_binding_simple;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Route("exercises/4")
public class HomePage extends VerticalLayout {

    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private MyFormData formData = new MyFormData();

    @Autowired
    public HomePage() {
        formData.setName("Initial Value");

        // TODO 04-field-binding-simple: Create a TextField and a Span, both bound to the same 'name' Property.
        // Add an update button to update the Span with the value in the nameField.
        //  Add an 'Auto commit'-checkbox to switch between 'buffered' and 'unbuffered' binding modes.
        //  Auto commit = checked should mean 'unbuffered' mode.
        //
        //  * **Unbuffered mode:**
        //    Use binder.setBean() and binder.getBean()
        //  * **Buffered mode:**
        //    Use binder.writeBean() and binder.readBean()
        //
        //  Put a breakpoint in MyFormData.setName() to notice the difference in behaviour between these two modes.

        //  **Extra credits:**

        //  Add an 'Auto refresh'-checkbox to hide the update button and make the nameSpan element auto-sync with the TextField.


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
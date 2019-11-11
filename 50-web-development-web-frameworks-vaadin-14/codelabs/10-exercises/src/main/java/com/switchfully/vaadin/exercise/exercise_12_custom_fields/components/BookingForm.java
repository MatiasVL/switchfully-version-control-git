package com.switchfully.vaadin.exercise.exercise_12_custom_fields.components;

import com.switchfully.vaadin.domain.Booking;
import com.switchfully.vaadin.exercise.exercise_07_form_validation.components.DoubleToIntegerConverter;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;

import java.util.function.Consumer;

import static com.switchfully.vaadin.domain.Booking.BookingBuilder.booking;

public class BookingForm extends Composite<VerticalLayout> {

    private Booking booking = booking().build();
    private Consumer<Booking> saveClickListener;
    private Binder<Booking> binder = new Binder<>(Booking.class);

    public BookingForm() {

        TextField firstNameField = createFirstNameField();
        TextField surnameField = createSurnameField();

        NumberField numberOfGuestsField = createNumberOfGuestsField();
        NumberField numberOfRoomsField = createNumberOfRoomsField();
        DateRangeField periodField = createPeriodField();

        FormLayout form = new FormLayout();

        form.add(
                firstNameField,
                surnameField,
                numberOfGuestsField,
                numberOfRoomsField,
                periodField);

        Button save = createSaveButton();

        binder.readBean(booking);

        HorizontalLayout buttons = new HorizontalLayout(save);

        getContent().add(form, buttons);
    }

    private Button createSaveButton() {
        Button save = new Button("Save");
        save.addClickListener(e -> save());
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return save;
    }

    private void save() {
        try {
            binder.writeBean(booking);
            saveClickListener.accept(booking);
        } catch (ValidationException e) {
        }
    }

    private DateRangeField createPeriodField() {
        DateRangeField dateRangeField = new DateRangeField("Period");
        binder.forField(dateRangeField)
                .asRequired()
                .bind(Booking::getPeriod, Booking::setPeriod);
        return dateRangeField;
    }

    private NumberField createNumberOfGuestsField() {
        NumberField numberField = new NumberField("Number of guests");
        binder.forField(numberField)
                .asRequired()
                .withConverter(new DoubleToIntegerConverter())
                .bind(Booking::getNumberOfGuests, Booking::setNumberOfGuests);
        return numberField;
    }

    private NumberField createNumberOfRoomsField() {
        NumberField numberField = new NumberField("Number of rooms");
        binder.forField(numberField)
                .asRequired()
                .withConverter(new DoubleToIntegerConverter())
                .bind(Booking::getNumberOfRooms, Booking::setNumberOfRooms);
        return numberField;
    }

    private TextField createFirstNameField() {
        TextField firstNameField = new TextField("First Name");
        binder.forField(firstNameField)
                .asRequired()
                .bind(Booking::getGuestFirstName, Booking::setGuestFirstName);
        return firstNameField;
    }

    private TextField createSurnameField() {
        TextField textField = new TextField("Surname");
        binder.forField(textField)
                .asRequired()
                .bind(Booking::getGuestSurName, Booking::setGuestSurName);
        return textField;
    }

    public void addSaveClickListener(Consumer<Booking> saveClickListener) {
        this.saveClickListener = saveClickListener;
    }

}

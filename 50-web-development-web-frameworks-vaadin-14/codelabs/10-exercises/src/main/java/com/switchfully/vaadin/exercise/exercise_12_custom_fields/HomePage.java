package com.switchfully.vaadin.exercise.exercise_12_custom_fields;

import com.switchfully.vaadin.exercise.exercise_12_custom_fields.components.BookingDetailsComponent;
import com.switchfully.vaadin.exercise.exercise_12_custom_fields.components.BookingForm;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("exercises/12")
public class HomePage extends VerticalLayout {

    private AccomodationService accomodationService;

    @Autowired
    public HomePage(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
        BookingDetailsComponent bookingDetails = new BookingDetailsComponent();
        bookingDetails.setVisible(false);

        BookingForm bookingForm = new BookingForm();
        bookingForm.addSaveClickListener(b -> {
            bookingForm.setVisible(false);
            bookingDetails.setBooking(b);
            bookingDetails.setVisible(true);
        });

        add(bookingForm, bookingDetails);
    }

}
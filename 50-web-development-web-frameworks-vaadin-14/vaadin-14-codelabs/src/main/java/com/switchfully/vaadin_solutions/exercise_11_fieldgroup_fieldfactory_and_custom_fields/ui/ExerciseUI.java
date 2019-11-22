package com.switchfully.vaadin_solutions.exercise_11_fieldgroup_fieldfactory_and_custom_fields.ui;

import com.switchfully.vaadin.exercise_11_fieldgroup_fieldfactory_and_custom_fields.ui.BookingDetailsComponent;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class ExerciseUI extends VerticalLayout {

    private AccomodationService accomodationService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
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
package com.switchfully.vaadin_solutions.exercise_11_fieldgroup_fieldfactory_and_custom_fields.ui;

import com.switchfully.vaadin.exercise_11_fieldgroup_fieldfactory_and_custom_fields.ui.BookingDetailsComponent;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class ExerciseUI extends UI {

    private AccomodationService accomodationService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @Override
    protected void init(VaadinRequest request) {
        BookingDetailsComponent bookingDetails = new BookingDetailsComponent();
        bookingDetails.setVisible(false);

        BookingForm bookingForm = new BookingForm();
        bookingForm.addSaveClickListener(b -> {
            bookingForm.setVisible(false);
            bookingDetails.setBooking(b);
            bookingDetails.setVisible(true);
        });

        VerticalLayout mainLayout = new VerticalLayout(bookingForm, bookingDetails);
        setContent(mainLayout);
    }

}
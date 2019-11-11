package com.switchfully.vaadin.exercise.exercise_12_custom_fields.components;

import com.switchfully.vaadin.domain.Booking;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BookingDetailsComponent extends Composite<VerticalLayout> {

    private final Span guestFirstNameLabel;
    private final Span guestSurnameLabel;
    private final Span numberOfGuestsLabel;
    private final Span numberOfRoomsLabel;
    private final Span periodLabel;

    public BookingDetailsComponent() {
        guestFirstNameLabel = new Span();
        guestSurnameLabel = new Span();
        numberOfGuestsLabel = new Span();
        numberOfRoomsLabel = new Span();
        periodLabel = new Span();

        GridLayout grid = new GridLayout(2);

        grid.add(new Span("First Name"));
        grid.add(guestFirstNameLabel);
        grid.add(new Span("Surname"));
        grid.add(guestSurnameLabel);
        grid.add(new Span("Number of guests"));
        grid.add(numberOfGuestsLabel);
        grid.add(new Span("Number of rooms"));
        grid.add(numberOfRoomsLabel);
        grid.add(new Span("Period"));
        grid.add(periodLabel);

        getContent().add(
                new Span("Thanks for booking with us! Here are your booking details:"),
                grid);
    }

    public void setBooking(Booking booking) {
        guestFirstNameLabel.setText(booking.getGuestFirstName());
        guestSurnameLabel.setText(booking.getGuestSurName());
        numberOfGuestsLabel.setText(Integer.toString(booking.getNumberOfGuests()));
        numberOfRoomsLabel.setText(Integer.toString(booking.getNumberOfRooms()));
        periodLabel.setText(booking.getPeriod().toString());
    }

}

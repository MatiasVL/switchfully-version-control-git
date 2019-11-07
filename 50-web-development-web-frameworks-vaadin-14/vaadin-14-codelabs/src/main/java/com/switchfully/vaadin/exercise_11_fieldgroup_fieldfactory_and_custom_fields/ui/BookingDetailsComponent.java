package com.switchfully.vaadin.exercise_11_fieldgroup_fieldfactory_and_custom_fields.ui;

import com.switchfully.vaadin.domain.Booking;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
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

        // TODO Steven: Make this a grid...
        Div grid = new Div();
//        grid.setSpacing(true);

        grid.add(new Text("First Name"));
        grid.add(guestFirstNameLabel);
        grid.add(new Text("Surname"));
        grid.add(guestSurnameLabel);
        grid.add(new Text("Number of guests"));
        grid.add(numberOfGuestsLabel);
        grid.add(new Text("Number of rooms"));
        grid.add(numberOfRoomsLabel);
        grid.add(new Text("Period"));
        grid.add(periodLabel);

        getContent().add(
                new Text("Thanks for booking with us! Here are your booking details:"),
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

package com.switchfully.vaadin.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static com.switchfully.vaadin.domain.AccommodationId.accommodationId;
import static java.util.Collections.unmodifiableList;

public class Accommodation {

    private AccommodationId id;
    private String name;
    private String description;
    private int numberOfRooms;
    private StarRating starRating;
    private Instant dateCreated;
    private City city;
    private String imagePath;

    private List<Booking> bookings = new ArrayList<>();

    private Accommodation(AccommodationBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.imagePath = builder.imagePath;
        this.numberOfRooms = builder.numberOfRooms;
        this.starRating = builder.starRating;
        this.dateCreated = builder.dateCreated;
        this.city = builder.city;
    }

    public AccommodationId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public City getCity() {
        return city;
    }

    public List<Booking> getBookings() {
        return unmodifiableList(bookings);
    }

    public void addBooking(Booking booking) {
        // TODO: validate availability.
        this.bookings.add(booking);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isPersisted() {
        return id != null;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public static class AccommodationBuilder {

        private static final String DEFAULT_DESCRIPTION = "Lorem <b>ipsum</b> dolor sit <u>amet</u>, " +
                "consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis " +
                "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor " +
                "in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
                "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        private static final String DEFAULT_IMAGE = "generic_hotel.jpg";

        private AccommodationId id;
        private String name;
        private String description = DEFAULT_DESCRIPTION;
        private String imagePath = DEFAULT_IMAGE;
        private int numberOfRooms;
        private Instant dateCreated = Instant.now();
        private StarRating starRating;
        private City city;

        public static AccommodationBuilder accommodation() {
            return new AccommodationBuilder();
        }

        public static AccommodationBuilder cloneAccommodation(Accommodation accommodation) {
            return new AccommodationBuilder()
                    .withId(accommodation.getId())
                    .withName(accommodation.getName())
                    .withImagePath(accommodation.getImagePath())
                    .withDescription(accommodation.getDescription())
                    .withNumberOfRooms(accommodation.getNumberOfRooms())
                    .withCity(accommodation.getCity())
                    .withDateCreated(accommodation.getDateCreated())
                    .withStarRating(accommodation.getStarRating());
        }

        private AccommodationBuilder() {
        }

        public Accommodation build() {
            return new Accommodation(this);
        }

        public AccommodationBuilder withId() {
            if (id == null) id = accommodationId();
            return this;
        }

        public AccommodationBuilder withId(AccommodationId id) {
            this.id = id;
            return this;
        }

        public AccommodationBuilder withNumberOfRooms(int numberOfRooms) {
            this.numberOfRooms = numberOfRooms;
            return this;
        }

        public AccommodationBuilder withDateCreated(Instant dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public AccommodationBuilder withStarRating(StarRating starRating) {
            this.starRating = starRating;
            return this;
        }

        public AccommodationBuilder withCity(City city) {
            this.city = city;
            return this;
        }

        public AccommodationBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AccommodationBuilder withImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public AccommodationBuilder withDescription(String description) {
            this.description = description;
            return this;
        }
    }

}

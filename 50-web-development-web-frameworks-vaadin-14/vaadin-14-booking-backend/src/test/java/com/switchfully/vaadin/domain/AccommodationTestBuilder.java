package com.switchfully.vaadin.domain;

import java.time.Instant;

import static com.switchfully.vaadin.domain.Accommodation.AccommodationBuilder.accommodation;
import static com.switchfully.vaadin.domain.AccommodationId.accommodationId;
import static com.switchfully.vaadin.domain.City.CityBuilder.city;

public class AccommodationTestBuilder {

    private final Accommodation.AccommodationBuilder builder;

    private AccommodationTestBuilder() {
        builder = accommodation()
            .withId(accommodationId())
            .withName("Dummy hotel name")
            .withCity(city().withName("Brussels").build())
            .withDateCreated(Instant.now())
            .withDescription("Dummy test description")
            .withImagePath("path/to/image.jpg")
            .withNumberOfRooms(120)
            .withStarRating(StarRating.FOUR_STARS)
        ;
    }

    public static AccommodationTestBuilder anAccommodation() {
        return new AccommodationTestBuilder();
    }

    public Accommodation build() {
        return builder.build();
    }

    public AccommodationTestBuilder withNumberOfRooms(int numberOfRooms) {
        builder.withNumberOfRooms(numberOfRooms);
        return this;
    }

    public AccommodationTestBuilder withDateCreated(Instant dateCreated) {
        builder.withDateCreated(dateCreated);
        return this;
    }

    public AccommodationTestBuilder withStarRating(StarRating starRating) {
        builder.withStarRating(starRating);
        return this;
    }

    public AccommodationTestBuilder withCity(City city) {
        builder.withCity(city);
        return this;
    }

    public AccommodationTestBuilder withName(String name) {
        builder.withName(name);
        return this;
    }

    public AccommodationTestBuilder withImagePath(String imagePath) {
        builder.withImagePath(imagePath);
        return this;
    }

    public AccommodationTestBuilder withDescription(String description) {
        builder.withDescription(description);
        return this;
    }
}
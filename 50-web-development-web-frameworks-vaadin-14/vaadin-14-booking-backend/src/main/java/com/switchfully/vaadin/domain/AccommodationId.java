package com.switchfully.vaadin.domain;

public final class AccommodationId extends Id {

    private AccommodationId() {
        super();
    }

    private AccommodationId(String id) {
        super(id);
    }

    public static AccommodationId accommodationId() {
        return new AccommodationId();
    }

    public static AccommodationId fromString(String id) {
        return new AccommodationId(id);
    }

}

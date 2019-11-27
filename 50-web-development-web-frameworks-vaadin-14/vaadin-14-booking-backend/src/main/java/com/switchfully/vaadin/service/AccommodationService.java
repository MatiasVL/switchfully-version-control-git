package com.switchfully.vaadin.service;

import com.switchfully.vaadin.domain.Accommodation;
import com.switchfully.vaadin.domain.AccommodationId;
import com.switchfully.vaadin.domain.Booking;
import com.switchfully.vaadin.domain.StarRating;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.switchfully.vaadin.domain.Accommodation.AccommodationBuilder.accommodation;
import static com.switchfully.vaadin.domain.Accommodation.AccommodationBuilder.cloneAccommodation;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Service
public class AccommodationService {

    private List<Accommodation> accommodations = new ArrayList<>();

    public AccommodationService() {
        initData();
    }

    public List<Accommodation> getAccommodations() {
        return accommodations.stream()
                .sorted((acc1, acc2) -> acc1.getName().compareToIgnoreCase(acc2.getName()))
                .collect(toList());
    }

    public Accommodation getAccommodation(AccommodationId id) {
        return accommodations.stream()
                .filter(accommodation -> accommodation.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        format("Accommodation with id %s not found.", id.toString()))
                );
    }

    public void delete(AccommodationId id) {
        this.accommodations = this.accommodations.stream()
                .filter(accommodation -> !accommodation.getId().equals(id))
                .collect(toList());
    }

    public void save(AccommodationId accommodationId, Booking booking) {
        getAccommodation(accommodationId).addBooking(booking);
    }

    public void save(Accommodation accommodation) {
        if (!accommodation.isPersisted()) {
            this.accommodations.add(
                    cloneAccommodation(accommodation)
                    .withId()
                    .build());
        } else {
            Accommodation accommodationToUpdate = getAccommodation(accommodation.getId());

            accommodationToUpdate.setName(accommodation.getName());
            accommodationToUpdate.setCity(accommodation.getCity());
            accommodationToUpdate.setNumberOfRooms(accommodation.getNumberOfRooms());
            accommodationToUpdate.setStarRating(accommodation.getStarRating());
        }
    }

    private void initData() {
        // Amsterdam
        accommodations.add(accommodation()
                .withId()
                .withName("Hotel Tulip")
                .withCity(CityService.AMSTERDAM)
                .withStarRating(StarRating.THREE_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Onder dat brugje")
                .withCity(CityService.AMSTERDAM)
                .withStarRating(StarRating.NO_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Hotel Estherea")
                .withCity(CityService.AMSTERDAM)
                .withStarRating(StarRating.FIVE_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Breitner House")
                .withCity(CityService.AMSTERDAM)
                .withStarRating(StarRating.FOUR_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());

        // Berlin
        accommodations.add(accommodation()
                .withId()
                .withName("Hotel Otto")
                .withCity(CityService.BERLIN)
                .withStarRating(StarRating.FOUR_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Unter der Brücke")
                .withCity(CityService.BERLIN)
                .withStarRating(StarRating.NO_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Hotel Edelweiss")
                .withCity(CityService.BERLIN)
                .withStarRating(StarRating.TWO_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());

        // Brussels
        accommodations.add(accommodation()
                .withId()
                .withName("Hotel Amigo")
                .withCity(CityService.BRUSSELS)
                .withStarRating(StarRating.FIVE_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("B&B Onder de Brug")
                .withCity(CityService.BRUSSELS)
                .withStarRating(StarRating.NO_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Regency Hotel")
                .withCity(CityService.BRUSSELS)
                .withStarRating(StarRating.FOUR_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());

        // London
        accommodations.add(accommodation()
                .withId()
                .withName("The Royal Horseguards")
                .withCity(CityService.LONDON)
                .withStarRating(StarRating.FIVE_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Hilton London Westminster")
                .withCity(CityService.LONDON)
                .withStarRating(StarRating.FOUR_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Under The Bridge")
                .withCity(CityService.LONDON)
                .withStarRating(StarRating.NO_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Shangri-La Hotel, At The Shard")
                .withCity(CityService.LONDON)
                .withStarRating(StarRating.FOUR_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());

        // New-York
        accommodations.add(accommodation()
                .withId()
                .withName("Hotel Trump")
                .withCity(CityService.NEW_YORK)
                .withStarRating(StarRating.FOUR_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Chelsea International Hostel")
                .withCity(CityService.NEW_YORK)
                .withStarRating(StarRating.ONE_STAR)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("The Plaza")
                .withCity(CityService.NEW_YORK)
                .withStarRating(StarRating.FIVE_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());

        // Paris
        accommodations.add(accommodation()
                .withId()
                .withName("Hilton Paris Centre")
                .withCity(CityService.PARIS)
                .withStarRating(StarRating.FOUR_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Hyatt Paris Nord")
                .withCity(CityService.PARIS)
                .withStarRating(StarRating.FOUR_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Novotel Paris Centre")
                .withCity(CityService.PARIS)
                .withStarRating(StarRating.THREE_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
        accommodations.add(accommodation()
                .withId()
                .withName("Sous le Pont")
                .withCity(CityService.PARIS)
                .withStarRating(StarRating.NO_STARS)
                .withNumberOfRooms(getRandomNumberInRange(10, 500))
                .build());
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public List<Accommodation> findAccommodations(String searchText) {
        return accommodations.stream()
                .filter(accommodation -> accommodation.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(toList());
    }
}
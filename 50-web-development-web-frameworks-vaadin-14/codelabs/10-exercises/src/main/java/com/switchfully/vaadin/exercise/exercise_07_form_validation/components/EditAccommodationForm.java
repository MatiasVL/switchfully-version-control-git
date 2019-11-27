package com.switchfully.vaadin.exercise.exercise_07_form_validation.components;

import com.switchfully.vaadin.domain.Accommodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.switchfully.vaadin.service.AccommodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;

public class EditAccommodationForm extends FormLayout {

    private final AccommodationAdmin admin;
    private AccommodationService accommodationService;
    private final CityService cityService;

    private final TextField name;
    private final Select city;
    private final NumberField numberOfRooms;
    private final Select starRating;
    private final Span statusLabel;
    private final Button delete;
    private final Button save;
    private final Button cancel;

    private Binder<Accommodation> binder = new Binder<>(Accommodation.class);
    private Accommodation accommodation;

    public EditAccommodationForm(AccommodationAdmin admin, AccommodationService accommodationService, CityService cityService) {
        this.admin = admin;
        this.accommodationService = accommodationService;
        this.cityService = cityService;

        this.name = createNameField();
        this.city = createCityField();
        this.numberOfRooms = createNumberOfRoomsField();
        this.starRating = createStarRatingField();
        this.statusLabel = createStatusLabel();
        this.delete = createDeleteButton();
        this.save = createSaveButton();
        this.cancel = createCancelButton();

        HorizontalLayout buttons = new HorizontalLayout(save, delete, cancel);
        buttons.setSpacing(true);
        add(name, city, numberOfRooms, starRating, statusLabel, buttons);
    }

    // TODO 07-form-validation: Add the following validation to the form:
    //  * Name is required.
    //  * City is required
    //  * Number of rooms should be > 0 and < 10000
    //
    //  ## Extra credits
    //  Add the following validation to the form:
    //  * Four and five star hotels should have at least 20 rooms.

    private Span createStatusLabel() {
        Span statusLabel = new Span();
        binder.setStatusLabel(statusLabel);
        return statusLabel;
    }

    private void cancel() {
        setVisible(false);
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
        this.binder.readBean(accommodation);

        // Show delete button for only customers already in the database
        delete.setVisible(accommodation.isPersisted());
        setVisible(true);
        name.setAutoselect(true);
    }

    private NumberField createNumberOfRoomsField() {
        NumberField numberOfRooms = new NumberField("Number of rooms");

        binder.forField(numberOfRooms)
                .withConverter(new DoubleToIntegerConverter())
                .bind(Accommodation::getNumberOfRooms, Accommodation::setNumberOfRooms);

        return numberOfRooms;
    }

    private Select createCityField() {
        Select<City> city = new Select(cityService.getCities().toArray(i -> new City[i]));
        city.setLabel("City");
        city.setTextRenderer(City::getName);

        binder.forField(city)
                .bind(Accommodation::getCity, Accommodation::setCity);

        return city;
    }

    private Button createDeleteButton() {
        Button delete = new Button("Delete");
        delete.addClickListener(e -> delete());
        return delete;
    }
    private Button createSaveButton() {
        Button save = new Button("Save");
        save.addClickListener(e -> save());
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return save;
    }

    private Button createCancelButton() {
        Button cancel = new Button("Cancel");
        cancel.addClickListener(e -> cancel());
        return cancel;
    }

    private Select createStarRatingField() {
        Select<StarRating> ratingField = new Select(StarRating.values());
        ratingField.setLabel("Star Rating");
        ratingField.setTextRenderer(rating -> rating.getNumberOfStars() + " stars");

        binder.forField(ratingField)
                .bind(Accommodation::getStarRating, Accommodation::setStarRating);

        return ratingField;
    }

    private TextField createNameField() {
        TextField name = new TextField("Name");

        name.setWidth("30em");

        binder.forField(name)
                .bind(Accommodation::getName, Accommodation::setName);

        return name;
    }

    private void delete() {
        accommodationService.delete(accommodation.getId());
        admin.updateList();
        setVisible(false);
        Notification.show(String.format("Accommodation %s has been deleted.", accommodation.getName()));
    }

    private void save() {
        try {
            binder.writeBean(accommodation);
            accommodationService.save(accommodation);
            Notification.show(String.format("Accommodation %s has been %s.", accommodation.getName(), accommodation.isPersisted() ? "updated" : "created"));
            admin.updateList();
            setVisible(false);
        } catch (ValidationException e) {
        }
    }
}

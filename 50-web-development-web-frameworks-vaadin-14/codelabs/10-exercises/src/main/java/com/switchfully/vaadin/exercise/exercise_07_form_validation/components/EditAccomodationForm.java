package com.switchfully.vaadin.exercise.exercise_07_form_validation.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Shortcuts;
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
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.validator.IntegerRangeValidator;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.cloneAccomodation;

public class EditAccomodationForm extends FormLayout {

    private final AccomodationAdmin admin;
    private AccomodationService accomodationService;
    private final CityService cityService;

    private final TextField name;
    private final Select city;
    private final NumberField numberOfRooms;
    private final Select starRating;
    private final Span statusLabel;
    private final Button delete;
    private final Button save;
    private final Button cancel;

    private Binder<Accomodation> binder = new Binder<>(Accomodation.class);
    private Accomodation accomodation;

    public EditAccomodationForm(AccomodationAdmin admin, AccomodationService accomodationService, CityService cityService) {
        this.admin = admin;
        this.accomodationService = accomodationService;
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

    private Span createStatusLabel() {
        Span statusLabel = new Span();
        binder.setStatusLabel(statusLabel);
        return statusLabel;
    }

    private void cancel() {
        setVisible(false);
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = accomodation;
        this.binder.readBean(accomodation);

        // Show delete button for only customers already in the database
        delete.setVisible(accomodation.isPersisted());
        setVisible(true);
        name.setAutoselect(true);
    }

    private NumberField createNumberOfRoomsField() {
        NumberField numberOfRooms = new NumberField("Number of rooms");

        binder.forField(numberOfRooms)
                .withConverter(new DoubleToIntegerConverter())
                .withValidator(rooms -> isNumberOfRoomsValid(rooms, (StarRating) starRating.getValue()),
                        "Four and five star hotels must have at least 20 rooms.")
                .withValidator(new IntegerRangeValidator("Number of rooms must be greater than 1 and less than 10000", 1, 10000 - 1))
                .bind(Accomodation::getNumberOfRooms, Accomodation::setNumberOfRooms);

        return numberOfRooms;
    }

    private boolean isNumberOfRoomsValid(Integer numberOfRooms, StarRating starRating) {
        return starRating == null
                || (starRating.getNumberOfStars() < 4)
                || (starRating.getNumberOfStars() > 3 && numberOfRooms >= 20);
    }

    private Select createCityField() {
        Select<City> city = new Select(cityService.getCities().toArray(i -> new City[i]));
        city.setLabel("City");
        city.setTextRenderer(City::getName);

        binder.forField(city)
                .asRequired("City is required")
                .bind(Accomodation::getCity, Accomodation::setCity);

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
                .bind(Accomodation::getStarRating, Accomodation::setStarRating);

        return ratingField;
    }

    private TextField createNameField() {
        TextField name = new TextField("Name");

        name.setWidth("30em");

        binder.forField(name)
                .asRequired("Name is required")
                .bind(Accomodation::getName, Accomodation::setName);

        return name;
    }

    private void delete() {
        accomodationService.delete(accomodation.getId());
        admin.updateList();
        setVisible(false);
        Notification.show(String.format("Accomodation %s has been deleted.", accomodation.getName()));
    }

    private void save() {
        try {
            binder.writeBean(accomodation);
            accomodationService.save(accomodation);
            Notification.show(String.format("Accomodation %s has been %s.", accomodation.getName(), accomodation.isPersisted() ? "updated" : "created"));
            admin.updateList();
            setVisible(false);
        } catch (ValidationException e) {
        }
    }
}

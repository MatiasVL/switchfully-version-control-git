package com.switchfully.vaadin.exercise.exercise_13_model_view_presenter.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.switchfully.vaadin.exercise.exercise_07_form_validation.components.DoubleToIntegerConverter;
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
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.validator.IntegerRangeValidator;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.cloneAccomodation;

public class EditAccomodationForm extends FormLayout {

    private final TextField name;
    private final Select city;
    private final NumberField numberOfRooms;
    private final Select starRating;
    private final Span statusLabel;
    private final Button delete;
    private final Button save;
    private final Button cancel;
    private Accomodation accomodation;

    private Binder<Accomodation> binder = new Binder<>(Accomodation.class);
    private List<EditAccomodationFormListener> listeners = new ArrayList<>();

    public EditAccomodationForm() {
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
        add(name, city, numberOfRooms, starRating, buttons);
    }

    private Span createStatusLabel() {
        Span statusLabel = new Span();
        binder.setStatusLabel(statusLabel);
        return statusLabel;
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

        Shortcuts.addShortcutListener(this, () -> save.click(), Key.ENTER);
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

    private Select createCityField() {
        Select<City> city = new Select();
        city.setLabel("City");

        city.setTextRenderer(City::getName);
        city.setRequiredIndicatorVisible(true);

        binder.forField(city)
                .asRequired("City is required")
                .bind(Accomodation::getCity, Accomodation::setCity);

        return city;
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

    public void setCities(List<City> cities) {
        city.setItems(cities);
    }

    public void addListener(EditAccomodationFormListener listener) {
        this.listeners.add(listener);
    }

    public void setAccomodation(Accomodation accomodation) {
        this.binder.readBean(cloneAccomodation(accomodation).build());
        this.accomodation = cloneAccomodation(accomodation).build();

        // Show delete button for only customers already in the database
        delete.setVisible(accomodation.isPersisted());
        setVisible(true);
    }

    private void cancel() {
        listeners.forEach(l -> l.cancelClicked());
    }
    private void delete() {
        listeners.forEach(l -> l.deleteAccomodationClicked(accomodation));
        Notification.show(String.format("Accomodation %s has been deleted.", accomodation.getName()));
    }

    private void save() {
        try {
            binder.writeBean(accomodation);
            listeners.forEach(l -> l.saveAccomodationClicked(accomodation));
            Notification.show(String.format("Accomodation %s has been %s.", accomodation.getName(), accomodation.isPersisted() ? "updated" : "created"));
        } catch (ValidationException e) {
        }
    }

    private TextField createNameField() {
        TextField name = new TextField("Name");

        name.setAutoselect(true);
        name.setWidth("30em");

        binder.forField(name)
                .asRequired()
                .bind(Accomodation::getName, Accomodation::setName);

        return name;
    }

    public interface EditAccomodationFormListener {

        void saveAccomodationClicked(Accomodation accomodation);
        void deleteAccomodationClicked(Accomodation accomodation);
        void cancelClicked();

    }
}

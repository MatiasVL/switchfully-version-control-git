package com.switchfully.vaadin_solutions.exercise_12_model_view_presenter.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.validator.IntegerRangeValidator;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.cloneAccomodation;

public class EditAccomodationForm extends FormLayout {

    private final TextField name;
    private final Select city;
    private final TextField numberOfRooms;
    private final Select starRating;
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
        this.delete = createDeleteButton();
        this.save = createSaveButton();
        this.cancel = createCancelButton();

        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(save, delete, cancel);
        buttons.setSpacing(true);
        add(name, city, numberOfRooms, starRating, buttons);
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
        save.addClickShortcut(Key.ENTER);
        return save;
    }

    private Button createCancelButton() {
        Button cancel = new Button("Cancel");
        cancel.addClickListener(e -> cancel());
        return cancel;
    }

    private Select createStarRatingField() {
        Select<StarRating> rating = new Select();
        rating.setLabel("Rating");

        rating.setItems(StarRating.values());

        binder.forField(rating)
                .bind(Accomodation::getStarRating, Accomodation::setStarRating);

        return rating;
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

    private TextField createNumberOfRoomsField() {
        TextField numberOfRooms = new TextField("Number of rooms");

        binder.forField(numberOfRooms)
                .withConverter(new StringToIntegerConverter("Must enter a number"))
                .withValidator(new IntegerRangeValidator(
                        "The number of rooms must be between 1 and 10000",
                        1, 9999))
                .bind(Accomodation::getNumberOfRooms, Accomodation::setNumberOfRooms);

        return numberOfRooms;
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
    }

    private void save() {
        listeners.forEach(l -> l.saveAccomodationClicked(accomodation));
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

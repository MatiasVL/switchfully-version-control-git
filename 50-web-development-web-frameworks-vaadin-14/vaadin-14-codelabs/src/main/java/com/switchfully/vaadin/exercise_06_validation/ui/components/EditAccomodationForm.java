package com.switchfully.vaadin.exercise_06_validation.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
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

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.cloneAccomodation;

// TODO Exercise 6: Name is required.
// TODO Exercise 6: City is required
// TODO Exercise 6: Number of rooms should be > 0 and < 10000
// TODO Exercise 6 (extra): Four and five star hotels should have at least 20 rooms.

public class EditAccomodationForm extends FormLayout {

    private final AccomodationAdmin admin;

    private final AccomodationService accomodationService;
    private final CityService cityService;

    private final TextField name;
    private final Select city;
    private final TextField numberOfRooms;
    private final Select starRating;
    private final Button delete;
    private final Button save;
    private final Button cancel;

    private Binder<Accomodation> binder = new Binder<>(Accomodation.class);

    public EditAccomodationForm(AccomodationAdmin admin, AccomodationService accomodationService, CityService cityService) {
        this.admin = admin;
        this.accomodationService = accomodationService;
        this.cityService = cityService;

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

    private TextField createNumberOfRoomsField() {
        TextField numberOfRooms = new TextField("Number of rooms");

        binder.forField(numberOfRooms)
                .withConverter(new StringToIntegerConverter("Must enter a number"))
                .bind(Accomodation::getNumberOfRooms, Accomodation::setNumberOfRooms);

        return numberOfRooms;
    }

    private Select createCityField() {
        Select<City> city = new Select("City");

        city.setItems(cityService.getCities());
        city.setTextRenderer(City::getName);

        binder.forField(city)
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
        save.addClickShortcut(Key.ENTER);
        return save;
    }

    private Button createCancelButton() {
        Button cancel = new Button("Cancel");
        cancel.addClickListener(e -> cancel());
        return cancel;
    }

    private Select createStarRatingField() {
        Select<StarRating> rating = new Select("Rating");

        rating.setItems(StarRating.values());

        binder.forField(rating)
                .bind(Accomodation::getStarRating, Accomodation::setStarRating);

        return rating;
    }

    private TextField createNameField() {
        TextField name = new TextField("Name");

        name.setWidth("30em");

        binder.forField(name)
                .bind(Accomodation::getName, Accomodation::setName);

        return name;
    }

    private void cancel() {
        setVisible(false);
    }

    public void setAccomodation(Accomodation accomodation) {
        this.binder.readBean(cloneAccomodation(accomodation).build());

        // Show delete button for only customers already in the database
        delete.setVisible(accomodation.isPersisted());
        setVisible(true);
        name.setAutoselect(true);
    }

    private void delete() {
        accomodationService.delete(binder.getBean().getId());
        admin.updateList();
        setVisible(false);
    }

    private void save() {
        accomodationService.save(binder.getBean());
        admin.updateList();
        setVisible(false);
    }

}

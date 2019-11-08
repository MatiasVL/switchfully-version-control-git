package com.switchfully.vaadin.exercise.exercise_05_binding_data_to_forms.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.cloneAccomodation;

public class EditAccomodationForm extends FormLayout {

    private final AccomodationAdmin admin;
    private AccomodationService accomodationService;
    private final CityService cityService;

    private final TextField name;
    private final Select city;
    private final NumberField numberOfRooms;
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

        HorizontalLayout buttons = new HorizontalLayout(save, delete, cancel);
        buttons.setSpacing(true);
        add(name, city, numberOfRooms, starRating, buttons);
    }

    private void cancel() {
        setVisible(false);
    }

    public void setAccomodation(Accomodation accomodation) {
        this.binder.setBean(cloneAccomodation(accomodation).build());

        // Show delete button for only customers already in the database
        delete.setVisible(accomodation.isPersisted());
        setVisible(true);
        name.setAutoselect(true);
    }

    private NumberField createNumberOfRoomsField() {
        NumberField numberOfRooms = new NumberField("Number of rooms");

        binder.forField(numberOfRooms)
                .withConverter(new DoubleToIntegerConverter())
                .bind(Accomodation::getNumberOfRooms, Accomodation::setNumberOfRooms);

        return numberOfRooms;
    }
    private Select createCityField() {
        Select<City> city = new Select(cityService.getCities().toArray(i -> new City[i]));
        city.setLabel("City");
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
                .bind(Accomodation::getName, Accomodation::setName);

        return name;
    }

    private void delete() {
        accomodationService.delete(binder.getBean().getId());
        admin.updateList();
        setVisible(false);
        Notification.show(String.format("Accomodation %s has been deleted.", binder.getBean().getName()));
    }

    private void save() {
        accomodationService.save(binder.getBean());
        Notification.show(String.format("Accomodation %s has been %s.", binder.getBean().getName(), binder.getBean().isPersisted() ? "updated" : "created"));
        admin.updateList();
        setVisible(false);
    }
}

package com.switchfully.vaadin_solutions.exercise_06_validation.ui.components;

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
                .withValidator(new IntegerRangeValidator(
                        "The number of rooms must be between 1 and 10000",
                        1, 9999))
                .bind(Accomodation::getNumberOfRooms, Accomodation::setNumberOfRooms);

        return numberOfRooms;
    }

    private Select createCityField() {
        Select<City> city = new Select();
        city.setLabel("City");

        city.setItems(cityService.getCities());
        city.setTextRenderer(City::getName);
        city.setRequiredIndicatorVisible(true);

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

    private TextField createNameField() {
        TextField name = new TextField("Name");

        name.setWidth("30em");
        name.setAutoselect(true);

        binder.forField(name)
                .asRequired()
                .bind(Accomodation::getName, Accomodation::setName);

        return name;
    }

    private void cancel() {
        setVisible(false);
    }

    public void setAccomodation(Accomodation accomodation) {
        this.binder.readBean(cloneAccomodation(accomodation).build());

//        beanFieldGroup.addCommitHandler(new FieldGroup.CommitHandler() {
//            @Override
//            public void preCommit(FieldGroup.CommitEvent commitEvent) throws FieldGroup.CommitException {
//                if (starRating.getValue() != null
//                        && (starRating.getValue().equals(StarRating.FOUR_STARS) || starRating.getValue().equals(StarRating.FIVE_STARS))) {
//                    if ((Integer) numberOfRooms.getConvertedValue() < 20) {
//                        numberOfRooms.setComponentError(new UserError("Four and five star hotels should have at least 20 rooms."));
//                        throw new FieldGroup.CommitException("Four and five star hotels should have at least 20 rooms.");
//                    }
//                }
//                numberOfRooms.setComponentError(null);
//            }
//
//            @Override
//            public void postCommit(FieldGroup.CommitEvent commitEvent) throws FieldGroup.CommitException {
//            }
//        });

        // Show delete button for only customers already in the database
        delete.setVisible(accomodation.isPersisted());
        setVisible(true);
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
//
//    private void showNotificationFor(FieldGroup.CommitException exception) {
//        Notification notification = new Notification("Validation errors",
//                "<br/>Cannot save this accomodation. "
//                        + ((exception.getCause() != null && exception.getCause().getMessage() != null)
//                        ? exception.getCause().getMessage() : ""),
//                Notification.Type.WARNING_MESSAGE, true);
//
//        notification.setDelayMsec(-1);
//
//        notification
//                .show(Page.getCurrent());
//    }
}

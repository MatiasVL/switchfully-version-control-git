package com.switchfully.vaadin_solutions.exercise_06_validation.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.Page;
import com.vaadin.server.UserError;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.cloneAccomodation;

public class EditAccomodationForm extends FormLayout {

    private final AccomodationAdmin admin;

    private final AccomodationService accomodationService;
    private final CityService cityService;

    private final TextField name;
    private final NativeSelect city;
    private final TextField numberOfRooms;
    private final NativeSelect starRating;
    private final Button delete;
    private final Button save;
    private final Button cancel;

    private Accomodation accomodation;
    private BeanFieldGroup<Accomodation> beanFieldGroup;

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
        addComponents(name, city, numberOfRooms, starRating, buttons);
    }

    private TextField createNumberOfRoomsField() {
        TextField numberOfRooms = new TextField("Number of rooms");

        numberOfRooms.addValidator(new IntegerRangeValidator(
                "The number of rooms must be between 1 and 10000",
                1, 9999));

        return numberOfRooms;
    }
    private NativeSelect createCityField() {
        NativeSelect city = new NativeSelect("City");

        city.setContainerDataSource(new BeanItemContainer<>(City.class, cityService.getCities()));
        city.setItemCaptionPropertyId("name");

        city.setRequired(true);

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
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(KeyCode.ENTER);
        return save;
    }

    private Button createCancelButton() {
        Button cancel = new Button("Cancel");
        cancel.addClickListener(e -> cancel());
        return cancel;
    }

    private NativeSelect createStarRatingField() {
        NativeSelect rating = new NativeSelect("Rating");

        rating.addItems((Object[]) StarRating.values());

        return rating;
    }

    private TextField createNameField() {
        TextField name = new TextField("Name");

        name.setWidth("30em");
        name.setNullRepresentation("");

        name.setRequired(true);

        return name;
    }

    private void cancel() {
        setVisible(false);
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = cloneAccomodation(accomodation).build();
        beanFieldGroup = BeanFieldGroup.bindFieldsBuffered(this.accomodation, this);

        beanFieldGroup.addCommitHandler(new FieldGroup.CommitHandler() {
            @Override
            public void preCommit(FieldGroup.CommitEvent commitEvent) throws FieldGroup.CommitException {
                if (starRating.getValue() != null
                        && (starRating.getValue().equals(StarRating.FOUR_STARS) || starRating.getValue().equals(StarRating.FIVE_STARS))) {
                    if ((Integer) numberOfRooms.getConvertedValue() < 20) {
                        numberOfRooms.setComponentError(new UserError("Four and five star hotels should have at least 20 rooms."));
                        throw new FieldGroup.CommitException("Four and five star hotels should have at least 20 rooms.");
                    }
                }
                numberOfRooms.setComponentError(null);
            }

            @Override
            public void postCommit(FieldGroup.CommitEvent commitEvent) throws FieldGroup.CommitException {
            }
        });

        // Show delete button for only customers already in the database
        delete.setVisible(accomodation.isPersisted());
        setVisible(true);
        name.selectAll();
    }
    private void delete() {
        accomodationService.delete(accomodation.getId());
        admin.updateList();
        setVisible(false);
    }

    private void save() {
        try {
            beanFieldGroup.commit();
            accomodationService.save(accomodation);
            admin.updateList();
            setVisible(false);
        } catch (FieldGroup.CommitException e) {
            showNotificationFor(e);
        }
    }

    private void showNotificationFor(FieldGroup.CommitException exception) {
        Notification notification = new Notification("Validation errors",
                "<br/>Cannot save this accomodation. "
                        + ((exception.getCause() != null && exception.getCause().getMessage() != null)
                        ? exception.getCause().getMessage() : ""),
                Notification.Type.WARNING_MESSAGE, true);

        notification.setDelayMsec(-1);

        notification
                .show(Page.getCurrent());
    }
}

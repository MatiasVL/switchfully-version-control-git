package com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;

public class EditAccomodationForm extends FormLayout {

    private final AccomodationAdmin admin;
    private AccomodationService accomodationService;
    private final CityService cityService;

    private TextField name = new TextField("Name");
    private Select city = new Select("City");
    private TextField numberOfRooms = new TextField("Number of rooms");
    private Select starRating = new Select("Rating");
    private Button delete = new Button("Delete");
    private Button save = new Button("Save");
    private Button cancel = new Button("Cancel");
    private Accomodation accomodation;

    public EditAccomodationForm(AccomodationAdmin admin, AccomodationService accomodationService, CityService cityService) {
        this.admin = admin;
        this.accomodationService = accomodationService;
        this.cityService = cityService;

//        name.setWidth("30em");
//        name.setNullRepresentation("");
//        starRating.addItems((Object[]) StarRating.values());
//        city.setContainerDataSource(new BeanItemContainer<>(City.class, cityService.getCities()));
//        city.setItemCaptionPropertyId("name");
//
//        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
//        save.setClickShortcut(KeyCode.ENTER);
//
//        save.addClickListener(e -> save());
//        delete.addClickListener(e -> delete());
//        cancel.addClickListener(e -> cancel());
//
//        setSizeUndefined();
//        HorizontalLayout buttons = new HorizontalLayout(save, delete, cancel);
//        buttons.setSpacing(true);
//        addComponents(name, city, numberOfRooms, starRating, buttons);
    }

    private void cancel() {
        setVisible(false);
    }

//    public void setAccomodation(Accomodation accomodation) {
//        this.accomodation = cloneAccomodation(accomodation).build();
//        BeanFieldGroup.bindFieldsUnbuffered(this.accomodation, this);
//
//        // Show delete button for only customers already in the database
//        delete.setVisible(accomodation.isPersisted());
//        setVisible(true);
//        name.selectAll();
//    }
//    private void delete() {
//        accomodationService.delete(accomodation.getId());
//        admin.updateList();
//        setVisible(false);
//    }
//
//    private void save() {
//        accomodationService.save(accomodation);
//        admin.updateList();
//        setVisible(false);
//    }
}
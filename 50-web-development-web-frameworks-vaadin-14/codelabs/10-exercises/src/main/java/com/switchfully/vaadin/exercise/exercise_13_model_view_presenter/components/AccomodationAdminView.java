package com.switchfully.vaadin.exercise.exercise_13_model_view_presenter.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;

import java.util.List;

public interface AccomodationAdminView {

    void setSearchResults(List<Accomodation> accomodations);
    void setActiveAccomodation(Accomodation accomodation);
    void setSearchFilter(String searchFilter);
    void setCities(List<City> cities);

    void addListener(AccomodationAdminViewListener listener);

    interface AccomodationAdminViewListener {

        void searchFilterChanged(String searchFilter);
        void clearSearchFilterClicked();

        void accomodationSelected(Accomodation accomodation);

        void addNewAccomodationClicked();

        void acccomodationSaved(Accomodation accomodation);
        void accomodationDeleted(Accomodation accomodation);
        void accomodationFormCanceled();

    }

}

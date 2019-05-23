package com.switchfully.vaadin_solutions.exercise_09_declarative_layouts.ui.views;

import com.switchfully.vaadin.exercise_09_declarative_layouts.ui.ExerciseUI;
import com.switchfully.vaadin.exercise_09_declarative_layouts.ui.components.AccomodationResultList;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

@DesignRoot
public class SearchAccomodationView extends CustomComponent implements View {

    private SearchAccomodationViewDesign design = new SearchAccomodationViewDesign();

    public SearchAccomodationView(AccomodationService accomodationService) {
        Design.read(design);

        design.resultList.addItemClickListener(accomodation -> {
            getUI().getNavigator().navigateTo(ExerciseUI.VIEW_ACCOMODATION_DETAIL + "/" + accomodation.getId().toString());
        });

        design.searchButton.addClickListener(
                event -> design.resultList.setAccomodations(
                accomodationService.findAccomodations(design.searchField.getValue())
        ));
        setCompositionRoot(design);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    @DesignRoot
    public static class SearchAccomodationViewDesign extends VerticalLayout {

        TextField searchField;
        Button searchButton;
        AccomodationResultList resultList;

    }

}

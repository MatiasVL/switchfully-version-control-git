package com.switchfully.vaadin_solutions.exercise_11_fieldgroup_fieldfactory_and_custom_fields.ui;

import com.switchfully.vaadin.domain.DateRange;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;

import java.time.LocalDate;

public class DateRangeField extends CustomField<DateRange> {

    private final DatePicker startDateField = new DatePicker();
    private final DatePicker endDateField = new DatePicker();

    public DateRangeField() {
        add(startDateField, endDateField);
    }

    @Override
    protected DateRange generateModelValue() {
        LocalDate startDate = startDateField.getValue();
        LocalDate endDate = endDateField.getValue();
        return startDate != null && endDate != null ? new DateRange(startDate, endDate) : null;
    }

    @Override
    protected void setPresentationValue(DateRange newPresentationValue) {
        startDateField.setValue(newPresentationValue.getStartDate());
        endDateField.setValue(newPresentationValue.getEndDate());
    }

}

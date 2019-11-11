package com.switchfully.vaadin.exercise.exercise_12_custom_fields.components;

import com.switchfully.vaadin.domain.DateRange;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.time.LocalDate;
import java.util.Locale;

public class DateRangeField extends CustomField<DateRange> {

    private final DatePicker startDateField = createStartDateField();
    private final DatePicker endDateField = createEndDateField();

    public DateRangeField(String label) {
        super.setLabel(label);
        Span fromLabel = new Span("From: ");
        Span toLabel = new Span("To: ");
        HorizontalLayout layout = new HorizontalLayout(fromLabel, startDateField, toLabel, endDateField);
        add(layout);
    }

    private DatePicker createStartDateField() {
        DatePicker datePicker = new DatePicker();
        datePicker.setLocale(new Locale("nl", "BE"));
        return datePicker;
    }

    private DatePicker createEndDateField() {
        DatePicker datePicker = new DatePicker();
        datePicker.setLocale(new Locale("nl", "BE"));
        return datePicker;
    }

    @Override
    protected DateRange generateModelValue() {
        LocalDate startDate = startDateField.getValue();
        LocalDate endDate = endDateField.getValue();

        if (endDate != null && endDate.isBefore(startDate)) {
            setInvalid(true);
            setErrorMessage("End date cannot be before start date of the period.");
            return null;
        } else {
            setInvalid(false);
        }

        return startDate != null && endDate != null ? new DateRange(startDate, endDate) : null;
    }

    @Override
    protected void setPresentationValue(DateRange newPresentationValue) {
        startDateField.setValue(newPresentationValue.getStartDate());
        endDateField.setValue(newPresentationValue.getEndDate());
    }

}

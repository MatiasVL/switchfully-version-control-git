package com.switchfully.vaadin_solutions.exercise_11_fieldgroup_fieldfactory_and_custom_fields.ui;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Locale;

/**
 * Provides a conversion between old {@link Date} and new {@link LocalDate} API.
 */
public class LocalDateToDateConverter implements Converter<Date, LocalDate> {

    private static final long serialVersionUID = 1L;

    @Override
    public Result<LocalDate> convertToModel(Date value, ValueContext context) {

        if (value != null) {
            return Result.ok(value.toInstant().atZone(ZoneOffset.systemDefault()).toLocalDate());
        }

        return null;
    }

    @Override
    public Date convertToPresentation(LocalDate value, ValueContext context) {

        if (value != null) {
            return Date.from(value.atStartOfDay().atZone(ZoneOffset.systemDefault()).toInstant());
        }

        return null;
    }

}
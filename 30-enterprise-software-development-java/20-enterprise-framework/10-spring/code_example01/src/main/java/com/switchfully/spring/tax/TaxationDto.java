package com.switchfully.spring.tax;

import java.time.LocalDate;

public class TaxationDto {
    private final String fullName;
    private final int brutoIncome;
    private final double netIncome;
    private final double taxes;
    private LocalDate dueDate;

    public TaxationDto(String fullName, int brutoIncome, double netIncome, double taxes, LocalDate dueDate) {
        this.fullName = fullName;
        this.brutoIncome = brutoIncome;
        this.netIncome = netIncome;
        this.taxes = taxes;
        this.dueDate = dueDate;
    }

    public String getFullName() {
        return fullName;
    }

    public int getBrutoIncome() {
        return brutoIncome;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public double getTaxes() {
        return taxes;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}

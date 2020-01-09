package com.switchfully.spring.tax;

public class Taxation {
    private final String fullName;
    private final int brutoIncome;
    private final double netIncome;
    private final double taxes;

    public Taxation(String fullName, int brutoIncome, double netIncome, double taxes) {
        this.fullName = fullName;
        this.brutoIncome = brutoIncome;
        this.netIncome = netIncome;
        this.taxes = taxes;
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
}

package com.switchfully.spring.tax.system;

import com.switchfully.spring.person.Person;
import com.switchfully.spring.tax.Taxation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("belgium")
public class BelgianTaxSystem implements TaxSystem {

    @Value("${tax.rate}")
    private double taxRate;
    @Value("${tax.lower.limit}")
    private double lowerTaxLimit;
    @Value("${tax.medium.limit}")
    private double mediumTaxLimit;
    @Value("${tax.high.rate}")
    private double highTaxRate;
    @Value("${tax.reduction.singer}")
    private double singerReduction;
    @Value("${tax.reduction.painter}")
    private double painterReduction;

    @Override
    public Taxation calculateTaxFor(Person person, double income) {
        double taxes = getTaxes(person, income);
        return new Taxation(person.getFullName(), income, income - taxes, taxes);
    }

    private double getTaxes(Person person, double income) {
        double taxes = 0;

        if (income > lowerTaxLimit) {
            if (income < mediumTaxLimit) {
                taxes += income * taxRate;
            } else {
                taxes += (income - mediumTaxLimit) * highTaxRate;
                taxes += mediumTaxLimit * taxRate;
            }
        } else {
            taxes += lowerTaxLimit * taxRate;
        }

        taxes -= (income * getReduction(person));
        return taxes;
    }

    private double getReduction(Person person) {
        switch (person.getJob()) {
            case SINGER:
                return singerReduction;
            case PAINTER:
                return painterReduction;
            default:
                return 0;
        }
    }
}

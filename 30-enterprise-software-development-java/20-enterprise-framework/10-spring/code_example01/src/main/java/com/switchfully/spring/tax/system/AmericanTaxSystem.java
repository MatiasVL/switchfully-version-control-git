package com.switchfully.spring.tax.system;

import com.switchfully.spring.person.Person;
import com.switchfully.spring.tax.Taxation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("usa")
public class AmericanTaxSystem implements TaxSystem {

    @Value("${tax.rate}")
    private double taxRate;
    @Value("${tax.flat}")
    private double flat;
    @Value("${tax.medium.limit}")
    private double mediumTaxLimit;
    @Value("${tax.high.rate}")
    private double highTaxRate;

    @Override
    public Taxation calculateTaxFor(Person person, int income) {
        double taxes = getTaxes(income);
        return new Taxation(person.getFullName(), income, income - taxes, taxes);
    }

    private double getTaxes(int income) {
        double taxes = 0;
        if (income > mediumTaxLimit) {
            taxes += (income - mediumTaxLimit) * highTaxRate;
        }

        taxes += flat + taxRate * income;
        if(taxes < income) {
            return taxes;
        }
        return income * taxRate;
    }
}

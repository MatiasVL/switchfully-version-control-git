package _07_strategy;

import _07_strategy.taxcalculations.AmericanTaxCalculation;
import _07_strategy.taxcalculations.BelgianTaxCalculation;

public class TaxCalculationApplication {

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator(new BelgianTaxCalculation());

        double belgianTaxesFor30k = taxCalculator.calculateTaxesForIncome(30000);
        System.out.println(String.format("Belgian amount of taxes for a yearly income of 30k: €%2.2f", belgianTaxesFor30k));

        taxCalculator.swapTaxCalculationStrategy(new AmericanTaxCalculation());
        double americanTaxesFor30k = taxCalculator.calculateTaxesForIncome(30000);
        System.out.println(String.format("American amount of taxes for a yearly income of 30k: €%2.2f", americanTaxesFor30k));
    }

}

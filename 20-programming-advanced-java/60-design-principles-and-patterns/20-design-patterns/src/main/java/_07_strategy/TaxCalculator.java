package _07_strategy;

import _07_strategy.taxcalculations.TaxCalculationStrategy;

public class TaxCalculator {

    private TaxCalculationStrategy taxCalculationStrategy;

    public TaxCalculator(TaxCalculationStrategy taxCalculationStrategy) {
        this.taxCalculationStrategy = taxCalculationStrategy;
    }

    public void swapTaxCalculationStrategy(TaxCalculationStrategy taxCalculationStrategy) {
        this.taxCalculationStrategy = taxCalculationStrategy;
    }

    public double calculateTaxesForIncome(double yearlyIncome) {
        return taxCalculationStrategy.calculateTaxes(yearlyIncome);
    }
}

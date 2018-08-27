package _07_strategy.taxcalculations;

public class FrenchTaxCalculation implements TaxCalculationStrategy {

    private static final double FRENCH_TAX_RATE = 0.48;

    @Override
    public double calculateTaxes(double yearlyIncome) {
        return yearlyIncome * FRENCH_TAX_RATE;
    }
}

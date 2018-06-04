package _07_strategy.taxcalculations;

public class BelgianTaxCalculation implements TaxCalculationStrategy {

    private static final double BELGIAN_TAX_RATE = 0.45;

    @Override
    public double calculateTaxes(double yearlyIncome) {
        return yearlyIncome * BELGIAN_TAX_RATE;
    }

}

package _07_strategy.taxcalculations;

public class AmericanTaxCalculation implements TaxCalculationStrategy {

    private static final double AMERICAN_TAX_RATE = 0.18;
    private static final double LUMP_SUM = 950;

    @Override
    public double calculateTaxes(double yearlyIncome) {
        return yearlyIncome * AMERICAN_TAX_RATE + LUMP_SUM;
    }
}

package codelab01;

/**
 * You don't have to change anything in this class.
 */
class NuclearPowerplant {

    private static final int CRITICAL_POWER_AMOUNT_THRESHOLD = 100;
    private int powerAmount;

    public NuclearPowerplant() {
        powerAmount = 50;
    }

    /**
     * Increases the power of the powerplant with value {@code additionalPowerAmount}
     * @param additionalPowerAmount - The amount of power to add to the total power amount of the nuclear powerplant
     * @return the (combined) total power amount of the nuclear powerplant
     */
    public int increasePower(int additionalPowerAmount) {
        if(this.powerAmount + additionalPowerAmount > CRITICAL_POWER_AMOUNT_THRESHOLD) {
            throw new IllegalArgumentException("DANGER! The total power would exceed the critical threshold of "
                    + CRITICAL_POWER_AMOUNT_THRESHOLD + " (tried to increase with "+ additionalPowerAmount + ")");
        }
        this.powerAmount += additionalPowerAmount;
        return powerAmount;
    }

}

package codelab04;

/**
 * You don't have to change anything in this class.
 */
public class Computer {

    /**
     * By adding the final keyword, we make the field immutable.
     * This means it can be only given a value upon creating the object (in the constructor).
     * Once the object is created, the field (e.g. brand) can not receive a different value.
     */
    private final String brand;
    private final int priceInDollarCents;

    // This is a constructor
    public Computer() {
        brand = "HP";
        priceInDollarCents = 89900;
    }

    // This is a constructor
    public Computer(String aBrand) {
        brand = aBrand;
        priceInDollarCents = 59500;
    }

    // This is a constructor
    public Computer(int aPriceInDollarCents) {
        brand = "HP";
        priceInDollarCents = aPriceInDollarCents;
    }

    // This is a constructor
    public Computer(String aBrand, int aPriceInDollarCents) {
        brand = aBrand;
        priceInDollarCents = aPriceInDollarCents;
    }

    /**
     * Method to 'convert' a Computer to a textual (String) representation / version
     * @return the textual (String) representation of a Computer
     */
    @Override
    public String toString() {
        return "I'm a computer of brand " + brand + " and I cost " + priceInDollarCents + " dollar(cents)";
    }
}

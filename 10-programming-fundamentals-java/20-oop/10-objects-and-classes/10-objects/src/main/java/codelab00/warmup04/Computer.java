package codelab00.warmup04;

/**
 * You don't have to change anything in this class.
 */
public class Computer {

    private String brand;
    private int priceInDollarCents;

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

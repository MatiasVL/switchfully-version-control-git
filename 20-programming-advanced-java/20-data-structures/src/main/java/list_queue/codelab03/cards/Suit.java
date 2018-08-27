package list_queue.codelab03.cards;

public class Suit {

    public static final Suit HEARTS = new Suit("Hearts");
    public static final Suit DIAMONDS = new Suit("Diamonds");
    public static final Suit CLUBS = new Suit("Clubs");
    public static final Suit SPADES = new Suit("Spades");

    private final String name;

    private Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Suit[] values() {
        return new Suit[]{HEARTS, DIAMONDS, CLUBS, SPADES};
    }
}

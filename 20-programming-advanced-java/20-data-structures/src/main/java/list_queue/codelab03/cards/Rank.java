package list_queue.codelab03.cards;

public class Rank {

    public final static Rank ACE = new Rank("Ace");
    public final static Rank TWO = new Rank("2");
    public final static Rank THREE = new Rank("3");
    public final static Rank FOUR = new Rank("4");
    public final static Rank FIVE = new Rank("5");
    public final static Rank SIX = new Rank("6");
    public final static Rank SEVEN = new Rank("7");
    public final static Rank EIGHT = new Rank("8");
    public final static Rank NINE = new Rank("9");
    public final static Rank TEN = new Rank("10");
    public final static Rank JACK = new Rank("Jack");
    public final static Rank QUEEN = new Rank("Queen");
    public final static Rank KING = new Rank("King");

    private final String name;

    private Rank(String name) {
        this.name = name;
    }

    public static Rank[] values() {
        return new Rank[]{TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};
    }

    @Override
    public String toString() {
        return name;
    }
}

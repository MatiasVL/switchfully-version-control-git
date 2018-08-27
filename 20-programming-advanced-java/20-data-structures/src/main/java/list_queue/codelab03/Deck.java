package list_queue.codelab03;

import list_queue.codelab03.cards.Card;
import list_queue.codelab03.cards.Rank;
import list_queue.codelab03.cards.Suit;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {

    private static final Random random = new Random();

    // replace this with a proper Collection
    private Card[] cards;


    public Deck() {
        cards = new Card[52];

        int idx = 0;
        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                cards[idx] = new Card(Suit.CLUBS, Rank.ACE);
                idx += 1;
            }
        }
    }

    public Deck(Card[] cards) {
        this.cards = Arrays.copyOf(cards,cards.length);
    }

    public static Deck emptyDeck() {
        return new Deck(new Card[]{});
    }

    public int numberOfCards() {
        return cards.length;
    }

    public List getCards() {
        return Arrays.asList(cards);
    }

    public Deck shuffled() {
        Card[] newCards = new Card[cards.length];

        for (int i = 0; i < newCards.length; i++) {
            int randomIdx = random.nextInt(i+1);
            if (randomIdx != i) {
                newCards[i] = newCards[randomIdx];
            }
            newCards[randomIdx] = cards[i];
        }
        return new Deck(newCards);
    }

    public Card topCard() {
        if(cards.length > 0) {
            return cards[cards.length-1];
        } else {
            return null;
        }
    }

    public Deck popDeck() {
        return new Deck(Arrays.copyOf(cards, cards.length > 0 ? cards.length - 1 : 0));
    }

    public Card pickCard() {
        if (cards.length > 0) {
            int randomIndex = random.nextInt(cards.length);
            return cards[randomIndex];
        } else {
            return null;
        }
    }

    public Deck[] splitDeck(int splitIndex) {
        Deck first = new Deck(Arrays.copyOfRange(cards,0,splitIndex));
        Deck second = new Deck(Arrays.copyOfRange(cards, splitIndex, cards.length));
        return new Deck[] { first, second };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deck deck = (Deck) o;

        return Arrays.equals(cards, deck.cards);
    }
}
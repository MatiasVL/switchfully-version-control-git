package list_queue.codelab03;

import list_queue.codelab03.cards.Card;
import list_queue.codelab03.cards.Rank;
import list_queue.codelab03.cards.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    private Deck deck;

    @BeforeEach
    public void setUp() throws Exception {
        deck = new Deck();
    }

    @Test
    public void numberOfCards_DefaultDeckHasFiftyTwoCards() throws Exception {
        assertThat(deck.numberOfCards()).isEqualTo(52);
    }

    @Test
    public void numberOfCards_aCustomDeckHasCorrectNumberOfCards() throws Exception {
        Card aceOfClubs = new Card(Suit.CLUBS, Rank.ACE);
        Card kingOfDiamonds = new Card(Suit.DIAMONDS, Rank.KING);
        Card sevenOfSpades = new Card(Suit.SPADES, Rank.SEVEN);
        Card[] customCards = new Card[] {aceOfClubs, kingOfDiamonds, sevenOfSpades};

        Deck customDeck = new Deck(customCards);
        assertThat(customDeck.numberOfCards()).isEqualTo(customCards.length);
    }

    @Test
    public void numberOfCards_returnsZero_forEmptyDeck() throws Exception {
        assertThat(Deck.emptyDeck().numberOfCards()).isEqualTo(0);
    }

    @Test
    public void deck_noCardIsTheSame() throws Exception {
        assertThat((new HashSet(deck.getCards())).size()).isEqualTo(deck.numberOfCards());
    }

    @Test
    public void topCard_returnsTopCardFromDeck() throws Exception {
        Card expected = (Card) deck.getCards().get(deck.numberOfCards() - 1);
        Card actual = deck.topCard();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void topCard_returnsNull_forEmptyDeck() throws Exception {
        assertThat(Deck.emptyDeck().topCard()).isNull();
    }

    @Test
    public void popDeck_returnsDeckWithTopCardRemoved() throws Exception {
        Card topCard = deck.topCard();
        Deck remainingDeck = deck.popDeck();
        assertThat(remainingDeck.numberOfCards()).isEqualTo(deck.numberOfCards()-1);
        assertThat(topCard).isNotIn(remainingDeck.getCards());
    }

    @Test
    public void popDeck_returnsEmptyDeck_forEmptyDeck() throws Exception {
        assertThat(Deck.emptyDeck().popDeck()).isEqualTo(Deck.emptyDeck());
    }

    @Test
    public void pickCard_returnsRandomCardFromDeck() throws Exception {
        assertThat(deck.pickCard()).isIn(deck.getCards());
    }

    @Test
    public void pickCard_returnsNull_forEmptyDeck() throws Exception {
        assertThat(Deck.emptyDeck().pickCard()).isNull();
    }

    @Test
    public void shuffle_aShuffledDeckHasTheSameCards() throws Exception {
        Deck shuffled = deck.shuffled();
        assertThat(shuffled.numberOfCards()).isEqualTo(deck.numberOfCards());
        assertThat(shuffled.getCards()).containsExactlyInAnyOrder(deck.getCards().toArray());
    }

    @Test
    public void splitDeck_returnsTwoHalvesThatResultFromSplitAtIndex() throws Exception {
        Card[] cards = (Card[]) deck.getCards().toArray(new Card[0]);
        int splitIndex = 27;
        Deck expectedLeftDeck = new Deck(Arrays.copyOfRange(cards, 0, splitIndex));
        Deck expectedRightDeck = new Deck(Arrays.copyOfRange(cards, splitIndex, cards.length));

        Deck[] deckHalves = deck.splitDeck(splitIndex);

        assertThat(deckHalves[0]).isEqualTo(expectedLeftDeck);
        assertThat(deckHalves[1]).isEqualTo(expectedRightDeck);
    }
}
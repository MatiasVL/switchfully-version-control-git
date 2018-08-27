package list_queue.codelab03.cards;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    private Card aceOfClubs;
    private Card kingOfDiamonds;

    @BeforeEach
    public void setUp() throws Exception {
        aceOfClubs = new Card(Suit.CLUBS, Rank.ACE);
        kingOfDiamonds = new Card(Suit.DIAMONDS, Rank.KING);
    }

    @Test
    public void equals_cardsAreEqualWhenRankAndSuitAreEqual() throws Exception {
        Card otherAceOfClubs = new Card(Suit.CLUBS, Rank.ACE);
        assertThat(otherAceOfClubs).isEqualTo(aceOfClubs);
    }

    @Test
    public void equals_cardsAreNotEqualWhenRankOrSuitAreNotEqual() throws Exception {
        assertThat(kingOfDiamonds).isNotEqualTo(aceOfClubs);
        assertThat(new Card(Suit.CLUBS,Rank.KING)).isNotEqualTo(aceOfClubs);
        assertThat(new Card(Suit.HEARTS, Rank.KING)).isNotEqualTo(kingOfDiamonds);
    }

    @Test
    public void getSuit_returnsSuit() throws Exception {
        assertThat(aceOfClubs.getSuit()).isEqualTo(Suit.CLUBS);
        assertThat(kingOfDiamonds.getSuit()).isEqualTo(Suit.DIAMONDS);
    }

    @Test
    public void getRank_returnsRank() throws Exception {
        assertThat(aceOfClubs.getRank()).isEqualTo(Rank.ACE);
        assertThat(kingOfDiamonds.getRank()).isEqualTo(Rank.KING);
    }
}
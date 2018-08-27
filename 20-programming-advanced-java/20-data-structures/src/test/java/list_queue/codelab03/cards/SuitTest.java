package list_queue.codelab03.cards;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuitTest {

    @Test
    public void equalSuits_areIdentical() throws Exception {
        Suit clubs = Suit.CLUBS;
        Suit otherClubs = Suit.CLUBS;
        Suit diamonds = Suit.DIAMONDS;
        Suit otherDiamonds = Suit.DIAMONDS;
        Suit hearts = Suit.HEARTS;
        Suit otherHearts = Suit.HEARTS;
        Suit spades = Suit.SPADES;
        Suit otherSpades = Suit.SPADES;

        assertThat(clubs == otherClubs).isTrue();
        assertThat(diamonds == otherDiamonds).isTrue();
        assertThat(hearts == otherHearts).isTrue();
        assertThat(spades == otherSpades).isTrue();
    }

    @Test
    public void differentSuits_areNotIdentical() throws Exception {
        Suit clubs = Suit.CLUBS;
        Suit diamonds = Suit.DIAMONDS;
        Suit hearts = Suit.HEARTS;
        Suit spades = Suit.SPADES;

        assertThat(clubs == diamonds).isFalse();
        assertThat(clubs == hearts).isFalse();
        assertThat(clubs == spades).isFalse();
        assertThat(diamonds == hearts).isFalse();
        assertThat(diamonds == spades).isFalse();
        assertThat(hearts == spades).isFalse();
    }

    @Test
    public void equalSuits_areEqual() throws Exception {
        Suit clubs = Suit.CLUBS;
        Suit otherClubs = Suit.CLUBS;
        Suit diamonds = Suit.DIAMONDS;
        Suit otherDiamonds = Suit.DIAMONDS;
        Suit hearts = Suit.HEARTS;
        Suit otherHearts = Suit.HEARTS;
        Suit spades = Suit.SPADES;
        Suit otherSpades = Suit.SPADES;

        assertThat(clubs).isEqualTo(otherClubs);
        assertThat(diamonds).isEqualTo(otherDiamonds);
        assertThat(hearts).isEqualTo(otherHearts);
        assertThat(spades).isEqualTo(otherSpades);
    }

    @Test
    public void differentSuits_areNotEqual() throws Exception {
        Suit clubs = Suit.CLUBS;
        Suit diamonds = Suit.DIAMONDS;
        Suit hearts = Suit.HEARTS;
        Suit spades = Suit.SPADES;

        assertThat(clubs).isNotEqualTo(diamonds);
        assertThat(clubs).isNotEqualTo(hearts);
        assertThat(clubs).isNotEqualTo(spades);
        assertThat(diamonds).isNotEqualTo(hearts);
        assertThat(diamonds).isNotEqualTo(spades);
        assertThat(hearts).isNotEqualTo(spades);
    }
}
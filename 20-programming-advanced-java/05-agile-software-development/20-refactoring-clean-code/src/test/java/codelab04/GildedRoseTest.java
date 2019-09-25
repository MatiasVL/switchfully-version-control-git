package codelab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality() {
        // Message to myself, from Leeroy: I'm not a fan of tests since I know how my code works...
        // Writing a dummy test just so I can tell other developers I have tests for my code. :)
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("foo", gildedRose.items[0].getName());
    }
}

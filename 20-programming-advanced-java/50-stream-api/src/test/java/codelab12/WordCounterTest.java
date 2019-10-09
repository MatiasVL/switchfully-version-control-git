package codelab12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordCounterTest {

    private WordCounter wordCounter = new WordCounter();

    @Test
    void countWords() {
        assertThat(wordCounter.countWords("test ok")).isEqualTo("2:1, 4:1");
        assertThat(wordCounter.countWords("uk ok gold go")).isEqualTo("2:3, 4:1");
        assertThat(wordCounter.countWords("blue black red transformation bed")).isEqualTo("3:2, 4:1, 5:1, 14:1");
    }
}
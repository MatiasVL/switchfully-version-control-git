package codelab03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void arrayForSize2() throws Exception {
        Assertions.assertThat(Main.createArrayForSize(2)).containsExactly(
                new char[]{'@', '@'},
                new char[]{'@', '@'});
    }

    @Test
    void arrayForSize3() throws Exception {
        Assertions.assertThat(Main.createArrayForSize(3)).containsExactly(
                new char[]{'@', '@', '@'},
                new char[]{'@', ' ', '@'},
                new char[]{'@', '@', '@'});
    }

    @Test
    void arrayForSize4() throws Exception {
        Assertions.assertThat(Main.createArrayForSize(4)).containsExactly(
                new char[]{'@', '@', '@', '@'},
                new char[]{'@', ' ', ' ', '@'},
                new char[]{'@', ' ', ' ', '@'},
                new char[]{'@', '@', '@', '@'});
    }

    @Test
    void arrayForSize5() throws Exception {
        Assertions.assertThat(Main.createArrayForSize(5)).containsExactly(
                new char[]{'@', '@', '@', '@', '@'},
                new char[]{'@', ' ', ' ', ' ', '@'},
                new char[]{'@', ' ', ' ', ' ', '@'},
                new char[]{'@', ' ', ' ', ' ', '@'},
                new char[]{'@', '@', '@', '@', '@'});
    }

}

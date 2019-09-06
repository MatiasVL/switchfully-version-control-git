import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class LoopsCodelabsIntermediate01Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    void simpleArray() {
        LoopsCodelabsIntermediate01.printOutArray(new String[]{"This", "Is", "Super", "Cool"});

        assertThat(outContent.toString().trim()).isEqualTo(
                "At index 0 there is: This\r\n" +
                "At index 1 there is: Is\r\n" +
                "At index 2 there is: Super\r\n" +
                "At index 3 there is: Cool\r\n" +
                        "Thank you for using the print services");
    }

    @Test
    void emptyArray() {
        LoopsCodelabsIntermediate01.printOutArray(new String[]{});

        assertThat(outContent.toString().trim()).isEqualTo("Nothing to print");
    }
}
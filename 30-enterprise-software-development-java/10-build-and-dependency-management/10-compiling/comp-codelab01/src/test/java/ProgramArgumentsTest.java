import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramArgumentsTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final String separator = System.getProperty("line.separator");

    @BeforeEach
    void setUp() throws Exception {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    void printArray_shouldPrintEachItemOnALineWithIndexColonPrefix() throws Exception {
        String[] strings = {"first", "second", "third"};
        String expected = String.format("0:%s" + separator + "1:%s" + separator + "2:%s" + separator, (Object[]) strings);

        ProgramArguments.printArray(strings);

        assertThat(outStream.toString()).isEqualTo(expected);
    }

    @Test
    void printArray_shouldPrintNothingWhenStringsIsEmpty() throws Exception {
        String[] strings = {};
        String expected = "";

        ProgramArguments.printArray(strings);

        assertThat(outStream.toString()).isEqualTo(expected);
    }

    @Test
    void printArray_shouldPrintNothingWhenStringsIsNull() throws Exception {
        String[] strings = null;
        String expected = "";

        ProgramArguments.printArray(strings);

        assertThat(outStream.toString()).isEqualTo(expected);
    }
}


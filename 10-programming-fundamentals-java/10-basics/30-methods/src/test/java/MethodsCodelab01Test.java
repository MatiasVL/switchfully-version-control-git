import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MethodsCodelab01Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void get5IsCorrectlyCreated() throws Exception {
        assertThat(MethodsCodelab01.class.getDeclaredMethod("get5")).isNotNull();
        assertThat(MethodsCodelab01.class.getDeclaredMethod("get5").getReturnType()).isEqualTo(int.class);
    }

    @Test
    public void get5isPrinted() throws Exception {
        MethodsCodelab01.main(null);
        assertEquals("5", outContent.toString().toLowerCase().trim());
    }

}
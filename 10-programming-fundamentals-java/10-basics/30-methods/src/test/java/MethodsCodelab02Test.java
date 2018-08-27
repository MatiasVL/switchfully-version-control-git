import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;


public class MethodsCodelab02Test {

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
    public void addIsCorrectlyCreated() throws Exception {
        assertThat(MethodsCodelab02.class.getDeclaredMethod("add", double.class, double.class)).isNotNull();
        assertThat(MethodsCodelab02.class.getDeclaredMethod("add", double.class, double.class).getReturnType()).isEqualTo(double.class);
    }

    @Test
    public void addIsPrinted() throws Exception {
        MethodsCodelab02.main(null);
        assertThat(outContent.toString().toLowerCase().trim()).contains("90.52");
    }

}
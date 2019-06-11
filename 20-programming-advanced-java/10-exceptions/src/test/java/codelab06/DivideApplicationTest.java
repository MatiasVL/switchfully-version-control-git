package codelab06;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class DivideApplicationTest {

    private InputStream inputStream;
    private ByteArrayOutputStream content = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() throws Exception {
        System.setOut(new PrintStream(content));
    }

    @Test
    void happyPath_givenTwoNumbers_thenResultIsTheDivision() {
        inputStream = new ByteArrayInputStream("10.0 2.0".getBytes());
        System.setIn(inputStream);

        DivideApplication.main(null);

        Assertions.assertThat(content.toString().trim()).contains("Result: 5.0");
    }

    @Test
    void happyPath_givenNumberAnd0_thenResultIsInfinity() {
        inputStream = new ByteArrayInputStream("5.0 0.0".getBytes());
        System.setIn(inputStream);

        DivideApplication.main(null);

        Assertions.assertThat(content.toString().trim()).contains("Result: Infinity");
    }

    @Test
    void happyPath_givenNumberAndNotANumber_thenResultIsNotANumberMessage() {
        inputStream = new ByteArrayInputStream("5.0 hello".getBytes());
        System.setIn(inputStream);

        DivideApplication.main(null);

        Assertions.assertThat(content.toString().trim()).contains("Could not divide: non-numeric values were inserted");
    }

    @Test
    void happyPath_givenNotANumberAndNumber_thenResultIsNotANumberMessage() {
        inputStream = new ByteArrayInputStream("hi 8.5".getBytes());
        System.setIn(inputStream);

        DivideApplication.main(null);

        Assertions.assertThat(content.toString().trim()).contains("Could not divide: non-numeric values were inserted");
    }

    @Test
    void happyPath_givenTwoNotNumbers_thenResultIsNotANumberMessage() {
        inputStream = new ByteArrayInputStream("hi goodbye".getBytes());
        System.setIn(inputStream);

        DivideApplication.main(null);

        Assertions.assertThat(content.toString().trim()).contains("Could not divide: non-numeric values were inserted");
    }

}
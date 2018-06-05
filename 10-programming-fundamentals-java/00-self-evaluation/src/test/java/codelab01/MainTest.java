package codelab01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

class MainTest {

    private ByteArrayOutputStream content = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() throws Exception {
        System.setOut(new PrintStream(content));
    }

    @Test
    void helloWorldTest() throws Exception {
        Main.printHelloWorld();

        Assertions.assertThat(content.toString().trim()).isEqualTo("Hello World!");
    }

    @Test
    void printAnyString_HelloWorld() throws Exception {
        Method printAny = Main.class.getMethod("printAny", String.class);

        printAny.invoke(Main.class, "Hello World!");

        Assertions.assertThat(content.toString().trim()).isEqualTo("Hello World!");
    }

    @Test
    void printAnyString_CandyTime() throws Exception {
        Method printAny = Main.class.getMethod("printAny", String.class);

        printAny.invoke(Main.class, "Candy time!");

        Assertions.assertThat(content.toString().trim()).isEqualTo("Candy time!");
    }

    @Test
    void printInt() throws Exception {
        Method printNumber = Main.class.getMethod("printNumber", Integer.class);

        printNumber.invoke(Main.class,1);

        Assertions.assertThat(content.toString().trim()).isEqualTo("I'm an int: 1");
    }

    @Test
    void printDouble() throws Exception {
        Method printNumber = Main.class.getMethod("printNumber", Double.class);

        printNumber.invoke(Main.class,1.0);

        Assertions.assertThat(content.toString().trim()).isEqualTo("I'm a double: 1.0");
    }

    @Test
    void returnAddedByOne() throws Exception {
        Assertions.assertThat(Main.addByOne(5)).isEqualTo(6);
    }
}
package codelab03;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MyOwnLocalDateTest {

    @Test
    void create_givenCorrectParameters_thenReturnMyOwnLocalDateObject() {
        MyOwnLocalDate myOwnLocalDate = MyOwnLocalDate.create(2018, 11, 20);

        assertEquals(myOwnLocalDate.toString(), "20/11/2018");
    }

    @Test
    void create_givenTooLowYear_thenThrowDateTimeException() {
        DateTimeException dateTimeException = assertThrows(DateTimeException.class, () -> {
            MyOwnLocalDate.create(MyOwnLocalDate.MIN_YEAR - 1, 11, 20);
        });

        assertEquals(dateTimeException.getMessage(), "The provided year is not allowed!");
    }

    @Test
    void create_givenTooHighYear_thenThrowDateTimeException() {
        DateTimeException dateTimeException = assertThrows(DateTimeException.class, () -> {
            MyOwnLocalDate.create(MyOwnLocalDate.MAX_YEAR + 1, 11, 20);
        });

        assertEquals(dateTimeException.getMessage(), "The provided year is not allowed!");
    }

    @Test
    void create_givenTooLowMonth_thenThrowDateTimeException() {
        DateTimeException dateTimeException = assertThrows(DateTimeException.class, () -> {
            MyOwnLocalDate.create(2018, 0, 20);
        });

        assertEquals(dateTimeException.getMessage(), "The provided month is not allowed!");
    }

    @Test
    void create_givenTooHighMonth_thenThrowDateTimeException() {
        DateTimeException dateTimeException = assertThrows(DateTimeException.class, () -> {
            MyOwnLocalDate.create(2018, 13, 20);
        });

        assertEquals(dateTimeException.getMessage(), "The provided month is not allowed!");
    }

    @Test
    void create_givenTooLowDay_thenThrowDateTimeException() {
        DateTimeException dateTimeException = assertThrows(DateTimeException.class, () -> {
            MyOwnLocalDate.create(2018, 10, 0);
        });

        assertEquals(dateTimeException.getMessage(), "The provided dayOfMonth is not allowed!");
    }

    @Test
    void create_givenTooHighDay_thenThrowDateTimeException() {
        DateTimeException dateTimeException = assertThrows(DateTimeException.class, () -> {
            MyOwnLocalDate.create(2018, 10, 32);
        });

        assertEquals(dateTimeException.getMessage(), "The provided dayOfMonth is not allowed!");
    }

}
package codelab02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomTimeTest {

    @BeforeEach
    public void setUp() throws Exception {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Test
    public void create_defaultConstructorReturnsMidnight() throws Exception {
        CustomTime expectedCustomTime = new CustomTime(0, 0, 0);
        CustomTime defaultCustomTime = new CustomTime();
        assertThat(defaultCustomTime).isEqualTo(expectedCustomTime);
    }

    @Test
    public void midnight_hasCustomTimeOfMidnight() throws Exception {
        CustomTime expectedCustomTime = new CustomTime(0, 0, 0);
        assertThat(CustomTime.MIDNIGHT).isEqualTo(expectedCustomTime);
    }

    @Test
    public void noon_hasCustomTimeOfNoon() throws Exception {
        CustomTime expectedCustomTime = new CustomTime(12, 0, 0);
        assertThat(CustomTime.NOON).isEqualTo(expectedCustomTime);
    }

    @Test
    public void toString_shouldReturnCorrectString() throws Exception {
        String expected = "09:41:03.3";
        CustomTime time = new CustomTime(9, 41, 3.331);
        assertThat(time.toString()).isEqualTo(expected);
    }

    @Test
    public void equals_shouldReturnTrueForEqualObjects() throws Exception {
        CustomTime time1 = new CustomTime(9, 41, 3.331);
        CustomTime time2 = new CustomTime(9, 41, 3.331);
        assertThat(time1.equals(time2)).isTrue();
    }

    @Test
    public void equals_shouldReturnFalseIfHourIsDifferent() throws Exception {
        CustomTime time1 = new CustomTime(9, 41, 3.331);
        CustomTime time2 = new CustomTime(8, 41, 3.331);
        assertThat(time1.equals(time2)).isFalse();
    }

    @Test
    public void equals_shouldReturnFalseIfMinuteIsDifferent() throws Exception {
        CustomTime time1 = new CustomTime(9, 41, 3.331);
        CustomTime time2 = new CustomTime(9, 42, 3.331);
        assertThat(time1.equals(time2)).isFalse();
    }

    @Test
    public void equals_shouldReturnFalseIfSecondIsDifferent() throws Exception {
        CustomTime time1 = new CustomTime(9, 41, 3.331);
        CustomTime time2 = new CustomTime(9, 41, 3.332);
        assertThat(time1.equals(time2)).isFalse();
    }

    @Test
    public void add_shouldAddCustomTimeToThisObject() throws Exception {
        CustomTime expectedCustomTime = new CustomTime(0, 0, 0);
        CustomTime time1 = new CustomTime(9, 41, 3.331);
        CustomTime time2 = new CustomTime(14, 18, 56.669);
        time1.add(time2);

        assertThat(time1).isEqualTo(expectedCustomTime);
    }

}
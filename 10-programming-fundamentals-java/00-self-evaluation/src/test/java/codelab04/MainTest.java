package codelab04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void CalculatePrice_1Element_Returns5() throws Exception {
        assertThat(Main.calculatePrice(1)).isEqualTo(5);
    }

    @Test
    void CalculatePrice_0Elements_Returns0() throws Exception {
        assertThat(Main.calculatePrice(0)).isEqualTo(0);
    }

    @Test
    void CalculatePrice_9Elements_Returns45() throws Exception {
        assertThat(Main.calculatePrice(9)).isEqualTo(45);
    }

    @Test
    void CalculatePrice_10Elements_Returns50() throws Exception {
        assertThat(Main.calculatePrice(10)).isEqualTo(50);
    }

    @Test
    void CalculatePrice_11Elements_Returns54() throws Exception {
        assertThat(Main.calculatePrice(11)).isEqualTo(54);
    }

    @Test
    void CalculatePrice_15Elements_Returns70() throws Exception {
        assertThat(Main.calculatePrice(15)).isEqualTo(70);
    }

    @Test
    void CalculatePrice_16Elements_Returns73() throws Exception {
        assertThat(Main.calculatePrice(16)).isEqualTo(73);
    }

    @Test
    void CalculatePrice_20Elements_Returns85() throws Exception {
        assertThat(Main.calculatePrice(20)).isEqualTo(85);
    }

    @Test
    void CalculatePrice_NegativeElements_Returns0() throws Exception {
        assertThat(Main.calculatePrice(-1)).isEqualTo(0);
    }

    @Test
    void ReturnText_1() throws Exception {
        assertThat(Main.returnText(1)).isEqualTo("It's something");
    }

    @Test
    void ReturnText_2() throws Exception {
        assertThat(Main.returnText(2)).isEqualTo("That's more like it");
    }

    @Test
    void ReturnText_3() throws Exception {
        assertThat(Main.returnText(3)).isEqualTo("Way to go");
    }

    @Test
    void ReturnText_4() throws Exception {
        assertThat(Main.returnText(4)).isEqualTo("That's a fail whale");
    }

    @Test
    void ReturnText_0() throws Exception {
        assertThat(Main.returnText(0)).isEqualTo("That's a fail whale");
    }

}

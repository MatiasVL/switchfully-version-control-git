package codelab04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void ReturnMonth_ShouldReturnJanuary_WhenInputIs1() throws Exception {
        assertThat(Main.month(1)).isEqualTo("January");
    }

    @Test
    void ReturnMonth_ShouldReturnFebruary_WhenInputIs2() throws Exception {
        assertThat(Main.month(2)).isEqualTo("February");
    }

    @Test
    void ReturnMonth_ShouldReturnMarch_WhenInputIs3() throws Exception {
        assertThat(Main.month(3)).isEqualTo("March");
    }

    @Test
    void ReturnMonth_ShouldReturnApril_WhenInputIs4() throws Exception {
        assertThat(Main.month(4)).isEqualTo("April");
    }

    @Test
    void ReturnMonth_ShouldReturnMay_WhenInputIs5() throws Exception {
        assertThat(Main.month(5)).isEqualTo("May");
    }

    @Test
    void ReturnMonth_ShouldReturnJune_WhenInputIs6() throws Exception {
        assertThat(Main.month(6)).isEqualTo("June");
    }

    @Test
    void ReturnMonth_ShouldReturnJuly_WhenInputIs7() throws Exception {
        assertThat(Main.month(7)).isEqualTo("July");
    }

    @Test
    void ReturnMonth_ShouldReturnAugust_WhenInputIs1() throws Exception {
        assertThat(Main.month(8)).isEqualTo("August");
    }

    @Test
    void ReturnMonth_ShouldReturnSeptember_WhenInputIs9() throws Exception {
        assertThat(Main.month(9)).isEqualTo("September");
    }

    @Test
    void ReturnMonth_ShouldReturnOctober_WhenInputIs10() throws Exception {
        assertThat(Main.month(10)).isEqualTo("October");
    }

    @Test
    void ReturnMonth_ShouldReturnNovember_WhenInputIs11() throws Exception {
        assertThat(Main.month(11)).isEqualTo("November");
    }

    @Test
    void ReturnMonth_ShouldReturnDecember_WhenInputIs12() throws Exception {
        assertThat(Main.month(12)).isEqualTo("December");
    }

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

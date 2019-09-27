package codelab02;

import codelab02.domain.HarryPotterBook;
import codelab02.domain.HarryPotterBookTitle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * This test class shows how you can use JUnit5's Parameterized tests to create one test with different
 * arguments. This test class tests exactly the same behavior as the BookServiceTest class, but uses the concept
 * of parameterized tests. For each different arguments object passed into the test as an argument, the test will be run.
 * --> In this case, using Parameterized tests impact the readability of our test negatively.
 */
class BookServiceTestUsingParameterizedTests {

    @ParameterizedTest(name = "({index}) Expected price = {0} for selected books {1}")
    @MethodSource("boughtBooksAndExpectedPriceProvider")
    void givenSelectedBooks_whenCalculatingPrice_thenReturnCorrectlyCalculatedPrice(String expectedPrice, ArrayList<HarryPotterBook> selectedBooks) {
        double actualPrice = new BookService().shop(selectedBooks);
        assertThat(formatDecimalTwoDigits(actualPrice)).isEqualTo(expectedPrice);
    }

    private static Stream<Arguments> boughtBooksAndExpectedPriceProvider() {
        return Stream
                .of(
                        OneBookCostsBasePrice(),
                        TwoDifferentBooksCostBasePriceWith5PctDiscount(),
                        ThreeDifferentBooksCostBasePriceWith10PctDiscount(),
                        FourDifferentBooksCostBasePriceWith20PctDiscount(),
                        FiveDifferentBooksCostBasePriceWith25PctDiscount(),
                        TwoIdenticalBooksCostBasePrice(),
                        TwoDifferentPairsEachOfAnIdenticalBookCostBasePriceWithDiscountAppliedOnlyOnce(),
                        MultipleBooksCostTheCorrectPrice()
                );
    }

    private static Arguments MultipleBooksCostTheCorrectPrice() {
        return arguments("54.0", newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PHILOSOPHERS_STONE),
                new HarryPotterBook(HarryPotterBookTitle.THE_PHILOSOPHERS_STONE),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_ORDER_OF_THE_PHOENIX),
                new HarryPotterBook(HarryPotterBookTitle.THE_GOBLET_OF_FIRE)));
    }

    private static Arguments TwoDifferentPairsEachOfAnIdenticalBookCostBasePriceWithDiscountAppliedOnlyOnce() {
        return arguments("31.2", newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN)));
    }

    private static Arguments TwoIdenticalBooksCostBasePrice() {
        return arguments("16.0", newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS)));
    }

    private static Arguments FiveDifferentBooksCostBasePriceWith25PctDiscount() {
        return arguments("30.0", newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_GOBLET_OF_FIRE),
                new HarryPotterBook(HarryPotterBookTitle.THE_ORDER_OF_THE_PHOENIX),
                new HarryPotterBook(HarryPotterBookTitle.THE_PHILOSOPHERS_STONE)));
    }

    private static Arguments FourDifferentBooksCostBasePriceWith20PctDiscount() {
        return arguments("25.6", newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_GOBLET_OF_FIRE),
                new HarryPotterBook(HarryPotterBookTitle.THE_ORDER_OF_THE_PHOENIX)));
    }

    private static Arguments ThreeDifferentBooksCostBasePriceWith10PctDiscount() {
        return arguments("21.6", newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_GOBLET_OF_FIRE)));
    }

    private static Arguments TwoDifferentBooksCostBasePriceWith5PctDiscount() {
        return arguments("15.2", newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN)));
    }

    private static Arguments OneBookCostsBasePrice() {
        return arguments("8.0", newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS)));
    }

    private String formatDecimalTwoDigits(double priceOfBooks) {
        String priceOfBooksAsString = String.format("%s", priceOfBooks);
        if (priceOfBooksAsString.length() >= 5) {
            return priceOfBooksAsString.substring(0, 4);
        } return priceOfBooksAsString;
    }

}

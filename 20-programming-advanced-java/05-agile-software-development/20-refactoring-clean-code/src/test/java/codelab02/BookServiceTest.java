package codelab02;

import codelab02.domain.HarryPotterBook;
import codelab02.domain.HarryPotterBookTitle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
    }

    @Test
    void givenOneBook_whenCalculatingPrice_thenReturnBasePrice() {
        ArrayList<HarryPotterBook> selectedBooks = newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(8);
    }

    @Test
    void givenTwoDifferentBooks_whenCalculatingPrice_thenReturnPriceWith5pctDiscount() {
        ArrayList<HarryPotterBook> selectedBooks = newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(15.2);
    }

    @Test
    void givenThreeDifferentBooks_whenCalculatingPrice_thenReturnPriceWith10pctDiscount() {
        ArrayList<HarryPotterBook> selectedBooks = newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_GOBLET_OF_FIRE));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(21.6);
    }

    @Test
    void givenFourDifferentBooks_whenCalculatingPrice_thenReturnPriceWith20pctDiscount() {
        ArrayList<HarryPotterBook> selectedBooks = newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_GOBLET_OF_FIRE),
                new HarryPotterBook(HarryPotterBookTitle.THE_ORDER_OF_THE_PHOENIX));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(25.6);
    }

    @Test
    void givenFiveDifferentBooks_whenCalculatingPrice_thenReturnPriceWith25pctDiscount() {
        ArrayList<HarryPotterBook> selectedBooks = newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_GOBLET_OF_FIRE),
                new HarryPotterBook(HarryPotterBookTitle.THE_ORDER_OF_THE_PHOENIX),
                new HarryPotterBook(HarryPotterBookTitle.THE_PHILOSOPHERS_STONE));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(30);
    }

    @Test
    void givenTwoIdenticalBooks_whenCalculatingPrice_thenReturnBasePriceWithoutDiscount() {
        ArrayList<HarryPotterBook> selectedBooks = newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(16);
    }

    @Test
    void givenTwoTimesTheSameTwoDifferentBooks_whenCalculatingPrice_thenOnlyCalculateDiscountOnce() {
        ArrayList<HarryPotterBook> selectedBooks = newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(formatDecimalTwoDigits(priceOfBooks)).isEqualTo("31.2");
    }

    @Test
    void givenANumberOfBooks_whenCalculatingPrice_thenReturnCorrectPrice() {
        ArrayList<HarryPotterBook> selectedBooks = newArrayList(
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_CHAMBER_OF_SECRETS),
                new HarryPotterBook(HarryPotterBookTitle.THE_PHILOSOPHERS_STONE),
                new HarryPotterBook(HarryPotterBookTitle.THE_PHILOSOPHERS_STONE),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_PRISONER_OF_AZKABAN),
                new HarryPotterBook(HarryPotterBookTitle.THE_ORDER_OF_THE_PHOENIX),
                new HarryPotterBook(HarryPotterBookTitle.THE_GOBLET_OF_FIRE));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(54);
    }

    private String formatDecimalTwoDigits(double priceOfBooks) {
        return String.format("%s", priceOfBooks).substring(0, 4);
    }

}

package codelab02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class bookServiceTest {

    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
    }

    @Test
    void givenOneBook_whenCaculatingPrice_thenReturnBasePrice() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(8);
    }

    @Test
    void givenTwoDifferentBooks_whenCaculatingPrice_thenReturnPriceWith5pctDiscount() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PRISONER_OF_AZKABAN));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(15.2);
    }

    @Test
    void givenThreeDifferentBooks_whenCaculatingPrice_thenReturnPriceWith10pctDiscount() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_GOBLET_OF_FIRE));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(21.6);
    }

    @Test
    void givenFourDifferentBooks_whenCaculatingPrice_thenReturnPriceWith20pctDiscount() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_GOBLET_OF_FIRE),
                new Book(BookType.THE_ORDER_OF_THE_PHOENIX));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(25.6);
    }

    @Test
    void givenFiveDifferentBooks_whenCaculatingPrice_thenReturnPriceWith25pctDiscount() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_GOBLET_OF_FIRE),
                new Book(BookType.THE_ORDER_OF_THE_PHOENIX),
                new Book(BookType.THE_PHILOSOPHERS_STONE));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(30);
    }

    @Test
    void givenTwoIdenticalBooks_whenCaculatingPrice_thenReturnBasePriceWithoutDiscount() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_CHAMBER_OF_SECRETS));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(16);
    }

    @Test
    void givenTwoTimesTheSameTwoDifferentBooks_whenCaculatingPrice_thenOnlyCaculateDiscountOnce() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_PRISONER_OF_AZKABAN));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(formatDecimalTwoDigits(priceOfBooks)).isEqualTo("31.2");
    }

    @Test
    void givenANumberOfBooks_whenCaculatingPrice_thenReturnCorrectPrice() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PHILOSOPHERS_STONE),
                new Book(BookType.THE_PHILOSOPHERS_STONE),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_ORDER_OF_THE_PHOENIX),
                new Book(BookType.THE_GOBLET_OF_FIRE));

        double priceOfBooks = bookService.shop(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(54);
    }

    private String formatDecimalTwoDigits(double priceOfBooks) {
        return String.format("%s", priceOfBooks).substring(0, 4);
    }

}
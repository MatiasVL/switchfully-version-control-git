package codelab02;

/**
 * Read the README.md.
 * (the current code of this class is OK)
 */
public class HarryPotterBook {

    private final HarryPotterBookTitle titleOfBook;

    public HarryPotterBook(HarryPotterBookTitle titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    public HarryPotterBookTitle getTitleOfBook() {
        return titleOfBook;
    }

    @Override
    public String toString() {
        return titleOfBook.name().toLowerCase();
    }
}

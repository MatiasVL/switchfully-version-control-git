package codelab02;

public class Book {

    private BookType bookType;

    public Book(BookType bookType) {
        this.bookType = bookType;
    }

    public BookType getBookType() {
        return bookType;
    }
}

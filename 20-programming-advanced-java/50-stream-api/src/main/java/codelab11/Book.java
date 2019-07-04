package codelab11;

public class Book {

    private String title;
    private String content;
    private Author author;

    public Book(String title, String content, Author author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }
}

package codelab11;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Check the tests to see some example use-cases
 */
public class Library {

    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<String> get15OrLessUniqueSurnamesOf50YearOrOlderAuthorsOfBooks() {
        return books.stream()
                .filter(book -> book.getAuthor().getAge() >= 50)
                .limit(15)
                .map(book -> book.getAuthor().getSurname())
                .distinct()
                .collect(Collectors.toList());
    }

    public int getSumOfAgesOfAllFemaleAuthorsYoungerThan25() {
        return books.stream()
                .filter(book -> book.getAuthor().getGender().equals(Author.Gender.FEMALE))
                .filter(book -> book.getAuthor().getAge() < 25)
                .map(book -> book.getAuthor().getAge())
                .reduce(0, (age1, age2) -> age1 + age2);
    }

    public Map<Author, List<Book>> getBooksGroupedByAuthor() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }
}

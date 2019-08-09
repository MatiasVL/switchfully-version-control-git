package codelab11;

class LibraryTest {

    // Uncomment the tests when starting with this codelab.
    // Start by creating the Library,... classes so that the tests compile

    /*
    @Test
    void get15OrLessUniqueSurnamesOf50YearOrOlderAuthorsOfBooks() {
        Library library = new Library(Arrays.asList(
                new Book("Book1", "content1", new Author("Burtens1", "Burt1", 18, Author.Gender.MALE)),
                new Book("Booky", "contenty", new Author("Burtens1", "Anja", 20, Author.Gender.FEMALE)),
                new Book("Book2", "content2", new Author("Trulens1", "Truus1", 10, Author.Gender.FEMALE)),
                new Book("Book3", "content3", new Author("Burtens2", "Burt1", 58, Author.Gender.MALE)),
                new Book("Book4", "content4", new Author("Trulens2", "Truus2", 17, Author.Gender.FEMALE)),
                new Book("Book5", "content5", new Author("Trulens3", "Truus3", 28, Author.Gender.FEMALE)),
                new Book("Book6", "content6", new Author("Trulens4", "Truus4", 60, Author.Gender.FEMALE))
        ));

        List<String> result = library.get15OrLessUniqueSurnamesOf50YearOrOlderAuthorsOfBooks();

        Assertions.assertThat(result).containsExactlyInAnyOrder("Burt1", "Truus4");
    }

    @Test
    void getSumOfAgesOfAllFemaleAuthorsYoungerThan25() {
        Library library = new Library(Arrays.asList(
                new Book("Book1", "content1", new Author("Burtens1", "Burt1", 18, Author.Gender.MALE)),
                new Book("Booky", "contenty", new Author("Burtens1", "Anja", 20, Author.Gender.FEMALE)),
                new Book("Book2", "content2", new Author("Trulens1", "Truus1", 10, Author.Gender.FEMALE)),
                new Book("Book3", "content3", new Author("Burtens2", "Burt1", 58, Author.Gender.MALE)),
                new Book("Book4", "content4", new Author("Trulens2", "Truus2", 17, Author.Gender.FEMALE)),
                new Book("Book5", "content5", new Author("Trulens3", "Truus3", 28, Author.Gender.FEMALE)),
                new Book("Book6", "content6", new Author("Trulens4", "Truus4", 60, Author.Gender.FEMALE))
        ));

        int sum = library.getSumOfAgesOfAllFemaleAuthorsYoungerThan25();

        Assertions.assertThat(sum).isEqualTo(47);
    }

    @Test
    void getBooksGroupedByAuthor() {
        Author authorBurtens = new Author("Burtens1", "Burt1", 18, Author.Gender.MALE);
        Author authorTrulens = new Author("Trulens1", "Truus1", 10, Author.Gender.FEMALE);
        Book book1 = new Book("Book1", "content1", authorBurtens);
        Book book2 = new Book("Book2", "content2", authorBurtens);
        Book book3 = new Book("Book3", "content3", authorBurtens);
        Book book4 = new Book("Book4", "content4", authorTrulens);
        Library library = new Library(Arrays.asList(book1, book2, book3, book4));

        Map<Author, List<Book>> booksGroupedByAuthor = library.getBooksGroupedByAuthor();

        Assertions.assertThat(booksGroupedByAuthor).hasSize(2);
        Assertions.assertThat(booksGroupedByAuthor.get(authorBurtens)).containsExactlyInAnyOrder(book1, book2, book3);
        Assertions.assertThat(booksGroupedByAuthor.get(authorTrulens)).containsExactlyInAnyOrder(book4);
    }
    */

}

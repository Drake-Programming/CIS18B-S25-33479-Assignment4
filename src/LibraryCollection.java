import java.util.*;

public class LibraryCollection {
    // TODO Maintains a Map<String, List<Book>> where the key is the genre.
    // TODO Implements Iterable<Book> to iterate only through available books in a given genre.
    // TODO Provides a method getGenreIterator(String genre) that returns an iterator for that genre.
    // TODO Demonstrates the Iterator Design Pattern.

    private Map<String, List<Book>> genreMap;

    public LibraryCollection() {
        genreMap = new HashMap<>();
    }

    public void addBook(Book book) {
        // TODO: Add books to genreMap
    }

    public Iterator<Book> getGenreIterator(String genre) {
        // TODO: Return custom iterator for available books in that genre
        return null;
    }

    // TODO: Add methods to search and return books
}

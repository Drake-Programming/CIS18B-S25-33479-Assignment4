import java.util.*;

/**
 * Iterates through a list of books, filtering by a specific genre and availability.
 */
public class GenreIterator implements BookIterator {

    /** The genre used to filter books */
    private String genre;

    /** Current position within the book list */
    private int currentPosition;

    /** List of books within the specified genre */
    private List<Book> books = new ArrayList<>();

    /**
     * Constructs a GenreIterator to iterate through books of a specific genre.
     *
     * @param genre the genre to filter books by
     * @param books the list of books to iterate over
     */
    public GenreIterator(String genre, List<Book> books) {
        this.genre = genre;
        this.currentPosition = 0;
        this.books = books;
    }

    /**
     * Checks if there are more available books in the genre to iterate over.
     *
     * @return true if there's at least one more available book, false otherwise
     */
    @Override
    public boolean hasNext() {
        return currentPosition < books.size();
    }

    /**
     * Retrieves the next available book in the genre.
     * If the next book is unavailable, the iterator recursively searches for the next available book.
     *
     * @return the next available Book object or null if no more available books exist
     */
    @Override
    public Book next() {
        if (!hasNext()) {
            return null;
        }
        Book book = books.get(currentPosition);
        currentPosition++;

        // Skip unavailable books and continue searching
        if (!book.isAvailable()) {
            return this.next();
        }

        return book;
    }

    /**
     * Resets the iterator to the beginning of the list.
     */
    public void reset() {
        currentPosition = 0;
    }
}

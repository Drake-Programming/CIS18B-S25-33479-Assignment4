import java.util.*;

/**
 * Represents a collection of books organized by genres.
 * Provides functionality to add books, search books, check them out, and return them.
 */
public class LibraryCollection {

    // Map storing books categorized by genre
    private Map<String, List<Book>> genreMap;

    // Map tracking books checked out by each user
    private Map<String, List<Book>> booksCheckout;

    /**
     * Constructs an empty LibraryCollection with initialized genre and checkout maps.
     */
    public LibraryCollection() {
        genreMap = new HashMap<>();
        booksCheckout = new HashMap<>();
    }

    /**
     * Retrieves a list of all genre names currently in the collection.
     *
     * @return List of genre names
     */
    public List<String> getGenreKeys() {
        return new ArrayList<>(genreMap.keySet());
    }

    /**
     * Adds a book to the collection under its genre.
     *
     * @param book The book to be added
     */
    public void addBook(Book book) {
        genreMap.computeIfAbsent(book.getGenre(), g -> new ArrayList<>()).add(book);
    }

    /**
     * Provides an iterator to traverse books of a specific genre.
     *
     * @param genre The genre to iterate over
     * @return GenreIterator for the specified genre
     */
    public GenreIterator getGenreIterator(String genre) {
        return new GenreIterator(genre, genreMap.getOrDefault(genre, Collections.emptyList()));
    }

    /**
     * Searches for a book by its title across all genres.
     *
     * @param title Title of the book to search for
     * @return The book if found
     * @throws BookNotFoundException if no book with the specified title is found
     */
    public Book searchBook(String title) throws BookNotFoundException {
        for (List<Book> list : genreMap.values()) {
            for (Book book : list) {
                if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    return book;
                }
            }
        }
        throw new BookNotFoundException(title + " was not found");
    }

    /**
     * Returns a checked-out book back to the library.
     *
     * @param book The book to be returned
     * @param user The user returning the book
     */
    public void returnBook(Book book, LibraryUser user) {
        booksCheckout.get(user.getUsername()).remove(book);
        book.returnBook();
        System.out.println("Book " + book.getTitle() + " has been returned by " + user.getUsername());
    }

    /**
     * Checks out a book for a user.
     *
     * @param book The book to be checked out
     * @param user The user checking out the book
     */
    public void checkoutBook(Book book, LibraryUser user) {
        booksCheckout.computeIfAbsent(user.getUsername(), g -> new ArrayList<>()).add(book);
        book.checkout();
        System.out.println("Book " + book.getTitle() + " has been checked out by " + user.getUsername());
    }
}
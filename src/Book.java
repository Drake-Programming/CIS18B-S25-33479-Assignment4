/**
 * Represents a book with attributes like title, author, genre, and availability status.
 */
public class Book {
    // Book title
    private final String title;
    // Book author
    private final String author;
    // Book genre (category)
    private final String genre;
    // Availability status of the book
    private boolean isAvailable;

    /**
     * Constructs a Book object with specified title, author, genre, and availability.
     *
     * @param title Title of the book
     * @param author Author of the book
     * @param genre Genre/category of the book
     * @param isAvailable Availability status (true if available, false otherwise)
     */
    public Book(String title, String author, String genre, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    /**
     * Constructs a Book object with specified title, author, and genre.
     * Sets the availability status to true by default.
     *
     * @param title Title of the book
     * @param author Author of the book
     * @param genre Genre/category of the book
     */
    public Book(String title, String author, String genre) {
        this(title, author, genre, true);
    }

    /**
     * Checks if the book is currently available.
     *
     * @return true if available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Marks the book as checked out if it's available.
     * Throws an exception if the book is already checked out.
     *
     * @throws BookNotAvailableException if the book is not available
     */
    public void checkout() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("Book is not available");
        }
        isAvailable = false;
    }

    /**
     * Returns the book, marking it as available again.
     * Does nothing if the book is already marked as available.
     */
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
        }
    }

    /**
     * Retrieves the genre of the book.
     *
     * @return the genre of the book
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Retrieves the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return formatted string containing title, author, and genre
     */
    @Override
    public String toString() {
        return title + " by " + author + " (" + genre + ")";
    }
}

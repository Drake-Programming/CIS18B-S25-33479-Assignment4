/**
 * Exception thrown when a book is requested but cannot be found.
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}

/**
 * Represents an iterator specifically for Book objects.
 * Provides methods to traverse through a collection of books.
 */
public interface BookIterator {

    /**
     * Checks if there are more books to iterate over.
     *
     * @return true if there is at least one more book, false otherwise
     */
    boolean hasNext();

    /**
     * Retrieves the next book in the collection.
     *
     * @return the next Book object
     */
    Book next();

    /**
     * Resets the iterator to the starting position.
     */
    void reset();
}
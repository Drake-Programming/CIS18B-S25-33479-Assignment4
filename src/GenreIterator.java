import java.util.*;

public class GenreIterator implements BookIterator {
    private String genre;
    private int currentPosition;
    private List<Book> books = new ArrayList<>();

    public GenreIterator(String genre, List<Book> books) {
        this.genre = genre;
        this.currentPosition = 0;
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < books.size();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            return null;
        }
        Book book = books.get(currentPosition);
        currentPosition++;

        if (!book.isAvailable()) {
            return this.next();
        }
        return book;
    }

    public void reset() {
        currentPosition = 0;
    }
}

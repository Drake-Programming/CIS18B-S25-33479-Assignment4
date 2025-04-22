import java.util.*;

public class LibraryCollection {
    // TODO Implements Iterable<Book> to iterate only through available books in a given genre.
    // TODO Provides a method getGenreIterator(String genre) that returns an iterator for that genre.
    // TODO Demonstrates the Iterator Design Pattern.

    // TODO: If book.getGenre is in genreMap, if book.getTitle is not in list, add book to list
    // TODO: if book.getGenre is not in genreMap, add book to a new list, then add list to map

    private Map<String, List<Book>> genreMap;

    private Map<String, List<Book>> booksCheckout;

    public LibraryCollection() {
        genreMap = new HashMap<>();
        booksCheckout = new HashMap<>();
    }


    public List<String> getGenreKeys() {
        return new ArrayList<>(genreMap.keySet());
    }

    public void addBook(Book book) {
        genreMap.computeIfAbsent(book.getGenre(), g -> new ArrayList<>())
                .add(book);
    }

    public GenreIterator getGenreIterator(String genre) {

        return new GenreIterator(genre, genreMap.getOrDefault(genre, Collections.emptyList()));
    }

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

    public void returnBook(Book book, LibraryUser user) {
        booksCheckout.get(user.getUsername()).remove(book);
        book.returnBook();
        System.out.println("Book " + book.getTitle() + " has been returned by " + user.getUsername());
    }

    public void checkoutBook(Book book, LibraryUser user) {
        booksCheckout.computeIfAbsent(user.getUsername(), g -> new ArrayList<>())
                .add(book);
        book.checkout();
        System.out.println("Book " + book.getTitle() + " has been checked out by " + user.getUsername());
    }
}

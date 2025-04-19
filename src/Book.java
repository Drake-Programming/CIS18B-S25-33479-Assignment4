public class Book {
    private final String title;
    private final String author;
    private final String genre;
    private boolean isAvailable;

    public Book(String title, String author, String genre, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public Book(String title, String author, String genre) {
        this(title, author, genre, true);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkout() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("Book is not available");
        }

        isAvailable = false;
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
        }
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title + " by " + author + " (" + genre + ")";
    }
}

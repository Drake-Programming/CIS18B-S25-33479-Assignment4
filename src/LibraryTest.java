import java.util.List;
import java.util.Scanner;

/**
 * Provides a test program demonstrating the use of LibraryCollection, LibraryUser,
 * and various library operations such as searching, checking out, and returning books.
 */
public class LibraryTest {

    /**
     * Main method to run the library application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LibraryCollection library = new LibraryCollection();
        List<Book> bookSeed = LibrarySeed.createSampleBooks();
        boolean programRunning = true;
        LibraryUser libraryUser = new LibraryUser();
        int choice;
        String title;
        String genre;
        Book userBook;
        GenreIterator gIterator;

        // Add predefined books to the library collection
        for (Book seedBook : bookSeed) {
            library.addBook(seedBook);
        }

        // User registration
        System.out.print("Hello new user! Please enter your username: ");
        libraryUser.setUsername(scanner.next());

        System.out.println("\nAwesome! Hello, " + libraryUser.getUsername() + " welcome to the library!");

        try {
            do {
                System.out.println("\nPlease choose an option " + libraryUser.getUsername() + "\n\n" +
                        "1. Search Book by Title\n" +
                        "2. Search Book by Genre\n" +
                        "3. Return Book by Title\n" +
                        "4. Exit Program\n");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        scanner.nextLine(); // Consume leftover newline
                        System.out.print("Enter book title: ");
                        title = scanner.nextLine();

                        userBook = library.searchBook(title);
                        System.out.println("Would you like to checkout " + userBook.getTitle() + "?");
                        System.out.println("1. Yes\n2. No\n");
                        System.out.print("Enter your choice: ");

                        choice = scanner.nextInt();
                        if (choice == 1) {
                            library.checkoutBook(userBook, libraryUser);
                        }
                        break;
                    case 2:
                        System.out.println("Available genres:\n");
                        for (String bookGenre : library.getGenreKeys()) {
                            System.out.println("\t" + bookGenre);
                        }
                        System.out.print("\nEnter book genre: ");
                        genre = scanner.next();

                        System.out.println("List of books in genre:\n");
                        gIterator = library.getGenreIterator(genre);
                        while (gIterator.hasNext()) {
                            System.out.println("\t" + gIterator.next().getTitle());
                        }
                        break;
                    case 3:
                        scanner.nextLine(); // Consume leftover newline
                        System.out.print("Enter book you would like to return: ");
                        title = scanner.nextLine();
                        library.returnBook(library.searchBook(title), libraryUser);
                        break;

                    case 4:
                        programRunning = false;
                        System.out.println("Thank you for using the Library System!");
                        break;

                    default: // Handle invalid menu choices
                        System.out.println("Invalid choice, please select a valid option.");
                }

            } while (programRunning);

        } catch (java.util.InputMismatchException ime) {
            // Catch any unexpected input exceptions in the main loop
            System.out.println("\nInput only numeric values\n");

        } finally {
            // Ensure scanner resource is always closed to avoid resource leaks
            scanner.close();
        }
    }
}
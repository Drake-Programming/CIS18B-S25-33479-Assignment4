import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LibraryCollection library = new LibraryCollection();
        LibrarySeed seed = new LibrarySeed();
        List<Book> bookSeed = seed.createSampleBooks();
        boolean programRunning = true;
        LibraryUser libraryUser = new LibraryUser();
        int choice;
        String title;
        String genre;
        Book userBook;
        GenreIterator gIterator;

        for (Book seedBook : bookSeed) {
            library.addBook(seedBook);
        }

        System.out.print("Hello new user! Please enter your username: ");
        libraryUser.setUsername(scanner.next());

        System.out.println("\nAwesome! Hello, " + libraryUser.getUsername() + " welcome to the library!");

        try {
            do {
                System.out.println("\nPlease choose an option " + libraryUser.getUsername() +"\n\n" +
                        "1. Search Book by Title\n" +
                        "2. Search Book by Genre\n" +
                        "3. Return Book by Title\n" +
                        "4. Exit Program\n");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        try {
                            scanner.nextLine();
                            System.out.print("Enter book title: ");
                            title = scanner.nextLine();
                        } catch (java.util.InputMismatchException ime) {
                            System.out.println("\nInput only String values\n");
                            scanner.nextLine();
                            continue;
                        }

                        userBook = library.searchBook(title);
                        System.out.println("Would you like to checkout " + userBook.getTitle() + "?");
                        System.out.println("1. Yes\n2. No\n");
                        System.out.print("Enter your choice: ");

                        try {
                            choice = scanner.nextInt();
                        } catch (java.util.InputMismatchException ime) {
                            System.out.println("\nInput only numeric values\n");
                            scanner.nextLine();
                            break;
                        }
                        if (choice == 1) {
                            library.checkoutBook(userBook, libraryUser);
                        }
                        break;
                    case 2:
                        System.out.println("Available genres:\n");
                        for (String bookGenre: library.getGenreKeys()) {
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
                        System.out.print("Enter book you would like to return: ");
                        title = scanner.next();
                        library.returnBook(library.searchBook(title), libraryUser);
                        scanner.nextLine();
                        break;

                    case 4:
                        programRunning = false;
                        System.out.println("Thank you for using the Library System!");
                        break;

                    default: // Handle invalid menu choices
                        System.out.println("Invalid choice, please select 1, 2, or 3.");

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

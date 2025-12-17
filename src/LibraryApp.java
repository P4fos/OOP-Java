import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {

        while (true) {

            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> printAll();
                case 2 -> addBook();
                case 3 -> searchBook();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 7 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void printAll() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());

        Book b = new Book(title, author, year);
        books.add(b);
        System.out.println("Book added!");
    }

    private void searchBook() {
        System.out.print("Enter part of title: ");
        String part = scanner.nextLine().toLowerCase();

        books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(part))
                .forEach(System.out::println);
    }

    private void borrowBook() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Book b : books) {
            if (b.getId() == id) {
                if (b.isAvailable()) {
                    b.markAsBorrowed();
                    System.out.println("Book borrowed.");
                } else {
                    System.out.println("Already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void returnBook() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Book b : books) {
            if (b.getId() == id) {
                if (!b.isAvailable()) {
                    b.markAsReturned();
                    System.out.println("Returned.");
                } else {
                    System.out.println("Book is not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void deleteBook() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean removed = books.removeIf(b -> b.getId() == id);

        if (removed)
            System.out.println("Deleted");
        else
            System.out.println("Book not found");
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }
}

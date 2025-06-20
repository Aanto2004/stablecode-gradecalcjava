import java.util.*;

class Book {
    String title;
    boolean isIssued;

    public Book(String title) {
        this.title = title;
        this.isIssued = false;
    }
}

public class LibraryManagementSystem {
    private static List<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter book title to add: ");
        String title = scanner.nextLine();
        books.add(new Book(title));
        System.out.println("✅ Book added.");
    }

    public static void issueBook() {
        System.out.print("Enter book title to issue: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && !book.isIssued) {
                book.isIssued = true;
                System.out.println("✅ Book issued.");
                return;
            }
        }
        System.out.println("❌ Book not available or already issued.");
    }

    public static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.isIssued) {
                book.isIssued = false;
                System.out.println("✅ Book returned.");
                return;
            }
        }
        System.out.println("❌ Book not found or wasn't issued.");
    }

    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("📚 No books in the library.");
        } else {
            System.out.println("📖 Library Books:");
            for (Book book : books) {
                System.out.println("- " + book.title + " [" + (book.isIssued ? "Issued" : "Available") + "]");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    issueBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("👋 Exiting...");
                    return;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }
}

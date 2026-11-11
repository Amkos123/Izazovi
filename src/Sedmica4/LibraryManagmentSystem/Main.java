package Sedmica4.LibraryManagmentSystem;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try (BufferedReader reader = new BufferedReader(new FileReader("LibraryItems.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                String title = parts[1];
                String itemId = parts[2];
                boolean isAvailable = parts[3].equals("AVAILABLE");
                if (type.equals("BOOK")) {
                    String author = parts[4];
                    libraryItems.add(new Book(title, itemId,isAvailable ,author));
                } else if (type.equals("MAGAZINE")) {
                    int issueNumber = Integer.parseInt(parts[4]);
                    libraryItems.add(new Magazine(title, itemId,isAvailable ,issueNumber));
                } else if (type.equals("NEWSPAPER")) {
                    LocalDate publicationDate = LocalDate.parse(parts[4]);
                    libraryItems.add(new Newspaper(title, itemId, isAvailable, publicationDate));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        for (LibraryItem item : libraryItems) {
            item.getDetails();


        }
        do {
            System.out.println("\nChoose an option:\n1. Count items\n2. Search by ID\n3. Search by Title\n4. Borrow Item\n5. Return Item\n6. Write to file\n7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    countItems(libraryItems);
                    break;
                case 2:
                    System.out.print("Enter item ID: ");
                    String itemId = scanner.nextLine();
                    searchbyId(libraryItems, itemId);
                    break;
                case 3:
                    System.out.print("Enter item title: ");
                    String title = scanner.nextLine();
                    searchbyTitle(libraryItems, title);
                    break;
                case 4:
                    System.out.print("Enter item ID: ");
                    String borrowId = scanner.nextLine();
                    for (LibraryItem item : libraryItems) {
                        if (item.getItemId().equals(borrowId)) {
                            item.borrowItem();
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter item ID: ");
                    String returnId = scanner.nextLine();
                    for (LibraryItem item : libraryItems) {
                        if (item.getItemId().equals(returnId)) {
                            item.returnItem();
                            break;
                        }
                    }
                    break;
                case 6:
                    writeToFile(libraryItems, "LibraryItems.txt");
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (true);
    }

    public static void countItems(ArrayList<LibraryItem> libraryItems) {
        int totalmagazines = 0;
        int totalbooks = 0;
        int totalnewspapers = 0;

        for (LibraryItem item : libraryItems) {
            if (item instanceof Magazine) {
                totalmagazines++;
            } else if (item instanceof Book) {
                totalbooks++;
            } else if (item instanceof Newspaper) {
                totalnewspapers++;
            }
        }
        System.out.println("Total Magazines: " + totalmagazines);
        System.out.println("Total Books: " + totalbooks);
        System.out.println("Total Newspapers: " + totalnewspapers);
    }

  public static void searchbyId(ArrayList<LibraryItem> libraryItems, String itemId) {
        for (LibraryItem item : libraryItems) {
            if (item.getItemId().equals(itemId)) {
                item.getDetails();
                return;
            }
        }
        System.out.println("Item with ID " + itemId + " not found.");

    }
    public static void  searchbyTitle(ArrayList<LibraryItem> libraryItems, String title) {
        for (LibraryItem item : libraryItems) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                item.getDetails();
                return;
            }
        }
        System.out.println("Item with title " + title + " not found.");
    }
    public static void writeToFile(ArrayList<LibraryItem> libraryItems, String filename) {
        try (FileWriter writer = new FileWriter("LibraryItems.txt")) {
            for (LibraryItem item : libraryItems) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    writer.write("BOOK," + book.getTitle() + "," + book.getItemId() + "," + (book.isAvailable() ? "AVAILABLE" : "UNAVAILABLE") + "," + book.getAuthor() + "\n");
                } else if (item instanceof Magazine) {
                    Magazine magazine = (Magazine) item;
                    writer.write("MAGAZINE," + magazine.getTitle() + "," + magazine.getItemId() + "," + (magazine.isAvailable() ? "AVAILABLE" : "UNAVAILABLE") + "," + magazine.getIssueNumber() + "\n");
                } else if (item instanceof Newspaper) {
                    Newspaper newspaper = (Newspaper) item;
                    writer.write("NEWSPAPER," + newspaper.getTitle() + "," + newspaper.getItemId() + "," + (newspaper.isAvailable() ? "AVAILABLE" : "UNAVAILABLE") + "," + newspaper.getPublicationDate() + "\n");
                }
                System.out.println("Library items written to file successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
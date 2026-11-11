package Sedmica4.LibraryManagmentSystem;
import java.time.LocalDate;
public class Newspaper extends LibraryItem {
    private LocalDate publicationDate;

    public Newspaper(String title, String itemId,boolean isAvailable, LocalDate publicationDate) {
        super(title, itemId,isAvailable);
        this.publicationDate = publicationDate;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    @Override
    public void getDetails() {
        System.out.println("Title: " + getTitle() + ", Item ID: " + getItemId() + ", Publication Date: " + publicationDate + ", Available: " + isAvailable());
    }
}

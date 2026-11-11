package Sedmica4.LibraryManagmentSystem;

public class Book extends LibraryItem {
    private String author;


    public Book(String title, String itemId,boolean isAvailable, String author) {
        super(title, itemId, isAvailable);
        this.author = author;

    }

    public String getAuthor() {
        return author;
    }


    @Override
    public void getDetails() {
        System.out.println("Title: " + getTitle() + ", Item ID: " + getItemId() + ", Author: " + author + ", Available: " + isAvailable());
    }
}

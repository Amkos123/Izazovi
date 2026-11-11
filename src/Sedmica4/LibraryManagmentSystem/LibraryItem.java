package Sedmica4.LibraryManagmentSystem;

public class LibraryItem {
   private String title;
    private String itemId;
    private boolean isAvailable;

    public LibraryItem(String title, String itemId ,boolean isAvailable) {
        this.title = title;
        this.itemId = itemId;
        this.isAvailable = isAvailable;
    }



    public String getTitle() {
        return title;
    }



    public String getItemId() {
        return itemId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void borrowItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Item borrowed successfully.");
        } else {
            System.out.println("Item is not available for borrowing.");
        }
    }
    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Item returned successfully.");
        } else {
            System.out.println("Item was not borrowed.");
        }
    }

    public void getDetails() {
        System.out.println("Title: " + title + ", Item ID: " + itemId + ", Available: " + isAvailable);
    }
}

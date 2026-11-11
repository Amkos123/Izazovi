package Sedmica4.LibraryManagmentSystem;

public class  Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, String itemId,boolean isAvailable, int issueNumber) {
        super(title, itemId, isAvailable);
        this.issueNumber = issueNumber;

    }


    public int getIssueNumber() {
        return issueNumber;
    }
@Override
    public void getDetails() {
        System.out.println("Title: " + getTitle() + ", Item ID: " + getItemId() + ", Issue Number: " + issueNumber + ", Available: " + isAvailable());
    }
}

package Design2;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        isIssued = false;
    }

    void issueBook() {
        if(isIssued) IO.println("Book is already issued");
        else {
            isIssued = true;
            IO.println("Book issued");
        }
    }

    void returnBook() {
        if(!isIssued) IO.println("Book is not issued");
        else {
            isIssued = false;
            IO.println("Book returned");
        }
    }
}

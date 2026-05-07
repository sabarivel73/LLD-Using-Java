package Design2;

public class User {
    private int UserId;
    private String name;

    public User() {}

    public void borrowBook(Book b) {
        b.issueBook();
    }

    public void returnBook(Book b) {
        b.returnBook();
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

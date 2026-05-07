package Design2;

public class Main {
    public static void main(String[] args) {
        Book b = new Book(1,"Book1","Book1");
        User u1 = new User();
        u1.setUserId(1);
        u1.setName("User1");
        u1.borrowBook(b);
        u1.returnBook(b);
        User u2 = new User();
        u2.setUserId(2);
        u2.setName("User2");
        u2.borrowBook(b);
    }
}

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {
    private User user;
    private List<User>user_value;
    private Scanner scanner;
    private Console console;

    public Register() {
        user_value = new ArrayList<>();
        scanner = new Scanner(System.in);
        console = System.console();
    }

    public void register()
    {
        System.out.print("Enter the name : ");
        String name = scanner.next();
        System.out.print("Enter the age : ");
        int age = scanner.nextInt();
        System.out.print("Enter the email : ");
        String email = scanner.next();
        System.out.print("Enter the password : ");
        char[] pass = console.readPassword();
        String password = new String(pass);
        User user = new User(name,age,email,password);
        user_value.add(user);
        System.out.println("User registered");
        System.out.println();
    }
}

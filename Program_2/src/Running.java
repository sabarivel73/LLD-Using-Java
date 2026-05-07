import java.util.Scanner;

public class Running {
    private Scanner scanner;
    private Register register;
    public Running()
    {
        scanner = new Scanner(System.in);
        register = new Register();
    }
   public void logs()
   {
       System.out.println();
       System.out.println("**** Welcome to Our Application ****");
       int value;
       while(true) {
           System.out.println("Kingly login to Continue in our application");
           System.out.print("1.Login\n" + "2.Create User\n" + "3.Exit -> ");
           value = scanner.nextInt();
           if (value == 1) {
                break;
           } else if (value == 2) {
                register.register();
           } else if (value == 3) {
               System.out.println("Thanks For Using Our Application");
               break;
           }
           else
           {
               System.out.println("kindly enter the valid input");
           }
       }
   }
}

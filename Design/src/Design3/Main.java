package Design3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static DateTimeFormatter value = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");

    static void bike(Scanner scanner, Details d1, int i, int j, int k) {
        IO.print("Enter your bike number : ");
        String num = scanner.nextLine();
        Details.Bike b1 = d1.new Bike(i, j, k);
        VB value = new VB();
        value.setVehicle(b1);
        Details.value.put(num, value);
        print(num, value.getVehicle());
        IO.print("\n");
    }

    static void car(Scanner scanner, Details d1, int i, int j, int k) {
        IO.print("Enter your car number : ");
        String num = scanner.nextLine();
        Details.Car c1 = d1.new Car(i, j, k);
        VB value = new VB();
        value.setVehicle(c1);
        Details.value.put(num, value);
        print(num, value.getVehicle());
        IO.print("\n");
    }

    static void truck(Scanner scanner, Details d1, int i, int j, int k) {
        IO.print("Enter your truck number : ");
        String num = scanner.nextLine();
        Details.Truck t1 = d1.new Truck(i, j, k);
        VB value = new VB();
        value.setVehicle(t1);
        Details.value.put(num, value);
        print(num, value.getVehicle());
        IO.print("\n");
    }

    static void print(String num, Vehicle vd) {
        IO.println("\n" + num + " Vehicle details : ");
        IO.println("Parking Floor : " + (vd.getFloor()+1));
        IO.println("Starting Column : " + (vd.getStart()+1));
        IO.println("Ending Column : " + (vd.getEnd()+1));
        IO.println("In Time : " + vd.getInTime().format(value));
    }

    static void message() {
        IO.println("Sorry currently we don't have enough space to park your vehicle, please book your slot after some time\n");
    }

    static void start(Scanner scanner, Details d1) {
        IO.print("Select the vehicle type based on the list\n");
        IO.print("""
                1.Bike
                2.Car
                3.Truck
                """);
        IO.print("Choose your vehicle type : ");
        Vector<Vector<Boolean>>f;
        boolean c = false;
        int value = scanner.nextInt();scanner.nextLine();
        switch (value) {
            case 1:
                f = Floors.getFloors();
                for(int i=0;i<5 && !c;i++) {
                    for(int j=0;j<20;j++) {
                        if(!f.get(i).get(j)) {
                            f.get(i).set(j,true);
                            bike(scanner, d1, i, j, j);
                            c = true;
                            break;
                        }
                    }
                }
                if(!c) message();
                break;
            case 2:
                f = Floors.getFloors();
                for(int i=0;i<5 && !c;i++) {
                    int j = 0;
                    while(j<20) {
                        if(!f.get(i).get(j)) {
                            if (j + 2 < 20 && !f.get(i).get(j + 1) && !f.get(i).get(j + 2)) {
                                f.get(i).set(j, true);
                                f.get(i).set(j + 1, true);
                                f.get(i).set(j + 2, true);
                                car(scanner, d1, i, j, j+2);
                                c = true;
                                break;
                            }
                            else j += 3;
                        }
                        else j++;
                    }
                }
                if(!c) message();
                break;
            case 3:
                f = Floors.getFloors();
                for(int i=0;i<5 && !c;i++) {
                    int j = 0;
                    while(j<20) {
                        if(!f.get(i).get(j)) {
                            if (j + 4 < 20 && !f.get(i).get(j + 1) && !f.get(i).get(j + 2) && !f.get(i).get(j + 3) && !f.get(i).get(j + 4)) {
                                f.get(i).set(j, true);
                                f.get(i).set(j + 1, true);
                                f.get(i).set(j + 2, true);
                                f.get(i).set(j + 3, true);
                                f.get(i).set(j + 4, true);
                                truck(scanner, d1, i, j, j+4);
                                c = true;
                                break;
                            }
                            else j += 5;
                        }
                        else j++;
                    }
                }
                if(!c) message();
                break;
        }
    }

    static void view(Scanner scanner, DateTimeFormatter value) {
        IO.print("Please enter your vehicle number : ");
        String num = scanner.nextLine();
        if(!Details.value.containsKey(num)) {
            IO.print("\nThis vehicle number was not found, please enter correct vehicle number\n");
            return;
        }
        VB vd = Details.value.get(num);
        print(num, vd.getVehicle());
        IO.print("\n");
    }

    static Boolean bill(Scanner scanner, DateTimeFormatter value) {
        IO.print("Please enter your vehicle number : ");
        String num = scanner.nextLine();
        if(!Details.value.containsKey(num)) {
            IO.print("\nThis vehicle number was not found, please enter correct vehicle number\n");
            return false;
        }
        LocalDateTime out = LocalDateTime.now();
        VB vd = Details.value.get(num);
        vd.getVehicle().setOutTime(out);
        print(num, vd.getVehicle());
        IO.println("Out Time : " + vd.getVehicle().getOutTime().format(value));
        IO.print("\n");
        long totalTime = Duration.between(vd.getVehicle().getInTime(), vd.getVehicle().getOutTime()).toMinutes();
        Bill bill = new Bill();
        bill.setTotalTime(totalTime);
        bill.setStatus(false);
        IO.print("\n Bill for this vehicle : " + num + "\n");
        IO.print("Total Time in form of Minutes : " + bill.getTotalAmount() + "\n");
        return true;
    }

    static void main() {
        Floors.init();
        Details d1 = new Details();
        Scanner scanner = new Scanner(System.in);
        IO.println("Welcome choose any functions base on the list :");
        while(true) {
            IO.print("""
                     1.Start the application
                     2.View your parked vehicle details
                     3.Check-out vehicle and generate bill
                     4.Exit
                     """);
            IO.print("Enter the function number : ");
            int v = scanner.nextInt();
            scanner.nextLine();
            if (v == 1) start(scanner, d1);
            else if(v == 2) view(scanner, value);
            else if(v == 3) {
                if(bill(scanner, value)) {
                    IO.print("\nThanks for you time, have a great day");
                    break;
                }
            }
            else {
                IO.print("\nThanks for you time, have a great day");
                break;
            }
        }
        IO.print("\n");
        IO.print("\n\n");
    }
}
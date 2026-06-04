package Design3;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class Details {

    public static TreeMap<String, VB> value;

    public Details() { value = new TreeMap<>(); }

    public class Bike extends Vehicle {
        public Bike(Integer floor, Integer start, Integer end) {
            super(1, floor, start, end, LocalDateTime.now());
        }
    }

    public class Car extends Vehicle {
        public Car(Integer floor, Integer start, Integer end) {
            super(3, floor, start, end, LocalDateTime.now());
        }
    }

    public class Truck extends Vehicle {
        public Truck(Integer floor, Integer start, Integer end) {
            super(5, floor, start, end, LocalDateTime.now());
        }
    }
}

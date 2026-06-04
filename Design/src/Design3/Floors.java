package Design3;

import java.util.Collections;
import java.util.Vector;

public class Floors {

    private static Vector<Vector<Boolean>>floors;

    public static void init() {
        floors = new Vector<>(5);
        for(int i=0;i<5;i++) {
            floors.add(new Vector<>(Collections.nCopies(20,false)));
        }
    }

    public static Vector<Vector<Boolean>> getFloors() {
        return floors;
    }

}

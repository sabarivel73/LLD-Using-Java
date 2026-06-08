package Design3;

import java.time.Duration;
import java.time.LocalDateTime;

public class Vehicle {

    private String vehicle;
    private Integer Size;
    private Integer floor;
    private Integer start;
    private Integer end;
    private LocalDateTime inTime;
    private LocalDateTime outTime;

    Vehicle(String vehicle, Integer size, Integer floor, Integer start, Integer end, LocalDateTime inTime) {
        this.vehicle = vehicle;
        this.Size = size;
        this.floor = floor;
        this.start = start;
        this.end = end;
        this.inTime = inTime;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public Integer getSize() {
        return Size;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public Integer getFloor() {
        return floor;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public String getVehicle() { return vehicle; }

    public long calculateTime(LocalDateTime appOutTime) {
         return Duration.between(inTime, appOutTime).toMinutes();
    }
}

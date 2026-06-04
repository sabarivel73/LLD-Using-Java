package Design3;

import java.time.LocalDateTime;

public class Vehicle {

    private Integer Size;
    private Integer floor;
    private Integer start;
    private Integer end;
    private LocalDateTime inTime;
    private LocalDateTime outTime;

    Vehicle(Integer size, Integer floor, Integer start, Integer end, LocalDateTime inTime) {
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
}

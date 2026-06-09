package Design3;

public class Bill {
    private long totalTime;
    private long totalAmount;
    private Boolean status;

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) { this.totalTime = totalTime; }

    public long getTotalAmount() {
        return totalAmount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void calculateBill(Integer size) {
        totalAmount = Math.round(totalTime * 0.0208333333);
        totalAmount *= size;
    }
}

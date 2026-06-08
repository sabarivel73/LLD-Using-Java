package Design3;

public class Payment {
    private String paymentType;
    private int transactionId;
    private Boolean statueforTID;

    public Payment(String paymentType) {
        this.paymentType = paymentType;
        transactionId = (int) (Math.random()*10000) + 1000;
        statueforTID = true;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public Boolean getStatueforTID() {
        return statueforTID;
    }
}

package mainpkg.lawfirm.rakin;

public class foPaymentRequest {
    private String requestId;
    private String clientName;
    private double amount;
    private String status;

    public foPaymentRequest(String requestId, String clientName, double amount) {
        this.requestId = requestId;
        this.clientName = clientName;
        this.amount = amount;
        this.status = "Pending"; // default status
    }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

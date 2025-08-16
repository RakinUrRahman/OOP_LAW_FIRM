package mainpkg.lawfirm.rakin;

import java.io.Serializable;

public class ClientPayment implements Serializable {

    private String caseRef;
    private String paymentDate;
    private double amount;
    private String status;
    private String clientName;
    private String paymentMethod;

    public ClientPayment(String caseRef, String paymentDate, double amount, String status, String clientName, String paymentMethod) {
        this.caseRef = caseRef;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.status = status;
        this.clientName = clientName;
        this.paymentMethod = paymentMethod;
    }

    public String getCaseRef() {
        return caseRef;
    }

    public void setCaseRef(String caseRef) {
        this.caseRef = caseRef;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "ClientPayment{" +
                "caseRef='" + caseRef + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", clientName='" + clientName + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}

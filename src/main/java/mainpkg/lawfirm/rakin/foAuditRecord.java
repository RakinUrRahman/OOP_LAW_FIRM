package mainpkg.lawfirm.rakin;

import java.io.Serializable;

public class foAuditRecord implements Serializable{


    private  String errorId;
    private  String clientId;
    private  String description;
    private  Double amount;
    private  String status;

    public foAuditRecord(String errorId, String clientId, String description, Double amount, String status) {
        this.errorId = errorId;
        this.clientId = clientId;
        this.description = description;
        this.amount = amount;
        this.status = status;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "foAuditRecord{" +
                "errorId='" + errorId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}



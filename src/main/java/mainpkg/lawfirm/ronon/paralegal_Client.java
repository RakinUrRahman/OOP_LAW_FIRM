package mainpkg.lawfirm.ronon;

public class paralegal_Client {
    private String clientId;
    private String name;
    private String email;
    private String phone;
    private String caseId;
    private String status;

    public paralegal_Client(String clientId, String name, String email, String phone, String caseId, String status) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.caseId = caseId;
        this.status = status;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", caseId='" + caseId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}


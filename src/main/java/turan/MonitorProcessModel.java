package turan;

public class MonitorProcessModel {
    private String caseId;
    private String caseName;
    private String status;
    private String assignedTo;

    public MonitorProcessModel(String caseId, String caseName, String status, String assignedTo) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "MonitorProcessModel{" +
                "caseId='" + caseId + '\'' +
                ", caseName='" + caseName + '\'' +
                ", status='" + status + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                '}';
    }
}

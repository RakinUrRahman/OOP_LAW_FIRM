package mainpkg.lawfirm.turan;

public class criticalcasetagModel {
    private String caseId;
    private String caseName;
    private String status;
    private String priority;

    public criticalcasetagModel(String caseId, String caseName, String status, String priority) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.status = status;
        this.priority = priority;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "criticalcasetagModel{" +
                "caseId='" + caseId + '\'' +
                ", caseName='" + caseName + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}

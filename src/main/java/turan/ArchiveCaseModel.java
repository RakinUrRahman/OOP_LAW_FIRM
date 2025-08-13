package turan;

public class ArchiveCaseModel {
    private String caseId;
    private String caseName;
    private String status;
    private String completionDate;

    public ArchiveCaseModel(String caseId, String caseName, String status, String completionDate) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.status = status;
        this.completionDate = completionDate;
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

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public String toString() {
        return "ArchiveCaseModel{" +
                "caseId='" + caseId + '\'' +
                ", caseName='" + caseName + '\'' +
                ", status='" + status + '\'' +
                ", completionDate='" + completionDate + '\'' +
                '}';
    }
}

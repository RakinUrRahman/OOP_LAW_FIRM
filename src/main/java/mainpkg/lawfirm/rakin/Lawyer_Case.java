package mainpkg.lawfirm.rakin;

public class Lawyer_Case {
    private String caseId;
    private String caseName;
    private String clientName;
    private String caseType;
    private String description;
    private String lawyer;
    private String status;

    public Lawyer_Case(String caseName, String clientName, String caseType, String description, String lawyer) {
        this.caseId = generateCaseId();
        this.caseName = caseName;
        this.clientName = clientName;
        this.caseType = caseType;
        this.description = description;
        this.lawyer = lawyer;
        this.status = "Pending";
    }

    private String generateCaseId() {
            return "CASE-" + System.currentTimeMillis();
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLawyer() {
        return lawyer;
    }

    public void setLawyer(String lawyer) {
        this.lawyer = lawyer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "caseId='" + caseId + '\n' +
                ", caseName='" + caseName + '\n' +
                ", clientName='" + clientName + '\n' +
                ", caseType='" + caseType + '\n' +
                ", description='" + description + '\n' +
                ", lawyer='" + lawyer + '\n' +
                ", status='" + status + '\n' +
                '}';
    }
}

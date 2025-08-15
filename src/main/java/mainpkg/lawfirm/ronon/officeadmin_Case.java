package mainpkg.lawfirm.ronon;

public class officeadmin_Case {
    private String caseId;
    private String title;
    private String status;

    public officeadmin_Case(String caseId, String title) {
        this.caseId = caseId;
        this.title = title;
        this.status = status;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseId='" + caseId + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}


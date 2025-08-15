package mainpkg.lawfirm.ronon;

public class paralegal_CaseReport {
    private String caseId;
    private String reportType;
    private String includeSection;

    public paralegal_CaseReport(String caseId, String reportType, String includeSection) {
        this.caseId = caseId;
        this.reportType = reportType;
        this.includeSection = includeSection;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getIncludeSection() {
        return includeSection;
    }

    public void setIncludeSection(String includeSection) {
        this.includeSection = includeSection;
    }

    @Override
    public String toString() {
        return "CaseReport{" +
                "caseId='" + caseId + '\'' +
                ", reportType='" + reportType + '\'' +
                ", includeSection='" + includeSection + '\'' +
                '}';
    }
}


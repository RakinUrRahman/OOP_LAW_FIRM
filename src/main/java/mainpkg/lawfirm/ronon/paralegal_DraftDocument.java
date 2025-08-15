package mainpkg.lawfirm.ronon;

import java.time.LocalDate;

public class paralegal_DraftDocument {
    private String docType;
    private String clientName;
    private String caseId;
    private LocalDate date;
    private String terms;


    public paralegal_DraftDocument(String docType, String clientName, String caseId, LocalDate date, String terms) {
        this.docType = docType;
        this.clientName = clientName;
        this.caseId = caseId;
        this.date = date;
        this.terms = terms;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    @Override
    public String toString() {
        return "DraftDocument{" +
                "docType='" + docType + '\'' +
                ", clientName='" + clientName + '\'' +
                ", caseId='" + caseId + '\'' +
                ", date=" + date +
                ", terms='" + terms + '\'' +
                '}';
    }
}


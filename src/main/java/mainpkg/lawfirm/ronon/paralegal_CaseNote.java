package mainpkg.lawfirm.ronon;

import java.time.LocalDate;

public class paralegal_CaseNote {
    private String caseId;
    private LocalDate date;
    private String note;

    public paralegal_CaseNote(String caseId, LocalDate date, String note) {
        this.caseId = caseId;
        this.date = date;
        this.note = note;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "CaseNote{" +
                "caseId='" + caseId + '\'' +
                ", date=" + date +
                ", note='" + note + '\'' +
                '}';
    }
}


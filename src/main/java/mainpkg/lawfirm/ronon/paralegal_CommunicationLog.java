package mainpkg.lawfirm.ronon;

import java.time.LocalDate;

public class paralegal_CommunicationLog {
    private String name;
    private LocalDate date;
    private String time;
    private String caseType;
    private String communicationType;
    private String note;

    public paralegal_CommunicationLog(String name,String caseType,String communicationType, LocalDate date,String time,String note) {
        this.name = name;
        this.caseType = caseType;
        this.communicationType = communicationType;
        this.date = date;
        this.time = time;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCommunicationType() {
        return communicationType;
    }

    public void setCommunicationType(String communicationType) {
        this.communicationType = communicationType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "paralegal_CommunicationLog{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", caseType='" + caseType + '\'' +
                ", communicationType='" + communicationType + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}

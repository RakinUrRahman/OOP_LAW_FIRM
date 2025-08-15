package mainpkg.lawfirm.ronon;

import java.time.LocalDate;

public class paralegal_CourtEvent {
    private String eventType;
    private String title;
    private LocalDate date;
    private String time;
    private String caseId;
    private String note;

    public paralegal_CourtEvent(String eventType, String title, LocalDate date, String time, String caseId, String note) {
        this.eventType = eventType;
        this.title = title;
        this.date = date;
        this.time = time;
        this.caseId = caseId;
        this.note = note;
    }

    @Override
    public String toString() {
        return "CourtEvent{" +
                "eventType='" + eventType + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", caseId='" + caseId + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}


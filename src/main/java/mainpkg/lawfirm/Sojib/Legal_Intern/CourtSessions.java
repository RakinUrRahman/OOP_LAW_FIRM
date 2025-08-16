package mainpkg.lawfirm.Sojib.Legal_Intern;

import java.io.Serializable;
import java.time.LocalDate;

public class CourtSessions implements Serializable {
    private Integer sessionID;
    private String caseTitle;
    private String courtName;
    private LocalDate date;
    private String time;

    public CourtSessions(Integer sessionID, String caseTitle, String courtName, LocalDate date, String time) {
        this.sessionID = sessionID;
        this.caseTitle = caseTitle;
        this.courtName = courtName;
        this.date = date;
        this.time = time;
    }

    public Integer getSessionID() {
        return sessionID;
    }

    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
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

    @Override
    public String toString() {
        return "CourtSessions{" +
                "sessionID=" + sessionID +
                ", caseTitle='" + caseTitle + '\'' +
                ", courtName='" + courtName + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                '}';
    }
}

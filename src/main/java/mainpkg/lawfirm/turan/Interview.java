package mainpkg.lawfirm.turan;

import java.time.LocalDate;

public class Interview {
    private String candidateName;
    private String position;
    private LocalDate date;
    private String interviewType;

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "candidateName='" + candidateName + '\'' +
                ", position='" + position + '\'' +
                ", date=" + date +
                ", interviewType='" + interviewType + '\'' +
                '}';
    }

    public Interview(String candidateName, String position, LocalDate date, String interviewType) {
        this.candidateName = candidateName;
        this.position = position;
        this.date = date;
        this.interviewType = interviewType;




    }

}

package mainpkg.lawfirm.Sojib.Legal_Intern;

import mainpkg.lawfirm.User2;

import java.io.Serializable;
import java.time.LocalDate;

public class ScheduleInternalMeetings extends User2 implements Serializable {
    private String meetingTitle;
    private String meetingAgenda;
    private LocalDate date;
    private String time;
    private String participants;

    public ScheduleInternalMeetings(String email, String meetingTitle, String meetingAgenda, LocalDate date, String time, String participants) {
        super(email);
        this.meetingTitle = meetingTitle;
        this.meetingAgenda = meetingAgenda;
        this.date = date;
        this.time = time;
        this.participants = participants;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public String getMeetingAgenda() {
        return meetingAgenda;
    }

    public void setMeetingAgenda(String meetingAgenda) {
        this.meetingAgenda = meetingAgenda;
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

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "ScheduleInternalMeetings{" +
                "email='" + email + '\'' +
                ", participants='" + participants + '\'' +
                ", time='" + time + '\'' +
                ", date=" + date +
                ", meetingAgenda='" + meetingAgenda + '\'' +
                ", meetingTitle='" + meetingTitle + '\'' +
                '}';
    }
}

package mainpkg.lawfirm.Sojib.Client;

import java.io.Serializable;
import java.time.LocalDate;

public class BookConsultation implements Serializable {
    private String consultationType;
    private String timeSlot;
    private String problem;
    private LocalDate preferredDate;

    public BookConsultation(String consultationType, String timeSlot, String problem, LocalDate preferredDate) {
        this.consultationType = consultationType;
        this.timeSlot = timeSlot;
        this.problem = problem;
        this.preferredDate = preferredDate;
    }

    public String getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(String consultationType) {
        this.consultationType = consultationType;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public LocalDate getPreferredDate() {
        return preferredDate;
    }

    public void setPreferredDate(LocalDate preferredDate) {
        this.preferredDate = preferredDate;
    }

    @Override
    public String toString() {
        return "BookConsultation{" +
                "consultationType='" + consultationType + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", problem='" + problem + '\'' +
                ", preferredDate=" + preferredDate +
                '}';
    }
}

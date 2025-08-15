package mainpkg.lawfirm.ronon;

import java.time.LocalDate;

public class paralegal_Meeting {
    private LocalDate date;
    private String time;
    private String notes;

    public paralegal_Meeting(LocalDate date, String time, String notes) {
        this.date = date;
        this.time = time;
        this.notes = notes;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "date=" + date +
                ", time='" + time + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}


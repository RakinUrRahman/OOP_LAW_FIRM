package mainpkg.lawfirm.ronon;
import java.time.LocalDate;

public class officeadmin_CalendarEvent {

    private String eventTitle;
    private LocalDate eventDate;
    private String time;
    private String tag;

    public officeadmin_CalendarEvent(String eventTitle, LocalDate eventDate, String time, String tag) {
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.time = time;
        this.tag = tag;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "CalendarEvent{" +
                "eventTitle='" + eventTitle + '\'' +
                ", eventDate=" + eventDate +
                ", time='" + time + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}

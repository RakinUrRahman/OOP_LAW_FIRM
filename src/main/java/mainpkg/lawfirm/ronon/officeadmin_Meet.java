package mainpkg.lawfirm.ronon;

public class officeadmin_Meet {
    private String lawyer;
    private String client;
    private String date;
    private String time;
    private String meetingType;

    public officeadmin_Meet(String lawyer, String client, String date, String time, String meetingType) {
        this.lawyer = lawyer;
        this.client = client;
        this.date = date;
        this.time = time;
        this.meetingType = meetingType;
    }

    public String getLawyer() {
        return lawyer;
    }

    public void setLawyer(String lawyer) {
        this.lawyer = lawyer;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "lawyer='" + lawyer + '\'' +
                ", client='" + client + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", meetingType='" + meetingType + '\'' +
                '}';
    }
}


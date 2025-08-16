package mainpkg.lawfirm.Sojib.Legal_Intern;

import mainpkg.lawfirm.User2;

import java.io.Serializable;
import java.time.LocalDate;

public class CaseSummaries extends User2 implements Serializable {
    private String title;
    private String name;
    private Integer ID;
    private LocalDate date;
    private String summary;

    public CaseSummaries(String email, String title, String name, Integer ID, LocalDate date, String summary) {
        super(email);
        this.title = title;
        this.name = name;
        this.ID = ID;
        this.date = date;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "CaseSummaries{" +
                "email='" + email + '\'' +
                ", summary='" + summary + '\'' +
                ", date=" + date +
                ", ID=" + ID +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

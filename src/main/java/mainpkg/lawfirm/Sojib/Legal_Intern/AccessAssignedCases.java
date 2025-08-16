package mainpkg.lawfirm.Sojib.Legal_Intern;

import java.io.Serializable;
import java.time.LocalDate;

public class AccessAssignedCases implements Serializable {
    private String title;
    private String lawyer;
    private String name;
    private String status;
    private LocalDate date;

    public AccessAssignedCases(String title, String lawyer, String name, String status, LocalDate date) {
        this.title = title;
        this.lawyer = lawyer;
        this.name = name;
        this.status = status;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLawyer() {
        return lawyer;
    }

    public void setLawyer(String lawyer) {
        this.lawyer = lawyer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}

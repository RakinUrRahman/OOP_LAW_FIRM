package mainpkg.lawfirm.Sojib.Client;

import mainpkg.lawfirm.User2;

import java.io.Serializable;
import java.time.LocalDate;

public class RequestCaseClosure extends User2 implements Serializable {

    private String selectCase;
    private String lawyer;
    private String status;
    private Integer ID;
    private LocalDate date;
    private String reason;

    public RequestCaseClosure(String email, String selectCase, String lawyer, String status, Integer ID, LocalDate date, String reason) {
        super(email);
        this.selectCase = selectCase;
        this.lawyer = lawyer;
        this.status = status;
        this.ID = ID;
        this.date = date;
        this.reason = reason;
    }

    public String getSelectCase() {
        return selectCase;
    }

    public void setSelectCase(String selectCase) {
        this.selectCase = selectCase;
    }

    public String getLawyer() {
        return lawyer;
    }

    public void setLawyer(String lawyer) {
        this.lawyer = lawyer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "RequestCaseClosure{" +
                "selectCase='" + selectCase + '\'' +
                ", lawyer='" + lawyer + '\'' +
                ", status='" + status + '\'' +
                ", ID=" + ID +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

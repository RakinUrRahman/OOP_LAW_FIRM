package mainpkg.lawfirm.Sojib.Legal_Intern;

import java.io.Serializable;
import java.time.LocalDate;

public class ConductResearch implements Serializable {
    private String reseachTitle;
    private String researchType;
    private LocalDate date;
    private String summary;

    public ConductResearch(String reseachTitle, String researchType, LocalDate date, String summary) {
        this.reseachTitle = reseachTitle;
        this.researchType = researchType;
        this.date = date;
        this.summary = summary;
    }

    public String getReseachTitle() {
        return reseachTitle;
    }

    public void setReseachTitle(String reseachTitle) {
        this.reseachTitle = reseachTitle;
    }

    public String getResearchType() {
        return researchType;
    }

    public void setResearchType(String researchType) {
        this.researchType = researchType;
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
        return "ConductResearch{" +
                "reseachTitle='" + reseachTitle + '\'' +
                ", researchType='" + researchType + '\'' +
                ", date=" + date +
                ", summary='" + summary + '\'' +
                '}';
    }
}

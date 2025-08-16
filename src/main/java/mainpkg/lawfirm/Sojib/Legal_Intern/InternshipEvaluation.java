package mainpkg.lawfirm.Sojib.Legal_Intern;

import java.io.Serializable;
import java.time.LocalDate;

public class InternshipEvaluation implements Serializable {
    private String internName;
    private String evaluatorName;
    private LocalDate date;
    private String rating;
    private String comments;

    public InternshipEvaluation(String internName, String evaluatorName, LocalDate date, String rating, String comments) {
        this.internName = internName;
        this.evaluatorName = evaluatorName;
        this.date = date;
        this.rating = rating;
        this.comments = comments;
    }

    public String getInternName() {
        return internName;
    }

    public void setInternName(String internName) {
        this.internName = internName;
    }

    public String getEvaluatorName() {
        return evaluatorName;
    }

    public void setEvaluatorName(String evaluatorName) {
        this.evaluatorName = evaluatorName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "InternshipEvaluation{" +
                "internName='" + internName + '\'' +
                ", evaluatorName='" + evaluatorName + '\'' +
                ", date=" + date +
                ", rating='" + rating + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}

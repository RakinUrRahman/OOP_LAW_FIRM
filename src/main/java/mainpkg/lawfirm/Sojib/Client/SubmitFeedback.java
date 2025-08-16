package mainpkg.lawfirm.Sojib.Client;

import java.io.Serializable;
import java.time.LocalDate;

public class SubmitFeedback implements Serializable {

    private String topic;
    private String feedback;
    private LocalDate Date;

    public SubmitFeedback(String topic, String feedback, LocalDate date) {
        this.topic = topic;
        this.feedback = feedback;
        Date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "SubmitFeedback{" +
                "topic='" + topic + '\'' +
                ", feedback='" + feedback + '\'' +
                ", Date=" + Date +
                '}';
    }
}

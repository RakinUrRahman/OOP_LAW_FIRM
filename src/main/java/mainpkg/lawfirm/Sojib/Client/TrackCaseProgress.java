package mainpkg.lawfirm.Sojib.Client;

import java.io.Serializable;
import java.time.LocalDate;

public class TrackCaseProgress implements Serializable {
    private String topic;
    private String stage;
    private LocalDate fileDate;
    private LocalDate dueDate;

    public TrackCaseProgress(String topic, String stage, LocalDate fileDate, LocalDate dueDate) {
        this.topic = topic;
        this.stage = stage;
        this.fileDate = fileDate;
        this.dueDate = dueDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public LocalDate getFileDate() {
        return fileDate;
    }

    public void setFileDate(LocalDate fileDate) {
        this.fileDate = fileDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "TrackCaseProgress{" +
                "topic='" + topic + '\'' +
                ", stage='" + stage + '\'' +
                ", fileDate=" + fileDate +
                ", dueDate=" + dueDate +
                '}';
    }
}

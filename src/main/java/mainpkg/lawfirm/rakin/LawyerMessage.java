package mainpkg.lawfirm.rakin;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LawyerMessage implements Serializable {


    String sender;
    String recipient;
    String message;
    LocalDateTime time;

    public LawyerMessage(String sender, String recipient, String message, LocalDateTime time) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LawyerMessage{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}

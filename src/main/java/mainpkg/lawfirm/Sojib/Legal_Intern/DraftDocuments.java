package mainpkg.lawfirm.Sojib.Legal_Intern;

import com.example.lawfirmproject.User;

import java.io.Serializable;
import java.time.LocalDate;

public class DraftDocuments extends User implements Serializable {
    private String documentTitle;
    private String documentType;
    private LocalDate date;
    private String content;

    public DraftDocuments(String email, String documentTitle, String documentType, LocalDate date, String content) {
        super(email);
        this.documentTitle = documentTitle;
        this.documentType = documentType;
        this.date = date;
        this.content = content;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DraftDocuments{" +
                "documentTitle='" + documentTitle + '\'' +
                ", documentType='" + documentType + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

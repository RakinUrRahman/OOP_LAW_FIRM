package mainpkg.lawfirm.Sojib.Legal_Intern;

import java.io.Serializable;
import java.time.LocalDate;

public class OrganizeDigitalRecords implements Serializable {
    private String documentTitle;
    private String documentType;
    private LocalDate uploadedDate;
    private String filePath;

    public OrganizeDigitalRecords(String documentTitle, String documentType, LocalDate uploadedDate, String filePath) {
        this.documentTitle = documentTitle;
        this.documentType = documentType;
        this.uploadedDate = uploadedDate;
        this.filePath = filePath;
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

    public LocalDate getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(LocalDate uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "OrganizeDigitalRecords{" +
                "documentTitle='" + documentTitle + '\'' +
                ", documentType='" + documentType + '\'' +
                ", uploadedDate=" + uploadedDate +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}

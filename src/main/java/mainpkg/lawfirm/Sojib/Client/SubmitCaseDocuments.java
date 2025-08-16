package mainpkg.lawfirm.Sojib.Client;

import java.io.Serializable;

public class SubmitCaseDocuments implements Serializable {

    private String documentTitle;
    private String selectCase;
    private String description;

    public SubmitCaseDocuments(String documentTitle, String selectCase, String description) {
        this.documentTitle = documentTitle;
        this.selectCase = selectCase;
        this.description = description;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getSelectCase() {
        return selectCase;
    }

    public void setSelectCase(String selectCase) {
        this.selectCase = selectCase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SubmitCaseDocuments{" +
                "documentTitle='" + documentTitle + '\'' +
                ", selectCase='" + selectCase + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

package mainpkg.lawfirm.ronon;


public class paralegal_SupportingDocument {

    private String fileName;
    private String description;

    public paralegal_SupportingDocument(String fileName, String description) {
        this.fileName = fileName;
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SupportingDocument{" +
                "fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

package mainpkg.lawfirm.turan;

public class SetTaskModel {
    private String caseId;
    private String taskName;
    private String assigned;
    private String status;

    public SetTaskModel(String caseId, String taskName, String assigned, String status) {
        this.caseId = caseId;
        this.taskName = taskName;
        this.assigned = assigned;
        this.status = status;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SetTaskModel{" +
                "caseId='" + caseId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", assigned='" + assigned + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
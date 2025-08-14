package mainpkg.lawfirm.turan;

import java.time.LocalDate;

public class EmAttendanceModel {
    private String employeeId;
    private String employeeName;
    private String department;
    private LocalDate date;
    private String status;

    public EmAttendanceModel(String employeeId, String employeeName, String department, LocalDate date, String status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.date = date;
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmAttendanceModel{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}

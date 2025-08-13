package turan;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.lawfirm.turan.EmAttendanceModel;

import java.time.LocalDate;

public class EmployeeAttendanceController
{
    @javafx.fxml.FXML
    private TableView<EmAttendanceModel> attendanceTV;
    @javafx.fxml.FXML
    private TextField employeenametf;
    @javafx.fxml.FXML
    private TableColumn<EmAttendanceModel, String> departmentTVC;
    @javafx.fxml.FXML
    private TableColumn<EmAttendanceModel, String> dateTVC;
    @javafx.fxml.FXML
    private TableColumn<EmAttendanceModel, String> statusTVC;
    @javafx.fxml.FXML
    private TableColumn<EmAttendanceModel, String> employeenameTVC;
    @javafx.fxml.FXML
    private TableColumn<EmAttendanceModel, String> employeeidTVC;
    @javafx.fxml.FXML
    private ComboBox<String> statuscb;
    @javafx.fxml.FXML
    private DatePicker datedp;
    @javafx.fxml.FXML
    private ComboBox<String> deptcb;
    @javafx.fxml.FXML
    private TextField employeeidtf;
    @javafx.fxml.FXML
    private Label errormsglabel;

    @javafx.fxml.FXML
    public void initialize() {
        employeeidTVC.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeenameTVC.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        departmentTVC.setCellValueFactory(new PropertyValueFactory<>("department"));
        dateTVC.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusTVC.setCellValueFactory(new PropertyValueFactory<>("status"));

        deptcb.getItems().addAll("HR", "Finance", "Legal", "Operations");
        statuscb.getItems().addAll("Present", "Absent", "Leave");

        errormsglabel.setText("ERROR!");
    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void attendancebuttonhandle(ActionEvent actionEvent) {
        String employeeId = employeeidtf.getText();
        String employeeName = employeenametf.getText();
        String department = deptcb.getValue();
        String status = statuscb.getValue();
        LocalDate date = datedp.getValue();


        if (employeeId.isEmpty() || employeeName.isEmpty() || department.isEmpty() || status.isEmpty() || date == null) {
            errormsglabel.setText("Please fill in all fields.");
            return;

        }

            EmAttendanceModel attendance = new EmAttendanceModel(employeeId, employeeName, department, date, status);
            attendanceTV.getItems().add(attendance);

            String dateString = date.toString();

        }


}
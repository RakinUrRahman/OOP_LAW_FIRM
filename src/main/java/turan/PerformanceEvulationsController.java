package turan;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PerformanceEvulationsController
{
    @javafx.fxml.FXML
    private ComboBox<String> communicationcb;
    @javafx.fxml.FXML
    private ComboBox<String> workperfromancecb;
    @javafx.fxml.FXML
    private TextField remarkstf;
    @javafx.fxml.FXML
    private ComboBox<String> puntualitycb;
    @javafx.fxml.FXML
    private ComboBox<String> employeeidcb;
    @javafx.fxml.FXML
    private Label errormsglabel;
    @javafx.fxml.FXML
    private ComboBox<String> teamworkcb;

    @javafx.fxml.FXML
    public void initialize() {
        employeeidcb.getItems().addAll("L001", "L002", "L003", "L004");
        teamworkcb.getItems().addAll("Needs Improvement", "Satisfactory", "Proficient", "Outstanding");
        communicationcb.getItems().addAll("Needs Improvement", "Satisfactory", "Proficient", "Outstanding");
        workperfromancecb.getItems().addAll("Needs Improvement", "Satisfactory", "Proficient", "Outstanding");
        puntualitycb.getItems().addAll("Needs Improvement", "Satisfactory", "Proficient", "Outstanding");

    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitbuttonhandle(ActionEvent actionEvent) {
        String empId = employeeidcb.getValue();
        String teamwork = teamworkcb.getValue();
        String communication = communicationcb.getValue();
        String workPerformance = workperfromancecb.getValue();
        String punctuality = puntualitycb.getValue();
        String remarks = remarkstf.getText();

        if (empId.isEmpty() || teamwork.isEmpty() || communication.isEmpty() || workPerformance.isEmpty() || punctuality.isEmpty() || remarks.isEmpty()) {
            errormsglabel.setText("Please fill in all fields.");
            return;


        }

    }
}
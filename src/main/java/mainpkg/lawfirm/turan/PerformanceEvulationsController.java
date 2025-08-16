package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/turan/hr_dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Client Messages");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
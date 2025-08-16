package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateReportController {

    @FXML
    private CheckBox feedbackkCheckB;
    @FXML
    private CheckBox PevaluationCheckB;
    @FXML
    private CheckBox LsummaryCheckb;
    @FXML
    private ComboBox<String> monthcb;
    @FXML
    private CheckBox employeeattendanceCheckboc;
    @FXML
    private Label errormsglabel;

    @FXML
    public void initialize() {
        monthcb.getItems().addAll(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
    }

    @FXML
    public void generatereportbuttonhandle(ActionEvent actionEvent) {
        String month = monthcb.getValue();

        if (month == null || month.isEmpty()) {
            errormsglabel.setText("Please select a month.");
            return;
        }

        if (!employeeattendanceCheckboc.isSelected()
                && !PevaluationCheckB.isSelected()
                && !feedbackkCheckB.isSelected()
                && !LsummaryCheckb.isSelected()) {
            errormsglabel.setText("Please select at least one report.");
            return;
        }

        List<String> selectedReports = new ArrayList<>();
        if (employeeattendanceCheckboc.isSelected()) {
            selectedReports.add("Employee Attendance Report");
        }
        if (PevaluationCheckB.isSelected()) {
            selectedReports.add("Performance Evaluation Report");
        }
        if (feedbackkCheckB.isSelected()) {
            selectedReports.add("Client Feedback Report");
        }
        if (LsummaryCheckb.isSelected()) {
            selectedReports.add("Legal Summary Report");
        }

        errormsglabel.setText("Generated reports for " + month + ": " + String.join(", ", selectedReports));
    }

    @FXML
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
}

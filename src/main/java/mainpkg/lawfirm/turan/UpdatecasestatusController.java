package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdatecasestatusController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectcaseidcb;
    @javafx.fxml.FXML
    private TextField remarkstf;
    @javafx.fxml.FXML
    private ComboBox<String> newstatusCb;
    @javafx.fxml.FXML
    private Label errormsglabel;
    @javafx.fxml.FXML
    private Label statusofcaselabel;

    @javafx.fxml.FXML
    public void initialize() {
        selectcaseidcb.getItems().addAll("C001", "C002", "C003", "C004");
        newstatusCb.getItems().addAll("Open", "In Progress", "Closed", "On Hold");

        selectcaseidcb.setOnAction(e -> {
            String selectedCase = selectcaseidcb.getValue();
            if (selectedCase != null && !selectedCase.isEmpty()) {
                if (selectedCase.equals("C001")) {
                    statusofcaselabel.setText("Current Status: Open");
                } else if (selectedCase.equals("C002")) {
                    statusofcaselabel.setText("Current Status: In Progress");
                } else if (selectedCase.equals("C003")) {
                    statusofcaselabel.setText("Current Status: Closed");
                } else if (selectedCase.equals("C004")) {
                    statusofcaselabel.setText("Current Status: On Hold");
                } else {
                    statusofcaselabel.setText("Current Status: Unknown");
                }
                errormsglabel.setText("Select Accordingly");
            }
        });
    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/turan/casemanager_dashboard.fxml"));
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
    public void updatebuttonhandle(ActionEvent actionEvent) {
        String caseId = selectcaseidcb.getValue();
        String newStatus = newstatusCb.getValue();
        String remarks = remarkstf.getText();

        if (caseId.isEmpty() || newStatus.isEmpty() || remarks.isEmpty()) {
            errormsglabel.setText("Please fill in all fields.");
            return;
        }
    }
}
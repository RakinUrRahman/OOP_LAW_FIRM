package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UploadMaterialsController
{
    @javafx.fxml.FXML
    private TextField filepdfnametf;
    @javafx.fxml.FXML
    private ComboBox<String> categorycb;
    @javafx.fxml.FXML
    private TextField filenametf;
    @javafx.fxml.FXML
    private Label errormsglabel;

    @javafx.fxml.FXML
    public void initialize() {
        categorycb.getItems().addAll("Contracts", "Case Files", "Legal Forms", "Court Notices");

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
    public void cancelhandlebutton(ActionEvent actionEvent) {
        filenametf.clear();
        categorycb.setValue(null);
        filepdfnametf.clear();
    }

    @javafx.fxml.FXML
    public void uploadhandlebutton(ActionEvent actionEvent) {
        String fileName = filenametf.getText();
        String category = categorycb.getValue();
        String filePdfName = filepdfnametf.getText();

        if (fileName.isEmpty() || category == null || filePdfName.isEmpty()) {
            errormsglabel.setText("Please fill in all fields.");
            return;
        }

    }
}
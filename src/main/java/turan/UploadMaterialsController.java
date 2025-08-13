package turan;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
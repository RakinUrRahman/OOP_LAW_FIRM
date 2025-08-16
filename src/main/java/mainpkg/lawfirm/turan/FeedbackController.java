package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FeedbackController
{
    @javafx.fxml.FXML
    private TextField responsetf;
    @javafx.fxml.FXML
    private TextField employeenametf;
    @javafx.fxml.FXML
    private ComboBox<String> seletectedissuescb;
    @javafx.fxml.FXML
    private TextField subjecttf;
    @javafx.fxml.FXML
    private ComboBox<String> categorycb;

    @javafx.fxml.FXML
    public void initialize() {
        categorycb.getItems().addAll("Work", "Pay", "Cases", "Tech", "Other");
        seletectedissuescb.getItems().addAll("Behavior", "Salary Delay", "Deadline Stress", "Computer Issue", "Miscellaneous");

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
    public void sendresponsehandlebutton(ActionEvent actionEvent) {String employeeName = employeenametf.getText();
        String category = categorycb.getValue();
        String subject = subjecttf.getText();
        String issue = seletectedissuescb.getValue();
        String response = responsetf.getText();

    }

}
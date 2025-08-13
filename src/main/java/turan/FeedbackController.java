package turan;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    }

    @javafx.fxml.FXML
    public void sendresponsehandlebutton(ActionEvent actionEvent) {String employeeName = employeenametf.getText();
        String category = categorycb.getValue();
        String subject = subjecttf.getText();
        String issue = seletectedissuescb.getValue();
        String response = responsetf.getText();

    }

}
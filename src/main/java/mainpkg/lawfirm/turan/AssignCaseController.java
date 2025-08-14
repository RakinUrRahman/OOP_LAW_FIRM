package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AssignCaseController
{
    @javafx.fxml.FXML
    private TextField caseidtf;
    @javafx.fxml.FXML
    private DatePicker deadlinedp;
    @javafx.fxml.FXML
    private ComboBox<String> assigntocb;
    @javafx.fxml.FXML
    private TextField casenametf;
    @javafx.fxml.FXML
    private Label errormsglabel;
    @javafx.fxml.FXML
    private ComboBox<String> assignstuffcb;

    @javafx.fxml.FXML
    public void initialize() {
        assigntocb.getItems().addAll("Corporate Law Dept", "Criminal Law Dept", "Family Law Dept", "Litigation Dept");
        assignstuffcb.getItems().addAll("Rakin", "Turan", "Ronon", "Sojib", "Arafat", "Rafsan", "Muhit");


    }

    @javafx.fxml.FXML
    public void assigncasebuttonhandle(ActionEvent actionEvent) {
        String caseId = caseidtf.getText();
        String caseName = casenametf.getText();
        String assignTo = assigntocb.getValue() == null ? "" : assigntocb.getValue().toString();
        String assignedStaff = assignstuffcb.getValue() == null ? "" : assignstuffcb.getValue().toString();
        String deadline = deadlinedp.getValue() == null ? "" : deadlinedp.getValue().toString();

        if (caseId.isEmpty() || caseName.isEmpty() || assignTo.isEmpty() || assignedStaff.isEmpty() || deadline.isEmpty()) {
            errormsglabel.setText("Please fill in all fields.");
            return;
        }

    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
    }
}
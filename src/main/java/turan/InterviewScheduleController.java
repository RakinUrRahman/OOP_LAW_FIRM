package turan;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class InterviewScheduleController {

    @javafx.fxml.FXML
    private TableColumn<Interview, String> interviewtypeTVC;
    @javafx.fxml.FXML
    private TextField candidatetb;
    @javafx.fxml.FXML
    private DatePicker interviewdp;
    @javafx.fxml.FXML
    private RadioButton onlinerb;
    @javafx.fxml.FXML
    private TableColumn<Interview, String> positionTVC;
    @javafx.fxml.FXML
    private ComboBox<String> positioncb;
    @javafx.fxml.FXML
    private ComboBox<String> interviewercb;
    @javafx.fxml.FXML
    private TableColumn<Interview, String> candidatenameTVC;
    @javafx.fxml.FXML
    private RadioButton inpersonrb;
    @javafx.fxml.FXML
    private TableColumn<Interview, String> DateTVC;
    @javafx.fxml.FXML
    private TableView<Interview> interviewTV;
    @javafx.fxml.FXML
    private Label errormsglabel;

    @javafx.fxml.FXML
    public void initialize() {
        // Link table columns to Interview class properties
        candidatenameTVC.setCellValueFactory(new PropertyValueFactory<>("candidateName"));
        positionTVC.setCellValueFactory(new PropertyValueFactory<>("position"));
        DateTVC.setCellValueFactory(new PropertyValueFactory<>("date"));
        interviewtypeTVC.setCellValueFactory(new PropertyValueFactory<>("interviewType"));

        // Populate ComboBoxes
        positioncb.getItems().addAll("Lawyer", "Paralegal", "Legal Assistant", "Case Manager");
        interviewercb.getItems().addAll("Turan", "Rafsan", "Rakin", "Muhit", "Ronon", "Sojib", "Arafat");

        // Clear error message initially
        errormsglabel.setText("");
    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
        // TODO: Implement navigation logic if needed
    }

    @javafx.fxml.FXML
    public void schedulebuttonhandle(ActionEvent actionEvent) {
        String candidateName = candidatetb.getText();
        String position = positioncb.getValue();
        String interviewer = interviewercb.getValue();
        LocalDate interviewDate = interviewdp.getValue();
        String interviewType = null;

        if (inpersonrb.isSelected()) {
            interviewType = "In Person";
        } else if (onlinerb.isSelected()) {
            interviewType = "Online";
        }

        // Validation
        if (candidateName == null || candidateName.trim().isEmpty()
                || position == null || position.trim().isEmpty()
                || interviewer == null || interviewer.trim().isEmpty()
                || interviewDate == null
                || interviewType == null) {

            errormsglabel.setText("Please fill all fields.");
            return;
        }

        // Add to table
        Interview interview = new Interview(candidateName, position, interviewDate, interviewType);
        interviewTV.getItems().add(interview);

        // Clear form after adding
        candidatetb.clear();
        positioncb.setValue(null);
        interviewercb.setValue(null);
        interviewdp.setValue(null);
        inpersonrb.setSelected(false);
        onlinerb.setSelected(false);
        errormsglabel.setText("");
    }

    @javafx.fxml.FXML
    public void editbuttonhandle(ActionEvent actionEvent) {
        // TODO: Implement edit logic if needed
    }
}

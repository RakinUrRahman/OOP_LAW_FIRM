package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class paralegal_Case {

    @FXML
    private TableView<paralegal_SupportingDocument> documentTableView;
    @FXML
    private Label outputLabel;
    @FXML
    private TableColumn<paralegal_SupportingDocument, String> fileNameCol;
    @FXML
    private TableColumn<paralegal_SupportingDocument, String> descriptionCol;
    @FXML
    private DatePicker meetingDatePicker;
    @FXML
    private TextField timeTextField;
    @FXML
    private TextField fileNameTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextArea meetingTextField;


    private ArrayList<paralegal_SupportingDocument> documentList = new ArrayList<>();
    private ArrayList<paralegal_Meeting> meetings = new ArrayList<>();

    @FXML
    public void initialize() {
        fileNameCol.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        documentTableView.getItems().clear();
    }

    @FXML
    public void addButtonOnClicked(ActionEvent actionEvent) {
        String fileName = fileNameTextField.getText().trim();
        String description = descriptionTextField.getText().trim();

        if (fileName.isEmpty() || description.isEmpty()) {
            outputLabel.setText("Please enter all fields.");
            return;
        }

        paralegal_SupportingDocument document = new paralegal_SupportingDocument(fileName, description);
        documentList.add(document);
        documentTableView.getItems().add(document);

        outputLabel.setText("Document Added: " + fileName);

        fileNameTextField.clear();
        descriptionTextField.clear();
    }




    @FXML
    public void scheduleMeetingOnButtonClicked(ActionEvent actionEvent) {
        LocalDate date = meetingDatePicker.getValue();
        String time = timeTextField.getText().trim();
        String meetingText = meetingTextField.getText().trim();

        if (date == null || time.isEmpty() || meetingText.isEmpty()) {
            outputLabel.setText("Please enter all meeting fields.");
            return;
        }

        paralegal_Meeting meeting = new paralegal_Meeting(date, time, meetingText);
        meetings.add(meeting);
        outputLabel.setText("Meeting Scheduled on " + date + " at " + time);

        meetingDatePicker.setValue(null);
        timeTextField.clear();
        meetingTextField.clear();
    }

    @FXML
    public void sendButtonOnClicked(ActionEvent actionEvent) {
        outputLabel.setText("Documents and meetings sent for review.");
    }
}
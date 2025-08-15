package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class paralegal_Communication {

    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private TableColumn<paralegal_CommunicationLog,String> noteCol;
    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox<String> communicationComboBox;
    @FXML
    private TextArea noteTextArea;
    @FXML
    private TextField timeTextField;
    @FXML
    private TableColumn<paralegal_CommunicationLog,String> caseTypeCol;
    @FXML
    private TableColumn<paralegal_CommunicationLog,String> comunicationTypeCol;
    @FXML
    private TableColumn<paralegal_CommunicationLog, LocalDate> dateCol;
    @FXML
    private Label outputLabel;
    @FXML
    private TableColumn<paralegal_CommunicationLog,String> nameCol;
    @FXML
    private TableColumn<paralegal_CommunicationLog,String> timeCol;
    @FXML
    private ComboBox<String> caseComboBox;
    @FXML
    private TableView<paralegal_CommunicationLog> logsTableView;

    ArrayList<paralegal_CommunicationLog> communicationLogsList = new ArrayList<>();

    @FXML
    public void initialize() {


        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        caseTypeCol.setCellValueFactory(new PropertyValueFactory<>("caseType"));
        comunicationTypeCol.setCellValueFactory(new PropertyValueFactory<>("communicationType"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));


        communicationComboBox.getItems().addAll("Email", "Phone Call", "In-person Meeting");
        caseComboBox.getItems().addAll("Case 1", "Case 2", "Case 3");

        logsTableView.getItems().clear();
    }

    @FXML
    public void saveAllLogOnButtonClicked(ActionEvent actionEvent) {
        outputLabel.setText("Saved all logs successfully.");
    }

    @FXML
    public void addLogButtonOnClicked(ActionEvent actionEvent) {

        String name = nameTextField.getText().trim();
        String caseType = caseComboBox.getValue();
        String communicationType = communicationComboBox.getValue();
        String note = noteTextArea.getText().trim();
        LocalDate date = dateDatePicker.getValue();
        String time = timeTextField.getText().trim();

        if (caseType == null || communicationType == null || name.isEmpty() || note.isEmpty() || date == null || time.isEmpty()) {
            outputLabel.setText("Please fill in all fields.");
            return;
        }


        paralegal_CommunicationLog log = new paralegal_CommunicationLog(name, caseType, communicationType, date,  time, note);


        communicationLogsList.add(log);
        logsTableView.getItems().add(log);

        outputLabel.setText("Log added successfully.");


        caseComboBox.setValue(null);
        communicationComboBox.setValue(null);
        nameTextField.clear();
        noteTextArea.clear();
        dateDatePicker.setValue(null);
        timeTextField.clear();
    }
}
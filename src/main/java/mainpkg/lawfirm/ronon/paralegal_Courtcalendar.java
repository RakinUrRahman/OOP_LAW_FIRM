package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class paralegal_Courtcalendar
{
    @javafx.fxml.FXML
    private TableView<paralegal_CourtEvent> dateTableView;
    @javafx.fxml.FXML
    private TableColumn<paralegal_CourtEvent,String> typeCol;
    @javafx.fxml.FXML
    private TableColumn<paralegal_CourtEvent,String> titleCol;
    @javafx.fxml.FXML
    private TableColumn<paralegal_CourtEvent,String> caseCol;
    @javafx.fxml.FXML
    private TableColumn<paralegal_CourtEvent,String> noteCol;
    @javafx.fxml.FXML
    private TextArea noteTextArea;
    @javafx.fxml.FXML
    private TextField timeTextField;
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TableColumn<paralegal_CourtEvent, LocalDate> dateCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<paralegal_CourtEvent,String> timeCol;
    @javafx.fxml.FXML
    private ComboBox<String> caseComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> eventTypeComboBox;

    ArrayList<paralegal_CourtEvent> courtEventList = new ArrayList<>();
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;


    @javafx.fxml.FXML
    public void initialize() {
        typeCol.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        caseCol.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));

        eventTypeComboBox.getItems().addAll("Hearing", "Trial", "Meeting", "Conference");
        caseComboBox.getItems().addAll("Case 1", "Case 2", "Case 3");

        dateTableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void addButtonOnClicked(ActionEvent actionEvent) {
        String eventType = eventTypeComboBox.getValue();
        String title = titleTextField.getText().trim();
        String caseId = caseComboBox.getValue();
        String note = noteTextArea.getText().trim();
        String time = timeTextField.getText().trim();
        LocalDate date = dateDatePicker.getValue();

        if (eventType == null || title.isEmpty() || caseId == null || note.isEmpty() || time.isEmpty()) {
            outputLabel.setText("Please fill in all fields.");
            return;
        }

        paralegal_CourtEvent event = new paralegal_CourtEvent(eventType, title, date, time, caseId, note);
        courtEventList.add(event);
        dateTableView.getItems().add(event);

        outputLabel.setText("Court Event Added: " + title);

        eventTypeComboBox.setValue(null);
        titleTextField.clear();
        caseComboBox.setValue(null);
        noteTextArea.clear();
        timeTextField.clear();
    }
}
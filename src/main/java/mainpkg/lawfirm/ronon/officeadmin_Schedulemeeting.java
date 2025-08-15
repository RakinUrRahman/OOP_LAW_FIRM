package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class officeadmin_Schedulemeeting {
    @javafx.fxml.FXML
    private ComboBox<String> lawyerComboBox;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Meet, String> clientCol;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Meet, LocalDate> dateCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> clientComboBox;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Meet, String> lawyerCol;
    @javafx.fxml.FXML
    private TextField timeTextField;
    @javafx.fxml.FXML
    private ComboBox<String> meetingTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Meet, String> timeCol;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Meet, String> meetingTypeCol;
    @javafx.fxml.FXML
    private TableView<officeadmin_Meet> meetingTableView;

    ArrayList<officeadmin_Meet> meetingList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        clientCol.setCellValueFactory(new PropertyValueFactory<>("client"));
        lawyerCol.setCellValueFactory(new PropertyValueFactory<>("lawyer"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        meetingTypeCol.setCellValueFactory(new PropertyValueFactory<>("meetingType"));

        meetingTypeComboBox.getItems().addAll("In person", "Virtual");
        lawyerComboBox.getItems().addAll("Lawyer 1", "Lawyer 2", "Lawyer 3");
        clientComboBox.getItems().addAll("Client 1", "Client 2", "Client 3");

    }

    @javafx.fxml.FXML
    public void scheduleMeetingOnClickedButton(ActionEvent actionEvent) {

        if (clientComboBox.getValue() == null) {
            outputLabel.setText("Please select a client.");
            return;
        }
        if (lawyerComboBox.getValue() == null) {
            outputLabel.setText("Please select a lawyer.");
            return;
        }
        if (dateDatePicker.getValue() == null) {
            outputLabel.setText("Please select a date.");
            return;
        }
        if (timeTextField.getText().trim().isEmpty()) {
            outputLabel.setText("Please enter a time.");
            return;
        }
        if (meetingTypeComboBox.getValue() == null) {
            outputLabel.setText("Please select a meeting type.");
            return;
        }

        String client = clientComboBox.getValue();
        String lawyer = lawyerComboBox.getValue();
        LocalDate date = dateDatePicker.getValue();
        String time = timeTextField.getText();
        String meetingType = meetingTypeComboBox.getValue();

        for (officeadmin_Meet m : meetingList) {
            if (m.getClient().equals(client) && m.getLawyer().equals(lawyer) && m.getDate().equals(date) && m.getTime().equals(time)) {
                outputLabel.setText("This meeting already exists.");
                return;
            }
        }

        officeadmin_Meet newMeeting = new officeadmin_Meet(lawyer, client, date.toString(), time, meetingType);
        meetingList.add(newMeeting);
        meetingTableView.getItems().add(newMeeting);
        outputLabel.setText("Meeting scheduled successfully.");

        clientComboBox.setValue(null);
        lawyerComboBox.setValue(null);
        dateDatePicker.setValue(null);
        timeTextField.clear();
        meetingTypeComboBox.setValue(null);

    }
}
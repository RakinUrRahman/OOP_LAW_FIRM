package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class officeadmin_Managecalendar
{
    @javafx.fxml.FXML
    private TableColumn<officeadmin_CalendarEvent,String> eventTitleCol;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_CalendarEvent, LocalDate> dateCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField tagTextfield;
    @javafx.fxml.FXML
    private TextField timeTextField;
    @javafx.fxml.FXML
    private TextField eventTitleTextFiled;
    @javafx.fxml.FXML
    private TableView<officeadmin_CalendarEvent> eventTableView;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_CalendarEvent,String> timeCol;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_CalendarEvent,String> tagCol;
    @javafx.fxml.FXML
    private DatePicker dateLocalDatePicker;

    ArrayList<officeadmin_CalendarEvent> eventList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        eventTitleCol.setCellValueFactory(new PropertyValueFactory<>("eventTitle"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        tagCol.setCellValueFactory(new PropertyValueFactory<>("tag"));

        eventTableView.getItems().addAll(eventList);


    }

    @javafx.fxml.FXML
    public void deleteSelected(ActionEvent actionEvent) {

        officeadmin_CalendarEvent selectedEvent = eventTableView.getSelectionModel().getSelectedItem();
        if (selectedEvent != null) {
            eventList.remove(selectedEvent);
            eventTableView.getItems().remove(selectedEvent);
            outputLabel.setText("Event deleted successfully.");
        } else {
            outputLabel.setText("Please select an event to delete.");
        }

    }

    @javafx.fxml.FXML
    public void addEventOnClickedButton(ActionEvent actionEvent) {

        String title = eventTitleTextFiled.getText().trim();
        LocalDate date = dateLocalDatePicker.getValue();
        String time = timeTextField.getText().trim();
        String tag = tagTextfield.getText().trim();

        if (title.isEmpty()) {
            outputLabel.setText("Please enter an event title.");
            return;
        }
        if (date == null) {
            outputLabel.setText("Please select a date.");
            return;
        }
        if (time.isEmpty()) {
            outputLabel.setText("Please enter a time.");
            return;
        }
        if (tag.isEmpty()) {
            outputLabel.setText("Please enter a tag.");
            return;
        }

        for (officeadmin_CalendarEvent e : eventList) {
            if (e.getEventTitle().equals(title) && e.getEventDate().equals(date)) {
                outputLabel.setText("Event already exists for this date.");
                return;
            }
        }

        officeadmin_CalendarEvent newEvent = new officeadmin_CalendarEvent(title, date, time, tag);
        eventList.add(newEvent);
        eventTableView.getItems().add(newEvent);
        outputLabel.setText("Event added successfully.");

        eventTitleTextFiled.clear();
        dateLocalDatePicker.setValue(null);
        timeTextField.clear();
        tagTextfield.clear();


    }
}
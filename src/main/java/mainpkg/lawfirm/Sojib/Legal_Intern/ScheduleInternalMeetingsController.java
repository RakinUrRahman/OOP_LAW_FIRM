package mainpkg.lawfirm.Sojib.Legal_Intern;

import mainpkg.lawfirm.Sojib.Client.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleInternalMeetingsController {

    @FXML
    private TableColumn<ScheduleInternalMeetings, String> agendaColumn;

    @FXML
    private TableColumn<ScheduleInternalMeetings, LocalDate> dateColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea meetingAgendaTextArea;

    @FXML
    private TextField meetingTitleTextField;

    @FXML
    private TableColumn<ScheduleInternalMeetings, String> participantsColumn;

    @FXML
    private TextField participantsTextField;


    @FXML
    private TableColumn<ScheduleInternalMeetings, String> timeColumn;

    @FXML
    private ComboBox<String> timeComboBox;

    @FXML
    private TableColumn<ScheduleInternalMeetings, String> titleColumn;

    @FXML
    private TableView<ScheduleInternalMeetings> tableView;

    @FXML
    public void initialize() {

        loadAllData();
        timeComboBox.getItems().addAll(
                "09:00 AM - 10:00 AM",
                "10:00 AM - 11:00 AM",
                "11:00 AM - 12:00 PM",
                "02:00 PM - 03:00 PM",
                "03:00 PM - 04:00 PM");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("meetingTitle"));
        agendaColumn.setCellValueFactory(new PropertyValueFactory<>("meetingAgenda"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        participantsColumn.setCellValueFactory(new PropertyValueFactory<>("participants"));

    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Legal_Intern/dashboardOfLegal_Intern.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void scheduleMeetingButton(ActionEvent event) {
        tableView.getItems().clear();
        String meetingTitle = meetingTitleTextField.getText();
        String meetingAgenda = meetingAgendaTextArea.getText();
        LocalDate date = datePicker.getValue();
        String time = timeComboBox.getValue();
        String participants = participantsColumn.getText();

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("ScheduleInternalMeetings.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            String email = new String();
            ScheduleInternalMeetings y = new ScheduleInternalMeetings(email,meetingTitle, meetingAgenda, date,time,participants);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(ScheduleInternalMeetingsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ScheduleInternalMeetingsController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    void loadAllDataButton(ActionEvent event) {
        tableView.getItems().clear();
        loadAllData();

    }

    public void loadAllData() {
        ObjectInputStream ois = null;
        try {
            ScheduleInternalMeetings y;
            ois = new ObjectInputStream(new FileInputStream("ScheduleInternalMeetings.bin"));
            while (true) {
                y = (ScheduleInternalMeetings) ois.readObject();
                tableView.getItems().add(y);
            }
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }
    }
}

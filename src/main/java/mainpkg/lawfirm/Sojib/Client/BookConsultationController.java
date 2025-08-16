package mainpkg.lawfirm.Sojib.Client;

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

public class BookConsultationController {

    @FXML
    private ComboBox<String> consultationTypeComboBox;

    @FXML
    private TableColumn<BookConsultation, LocalDate> dateColumn;

    @FXML
    private DatePicker preferredDatePicker;

    @FXML
    private TextArea problemTextArea;

    @FXML
    private TableColumn<BookConsultation, String> slotColumn;

    @FXML
    private ComboBox<String> timeSlotComboBox;

    @FXML
    private TableColumn<BookConsultation, String> typeColumn;

    @FXML
    private TableView tableView;

    @FXML
    public void initialize() {
        loadAllData();
        consultationTypeComboBox.getItems().addAll("General Legal Advice", "Family & Personal Matters", "Criminal Defense", "Business & Employment", "Property & Real Estate");
        timeSlotComboBox.getItems().addAll(
                "09:00 AM - 10:00 AM",
                "10:00 AM - 11:00 AM",
                "11:00 AM - 12:00 PM",
                "02:00 PM - 03:00 PM",
                "03:00 PM - 04:00 PM");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("consultationType"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("preferredDate"));
        slotColumn.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));

    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/lawfirmproject/Sojib/Client/dashboardClient.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void submitButton(ActionEvent event) {
        tableView.getItems().clear();
        String consultationType = consultationTypeComboBox.getValue();
        String timeSlot = timeSlotComboBox.getValue();
        String problem = problemTextArea.getText();
        LocalDate preferredDate = preferredDatePicker.getValue();


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("BookConsultation.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            BookConsultation y = new BookConsultation(consultationType, timeSlot, problem, preferredDate);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(BookConsultationController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BookConsultationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    public void loadAllDataButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        loadAllData();

    }

    public void loadAllData() {
        ObjectInputStream ois = null;
        try {
            BookConsultation y;
            ois = new ObjectInputStream(new FileInputStream("BookConsultation.bin"));
            while (true) {
                y = (BookConsultation) ois.readObject();
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



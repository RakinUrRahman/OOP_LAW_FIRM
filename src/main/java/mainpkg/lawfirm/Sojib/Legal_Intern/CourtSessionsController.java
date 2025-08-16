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

public class CourtSessionsController {

    @FXML
    private TableColumn<CourtSessions, String> caseTitleColumn;

    @FXML
    private TextField caseTitleTextField;

    @FXML
    private TableColumn<CourtSessions, String> courtColumn;

    @FXML
    private TextField courtNameTextField;

    @FXML
    private TableColumn<CourtSessions, LocalDate> dateColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<CourtSessions, Integer> sessionIDColumn;

    @FXML
    private TextField sessionIDTextField;

    @FXML
    private TableColumn<CourtSessions, String> timeColumn;

    @FXML
    private ComboBox<String> timeComboBox;

    @FXML
    private TableView<CourtSessions> tableView;

    @FXML
    public void initialize() {
        loadAllData();
        int sessionID = Integer.parseInt(sessionIDColumn.getText());
        caseTitleColumn.setCellValueFactory(new PropertyValueFactory<>("caseTitle"));
        courtColumn.setCellValueFactory(new PropertyValueFactory<>("courtName"));
        LocalDate date = datePicker.getValue();
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
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
    void submitButton(ActionEvent event) {
        tableView.getItems().clear();
        int sessionID = Integer.parseInt(sessionIDTextField.getText());
        String caseTitle = caseTitleTextField.getText();
        String courtName = courtNameTextField.getText();
        LocalDate date = datePicker.getValue();
        String time = timeComboBox.getValue();


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("CourtSessions.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            CourtSessions y = new CourtSessions(sessionID, caseTitle, courtName, date, time);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(CourtSessionsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(CourtSessionsController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    void viewDetailsButton(ActionEvent event) {
        tableView.getItems().clear();
        loadAllData();

    }

    public void loadAllData() {
        ObjectInputStream ois = null;
        try {
            CourtSessions y;
            ois = new ObjectInputStream(new FileInputStream("CourtSessions.bin"));
            while (true) {
                y = (CourtSessions) ois.readObject();
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
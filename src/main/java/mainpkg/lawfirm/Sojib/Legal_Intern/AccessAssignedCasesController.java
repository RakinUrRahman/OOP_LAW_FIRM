package mainpkg.lawfirm.Sojib.Legal_Intern;

import com.example.lawfirmproject.Sojib.Client.AppendableObjectOutPutStream;
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

public class AccessAssignedCasesController {

    @FXML
    private TableColumn<AccessAssignedCases, LocalDate> dateColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<AccessAssignedCases, String> lawyerColumn;

    @FXML
    private TextField lawyerTextField;

    @FXML
    private TableColumn<AccessAssignedCases, String> nameColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableColumn<AccessAssignedCases, String> statusColumn;

    @FXML
    private TextArea statusTextArea;

    @FXML
    private TableColumn<AccessAssignedCases, String> titleColumn;

    @FXML
    private TextField titleTextField;

    @FXML
    private TableView<AccessAssignedCases> tableView;

    @FXML
    public void initialize() {
        loadAllData();
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        lawyerColumn.setCellValueFactory(new PropertyValueFactory<>("lawyer"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/lawfirmproject/Sojib/Legal_Intern/dashboardOfLegal_Intern.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void searchButton(ActionEvent event) {
        tableView.getItems().clear();
        String title = titleTextField.getText();
        String name = nameTextField.getText();
        String lawyer = lawyerTextField.getText();
        String status = statusTextArea.getText();
        LocalDate date = datePicker.getValue();

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("AccessAssignedCases.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            AccessAssignedCases y = new AccessAssignedCases(title, lawyer, name, status, date);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(AccessAssignedCasesController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(AccessAssignedCasesController.class.getName()).log(Level.SEVERE, null, ex);
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
            AccessAssignedCases y;
            ois = new ObjectInputStream(new FileInputStream("AccessAssignedCases.bin"));
            while (true) {
                y = (AccessAssignedCases) ois.readObject();
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

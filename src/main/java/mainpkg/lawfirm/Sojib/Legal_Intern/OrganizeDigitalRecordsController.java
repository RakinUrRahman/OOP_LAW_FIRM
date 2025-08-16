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

public class OrganizeDigitalRecordsController {

    @FXML
    private TableColumn<OrganizeDigitalRecords, String> documentTitleColumn;

    @FXML
    private TextField documentTitleTextField;

    @FXML
    private ComboBox<String> documentTypeComboBox;

    @FXML
    private TableColumn<OrganizeDigitalRecords, String> filePathNameColumn;

    @FXML
    private TextField filePathTextField;


    @FXML
    private TableColumn<OrganizeDigitalRecords, String> typeColumn;

    @FXML
    private TableColumn<OrganizeDigitalRecords, LocalDate> uploadedDateColumn;

    @FXML
    private DatePicker uploadedDatePicker;

    @FXML
    private TableView<OrganizeDigitalRecords> tableView;

    @FXML
    public void initialize() {

        loadAllData();
        documentTypeComboBox.getItems().addAll(
                "Case File", "Court Filing", "Evidence", "Contract", "Invoice", "Other");
        documentTitleColumn.setCellValueFactory(new PropertyValueFactory<>("documentTitle"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("documentType"));
        uploadedDateColumn.setCellValueFactory(new PropertyValueFactory<>("uploadedDate"));
        filePathNameColumn.setCellValueFactory(new PropertyValueFactory<>("filePath"));

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
    void submitButton(ActionEvent event) {
        tableView.getItems().clear();
        String documentTitle = documentTitleTextField.getText();
        String documentType = documentTypeComboBox.getValue();
        LocalDate uploadedDate = uploadedDatePicker.getValue();
        String filePath = filePathTextField.getText();

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("OrganizeDigitalRecords.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            String email = new String();
            OrganizeDigitalRecords y = new OrganizeDigitalRecords(documentTitle,documentType, uploadedDate, filePath);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(OrganizeDigitalRecordsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(OrganizeDigitalRecordsController.class.getName()).log(Level.SEVERE, null, ex);
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
            OrganizeDigitalRecords y;
            ois = new ObjectInputStream(new FileInputStream("OrganizeDigitalRecords.bin"));
            while (true) {
                y = (OrganizeDigitalRecords) ois.readObject();
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
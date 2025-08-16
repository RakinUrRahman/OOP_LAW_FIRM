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

public class DraftDocumentsController {

    @FXML
    private TableColumn<DraftDocuments, String> contentColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea documentContentTextArea;

    @FXML
    private TableColumn<DraftDocuments, String> documentTitleColumn;

    @FXML
    private TextField documentTitleTextField;

    @FXML
    private ComboBox<String> documentTypeComboBox;

    @FXML
    private TableColumn<DraftDocuments, String> publishedDateColumn;

    @FXML
    private TableColumn<DraftDocuments, String> typeColumn;

    @FXML
    private TableView<DraftDocuments> tableView;

    @FXML
    public void initialize() {
        loadAllData();
        documentTypeComboBox.getItems().addAll(
                "Contract",
                "Affidavit",
                "Legal Notice",
                "Case Summary",
                "Motion",
                "Pleadings",
                "Agreement",
                "Memorandum");
        documentTitleColumn.setCellValueFactory(new PropertyValueFactory<>("documentTitle"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("documentType"));
        publishedDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("content"));

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
    void saveDraftButton(ActionEvent event) {
        tableView.getItems().clear();
        String documentTitle = documentTitleTextField.getText();
        String documentType = documentTypeComboBox.getValue();
        LocalDate date = datePicker.getValue();
        String content = documentContentTextArea.getText();

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("DraftDocuments.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            String email = new String();
            DraftDocuments y = new DraftDocuments(email,documentTitle, documentType, date, content);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(DraftDocumentsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(DraftDocumentsController.class.getName()).log(Level.SEVERE, null, ex);
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
            DraftDocuments y;
            ois = new ObjectInputStream(new FileInputStream("DraftDocuments.bin"));
            while (true) {
                y = (DraftDocuments) ois.readObject();
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
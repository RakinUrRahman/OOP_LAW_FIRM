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

public class CaseSummariesController {

    @FXML
    private TextField IDtextField;

    @FXML
    private TableColumn<CaseSummaries, Integer> caseIDcolumn;

    @FXML
    private TextArea caseSummaryTextArea;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<CaseSummaries, LocalDate> lastUpdatedColumn;

    @FXML
    private TableColumn<CaseSummaries, String> nameColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableColumn<CaseSummaries, String> summaryColumn;


    @FXML
    private TextField titleTextField;

    @FXML
    private TableView<CaseSummaries> tableView;

    @FXML
    public void initialize() {
        loadAllData();
        int ID = Integer.parseInt(caseIDcolumn.getText());
        LocalDate date = datePicker.getValue();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));
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
    void saveButton(ActionEvent event) {
        tableView.getItems().clear();
        String title = titleTextField.getText();
        String name = nameTextField.getText();
        int ID = Integer.parseInt(IDtextField.getText());
        LocalDate date = datePicker.getValue();
        String summary = caseSummaryTextArea.getText();

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("CaseSummaries.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            String email = new String();
            CaseSummaries y = new CaseSummaries(email,title, name,ID, date,summary);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(CaseSummariesController.class.getName()).log(Level.SEVERE, null, ex);
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
            CaseSummaries y;
            ois = new ObjectInputStream(new FileInputStream("CaseSummaries.bin"));
            while (true) {
                y = (CaseSummaries) ois.readObject();
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

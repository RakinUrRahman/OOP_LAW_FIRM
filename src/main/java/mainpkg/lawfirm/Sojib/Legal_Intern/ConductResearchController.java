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

public class ConductResearchController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<ConductResearch, String> datePublishedColumn;

    @FXML
    private TextField reseachTitleTextField;

    @FXML
    private TableColumn<ConductResearch, String> researchTitleColumn;

    @FXML
    private ComboBox<String> researchTypeComboBox;

    @FXML
    private TableColumn<ConductResearch, String> summaryColumn;

    @FXML
    private TextArea summaryTextArea;

    @FXML
    private TableView<ConductResearch> tableView;

    @FXML
    private TableColumn<ConductResearch, String> typeColumn;

    @FXML
    public void initialize() {
        loadAllData();
        researchTypeComboBox.getItems().addAll(
                "Case Law",
                "Statutes",
                "Regulations",
                "Legal Commentary");
        researchTitleColumn.setCellValueFactory(new PropertyValueFactory<>("reseachTitle"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("researchType"));
        datePublishedColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
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
    void submitButton(ActionEvent event) {
        tableView.getItems().clear();
        String reseachTitle = reseachTitleTextField.getText();
        String researchType = researchTypeComboBox.getValue();
        LocalDate date = datePicker.getValue();
        String summary = summaryTextArea.getText();

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("ConductResearch.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            ConductResearch y = new ConductResearch(reseachTitle, researchType, date,summary);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(ConductResearchController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ConductResearchController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    void searchButton(ActionEvent event) {
        tableView.getItems().clear();
        loadAllData();

    }

    public void loadAllData() {
        ObjectInputStream ois = null;
        try {
            ConductResearch y;
            ois = new ObjectInputStream(new FileInputStream("ConductResearch.bin"));
            while (true) {
                y = (ConductResearch) ois.readObject();
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


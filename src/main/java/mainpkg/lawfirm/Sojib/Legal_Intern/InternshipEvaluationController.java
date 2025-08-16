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

public class InternshipEvaluationController {

    @FXML
    private TableColumn<InternshipEvaluation, String> commentsColumn;

    @FXML
    private TextArea commentsTextArea;

    @FXML
    private TableColumn<InternshipEvaluation, LocalDate> dateColumn;

    @FXML
    private DatePicker evaluationDatePicker;

    @FXML
    private TableColumn<InternshipEvaluation, String> evaluatorNameColumn;

    @FXML
    private TextField evaluatorNameTextField;

    @FXML
    private TableColumn<InternshipEvaluation, String> internColumn;

    @FXML
    private TextField internNameTextField;

    @FXML
    private TableColumn<InternshipEvaluation, String> ratingColumn;

    @FXML
    private ComboBox<String> ratingComboBox;

    @FXML
    private TableView<InternshipEvaluation> tableView;

    @FXML
    public void initialize() {

        loadAllData();
        ratingComboBox.getItems().addAll(
                "Excellent", "Very Good", "Good", "Fair", "Poor");
        internColumn.setCellValueFactory(new PropertyValueFactory<>("internName"));
        evaluatorNameColumn.setCellValueFactory(new PropertyValueFactory<>("evaluatorName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        commentsColumn.setCellValueFactory(new PropertyValueFactory<>("comments"));

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
        String internName = internNameTextField.getText();
        String evaluatorName = evaluatorNameTextField.getText();
        LocalDate date = evaluationDatePicker.getValue();
        String rating = ratingComboBox.getValue();
        String comments = commentsTextArea.getText();

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("InternshipEvaluation.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            String email = new String();
            InternshipEvaluation y = new InternshipEvaluation(internName,evaluatorName, date, rating, comments);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(InternshipEvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(InternshipEvaluationController.class.getName()).log(Level.SEVERE, null, ex);
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
            InternshipEvaluation y;
            ois = new ObjectInputStream(new FileInputStream("InternshipEvaluation.bin"));
            while (true) {
                y = (InternshipEvaluation) ois.readObject();
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
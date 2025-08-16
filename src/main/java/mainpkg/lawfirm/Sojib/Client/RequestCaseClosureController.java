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

public class RequestCaseClosureController {

    @FXML
    private TextField IDTextField;

    @FXML
    private TableColumn<RequestCaseClosure, Integer> caseIDColumn;

    @FXML
    private TableColumn<RequestCaseClosure, LocalDate> dateColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<RequestCaseClosure, String> lawyerColumn;

    @FXML
    private TextField lawyerTextField;

    @FXML
    private TableColumn<RequestCaseClosure, String> reasonColumn;

    @FXML
    private TextArea reasonTextArea;

    @FXML
    private ComboBox<String> selectCaseComboBox;

    @FXML
    private TableColumn<RequestCaseClosure, String> statusColumn;

    @FXML
    private TextField statusTextField;

    @FXML
    private TableView<RequestCaseClosure> tableView;

    @FXML
    public void initialize() {
        loadAllData();
        selectCaseComboBox.getItems().addAll("Case 1", "Case 2", "Case 3", "Case 4");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        caseIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        lawyerColumn.setCellValueFactory(new PropertyValueFactory<>("lawyer"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        reasonColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
            Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Client/dashboardClient.fxml")));
            Scene scene2 = new Scene(scene2Parent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("dashboard");
            window.setScene(scene2);
            window.show();

        }

    @FXML
    void requestButton(ActionEvent event) {
        tableView.getItems().clear();
        String selectCase = selectCaseComboBox.getValue();
        String lawyer = lawyerTextField.getText();
        String status = statusTextField.getText();
        int ID = Integer.parseInt(IDTextField.getText());
        LocalDate date = datePicker.getValue();
        String reason = reasonTextArea.getText();



        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("RequestCaseClosure.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            String email = new String();
            RequestCaseClosure y = new RequestCaseClosure(email, selectCase, lawyer, status, ID, date, reason);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(RequestCaseClosureController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(RequestCaseClosureController.class.getName()).log(Level.SEVERE, null, ex);
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
            RequestCaseClosure y;
            ois = new ObjectInputStream(new FileInputStream("RequestCaseClosure.bin"));
            while (true) {
                y = (RequestCaseClosure) ois.readObject();
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
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

public class SubmitFeedbackController {

    @FXML
    private DatePicker DatePicker;

    @FXML
    private TableColumn<SubmitFeedback, LocalDate> dateColumn;

    @FXML
    private TableColumn<SubmitFeedback, String> feedbackColumn;

    @FXML
    private TextArea feedbackTextArea;

    @FXML
    private TableView<SubmitFeedback> tableView;

    @FXML
    private TableColumn<SubmitFeedback, String> topicColumn;

    @FXML
    private TextField topicTextField;

    @FXML
    public void initialize() {
        loadAllData();
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        feedbackColumn.setCellValueFactory(new PropertyValueFactory<>("feedback"));
        topicColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));

    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Client/dashboardClient.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(scene2);
        window.show();


    }

    @FXML
    void loadAllDataButton(ActionEvent event) {
        tableView.getItems().clear();
        loadAllData();

    }

    public void loadAllData() {
        ObjectInputStream ois = null;
        try {
            SubmitFeedback y;
            ois = new ObjectInputStream(new FileInputStream("SubmitFeedback.bin"));
            while (true) {
                y = (SubmitFeedback) ois.readObject();
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

    @FXML
    void submitButton(ActionEvent event) {
        tableView.getItems().clear();
        String topic = topicTextField.getText();
        String feedback = feedbackTextArea.getText();
        LocalDate date = DatePicker.getValue();


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("SubmitFeedback.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            SubmitFeedback y = new SubmitFeedback( topic, feedback, date);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(SubmitFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SubmitFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

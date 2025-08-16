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

public class TrackCaseProgressController {

    @FXML
    private TableColumn<TrackCaseProgress, LocalDate> dueColumn;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private DatePicker fileDatePicker;

    @FXML
    private TableColumn<TrackCaseProgress, LocalDate> filingDateColumn;

    @FXML
    private TableColumn<TrackCaseProgress, String> stageColumn;

    @FXML
    private TextField stageTextField;

    @FXML
    private TableView<TrackCaseProgress> tableView;

    @FXML
    private TableColumn<TrackCaseProgress, String> topicColumn;

    @FXML
    private ComboBox<String> topicComboBox;

    @FXML
    public void initialize() {

        loadAllData();
        topicComboBox.getItems().addAll("Case 1", "Case 2", "Case 3", "Case 4");
        stageColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));
        topicColumn.setCellValueFactory(new PropertyValueFactory<>("stage"));
        filingDateColumn.setCellValueFactory(new PropertyValueFactory<>("fileDate"));
        dueColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

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
    void submitButton(ActionEvent event) {
        tableView.getItems().clear();
        String topic = topicComboBox.getValue();
        String stage = stageTextField.getText();
        LocalDate fileDate = fileDatePicker.getValue();
        LocalDate dueDate = dueDatePicker.getValue();



        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("TrackCaseProgress.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            TrackCaseProgress y = new TrackCaseProgress( topic, stage, fileDate, dueDate);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(TrackCaseProgressController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(TrackCaseProgressController.class.getName()).log(Level.SEVERE, null, ex);
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
            TrackCaseProgress y;
            ois = new ObjectInputStream(new FileInputStream("TrackCaseProgress.bin"));
            while (true) {
                y = (TrackCaseProgress) ois.readObject();
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

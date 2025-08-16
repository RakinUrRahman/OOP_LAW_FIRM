package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetTaskController
{
    @javafx.fxml.FXML
    private TableColumn<SetTaskModel, String> assignedTVC;
    @javafx.fxml.FXML
    private ComboBox<String> selectcaseidcb;
    @javafx.fxml.FXML
    private TableColumn<SetTaskModel, String> tasknameTVC;
    @javafx.fxml.FXML
    private TableColumn<SetTaskModel, String> caseidTVC;
    @javafx.fxml.FXML
    private DatePicker deadlinedp;
    @javafx.fxml.FXML
    private TableColumn<SetTaskModel, String> statusTVC;
    @javafx.fxml.FXML
    private Label errormsglabel;
    @javafx.fxml.FXML
    private TableView<SetTaskModel> settaskTV;
    private final List<SetTaskModel> taskList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        caseidTVC.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        tasknameTVC.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        assignedTVC.setCellValueFactory(new PropertyValueFactory<>("assigned"));
        statusTVC.setCellValueFactory(new PropertyValueFactory<>("status"));


        settaskTV.getItems().setAll(taskList);

        selectcaseidcb.getItems().addAll("C001", "C002", "C003");

    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/turan/casemanager_dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Client Messages");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void savebuttonhandle(ActionEvent actionEvent) {
        String caseId = selectcaseidcb.getValue();
        String deadline = (deadlinedp.getValue() != null) ? deadlinedp.getValue().toString() : "";

        if (caseId.isEmpty() || deadline.isEmpty()) {
            errormsglabel.setText("Please fill in all fields.");
            return;
        }
        taskList.add(new SetTaskModel(caseId, "Prepare Legal Brief", "Rafsan", "Pending"));

        settaskTV.getItems().setAll(taskList);

    }
}
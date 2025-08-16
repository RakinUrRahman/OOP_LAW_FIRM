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

public class CriticalcasetagController
{
    @javafx.fxml.FXML
    private TableView<criticalcasetagModel> criticalcaseTV;
    @javafx.fxml.FXML
    private ComboBox<String> selectcaseidcb;
    @javafx.fxml.FXML
    private TableColumn<criticalcasetagModel, String> caseidTVC;
    @javafx.fxml.FXML
    private RadioButton criticalrb;
    @javafx.fxml.FXML
    private TableColumn<criticalcasetagModel, String> statustvc;
    @javafx.fxml.FXML
    private RadioButton urgentrb;
    @javafx.fxml.FXML
    private TableColumn<criticalcasetagModel, String> priorityTVC;
    @javafx.fxml.FXML
    private TableColumn<criticalcasetagModel, String> casenameTVC;
    @javafx.fxml.FXML
    private RadioButton normalrb;
    @javafx.fxml.FXML
    private Label errormsglabel;
    private final List<criticalcasetagModel> taskList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        caseidTVC.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        casenameTVC.setCellValueFactory(new PropertyValueFactory<>("caseName"));
        statustvc.setCellValueFactory(new PropertyValueFactory<>("status"));
        priorityTVC.setCellValueFactory(new PropertyValueFactory<>("priority"));

        taskList.add(new criticalcasetagModel("C001", "Contract Dispute", "Open", "Normal"));

        criticalcaseTV.getItems().setAll(taskList);

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
    public void updatebuttonhandle(ActionEvent actionEvent) {
        String selectedCaseId = selectcaseidcb.getValue();
        if (selectedCaseId == null || selectedCaseId.isEmpty()) {
            errormsglabel.setText("Please select a case ID.");
            return;
        }

        criticalcasetagModel selectedCase = null;
        for (criticalcasetagModel c : taskList) {
            if (c.getCaseId().equals(selectedCaseId)) {
                selectedCase = c;
                return;
            }
        }

        if (selectedCase == null) {
            errormsglabel.setText("Case not found.");
            return;
        }

        String newPriority = null;
        if (normalrb.isSelected()) newPriority = "Normal";
        else if (urgentrb.isSelected()) newPriority = "Urgent";
        else if (criticalrb.isSelected()) newPriority = "Critical";

        if (newPriority == null || newPriority.isEmpty()) {
            errormsglabel.setText("Please select a priority.");
            return;
        }

        selectedCase.setPriority(newPriority);
        criticalcaseTV.getItems().setAll(taskList);



    }

}
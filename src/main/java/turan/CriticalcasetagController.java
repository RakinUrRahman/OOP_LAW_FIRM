package turan;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.lawfirm.turan.criticalcasetagModel;

import java.util.ArrayList;
import java.util.List;

public class CriticalcasetagController {
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
        // Table column bindings
        caseidTVC.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        casenameTVC.setCellValueFactory(new PropertyValueFactory<>("caseName"));
        statustvc.setCellValueFactory(new PropertyValueFactory<>("status"));
        priorityTVC.setCellValueFactory(new PropertyValueFactory<>("priority"));

        // Example data
        taskList.add(new criticalcasetagModel("C001", "Contract Dispute", "Open", "Normal"));
        taskList.add(new criticalcasetagModel("C002", "Property Case", "Pending", "Urgent"));
        taskList.add(new criticalcasetagModel("C003", "Fraud Investigation", "Closed", "Critical"));

        criticalcaseTV.getItems().setAll(taskList);

        // ComboBox items
        selectcaseidcb.getItems().addAll("C001", "C002", "C003");
    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
        // Implement navigation logic here
    }

    @javafx.fxml.FXML
    public void updatebuttonhandle(ActionEvent actionEvent) {
        errormsglabel.setText(""); // Clear previous error

        String selectedCaseId = selectcaseidcb.getValue();
        if (selectedCaseId == null || selectedCaseId.isEmpty()) {
            errormsglabel.setText("Please select a case ID.");
            return;
        }

        // Find selected case
        criticalcasetagModel selectedCase = null;
        for (criticalcasetagModel c : taskList) {
            if (c.getCaseId().equals(selectedCaseId)) {
                selectedCase = c;
                break; // ✅ Stop loop without exiting method
            }
        }

        if (selectedCase == null) {
            errormsglabel.setText("Case not found.");
            return;
        }

        // Determine new priority
        String newPriority = null;
        if (normalrb.isSelected()) newPriority = "Normal";
        else if (urgentrb.isSelected()) newPriority = "Urgent";
        else if (criticalrb.isSelected()) newPriority = "Critical";

        if (newPriority == null) {
            errormsglabel.setText("Please select a priority.");
            return;
        }

        // Update model and refresh table
        selectedCase.setPriority(newPriority);
        criticalcaseTV.refresh(); // ✅ More efficient than resetting entire list
    }
}

package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class officeadmin_Casestatus {

    @javafx.fxml.FXML
    private TableView<officeadmin_Case> caseTableView;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Case, String> caseIdCol;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Case, String> titleCol;
    @javafx.fxml.FXML
    private Label output1Label;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private Label output2Label;

    ArrayList<officeadmin_Case> caseList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        caseIdCol.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        caseList.add(new officeadmin_Case("C001", "Contract Review"));
        caseList.add(new officeadmin_Case("C002", "Divorce Settlement"));
        caseList.add(new officeadmin_Case("C003", "Property Dispute"));

        caseTableView.getItems().addAll(caseList);

        statusComboBox.getItems().addAll("In Progress", "Closed", "Pending", "On Hold");

        caseTableView.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> {
            if (nv != null) {
                output1Label.setText("Selected Case: " + nv.getCaseId() + " - " + nv.getTitle());
            } else {
                output1Label.setText("");
            }
        });

    }

    @javafx.fxml.FXML
    public void updateStatusOnClickedButton(ActionEvent actionEvent) {
        officeadmin_Case selectedCase = caseTableView.getSelectionModel().getSelectedItem();
        String newStatus = statusComboBox.getValue();

        if (selectedCase == null) {
            output2Label.setText("Please select a case first.");
            return;
        }
        if (newStatus == null || newStatus.trim().isEmpty()) {
            output2Label.setText("Please select a new status.");
            return;
        }

        selectedCase.setStatus(newStatus);

        output2Label.setText("Case " + selectedCase.getCaseId() + " updated to status: " + newStatus);

        caseTableView.getSelectionModel().clearSelection();
        statusComboBox.setValue(null);
        output1Label.setText("");
    }
}

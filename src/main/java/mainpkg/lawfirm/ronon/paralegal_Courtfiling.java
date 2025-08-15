package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class paralegal_Courtfiling {

    @FXML
    private TableColumn<paralegal_CaseReport, String> caseCol;
    @FXML
    private TableColumn<paralegal_CaseReport, String> reportCol;
    @FXML
    private TableColumn<paralegal_CaseReport, String> sectionCol;
    @FXML
    private TableView<paralegal_CaseReport> reportTableView;
    @FXML
    private ComboBox<String> reportTypeComboBox;
    @FXML
    private ComboBox<String> caseComboBox;
    @FXML
    private CheckBox communicationCheckBox;
    @FXML
    private CheckBox deadlineCheckBox;
    @FXML
    private CheckBox noteCheckBox;
    @FXML
    private Label outputLabel;

    private ArrayList<paralegal_CaseReport> reportList = new ArrayList<>();

    @FXML
    public void initialize() {

        caseCol.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        reportCol.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        sectionCol.setCellValueFactory(new PropertyValueFactory<>("includeSection"));


        reportTypeComboBox.getItems().addAll("Summary", "Detailed", "Custom");
        caseComboBox.getItems().addAll("Case 1", "Case 2", "Case 3");


        reportTableView.getItems().clear();


    }

    @FXML
    public void genarateReportOnButtonClicked(ActionEvent actionEvent) {
        String caseId = caseComboBox.getValue();
        String reportType = reportTypeComboBox.getValue();
        String includeSection = "";

        if (communicationCheckBox.isSelected()) includeSection += "Communication ";
        if (deadlineCheckBox.isSelected()) includeSection += "Deadline ";
        if (noteCheckBox.isSelected()) includeSection += "Notes ";

        if (caseId == null || reportType == null) {
            outputLabel.setText("Please select Case and Report Type");
            return;
        }


        paralegal_CaseReport report = new paralegal_CaseReport(caseId, reportType, includeSection.trim());
        reportList.add(report);
        reportTableView.getItems().add(report);

        outputLabel.setText("Report added for case: " + caseId);


        caseComboBox.setValue(null);
        reportTypeComboBox.setValue(null);
        communicationCheckBox.setSelected(false);
        deadlineCheckBox.setSelected(false);
        noteCheckBox.setSelected(false);
    }
}

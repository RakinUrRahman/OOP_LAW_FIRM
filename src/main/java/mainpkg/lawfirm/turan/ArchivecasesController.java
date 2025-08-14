package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ArchivecasesController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectcaseidcb;
    @javafx.fxml.FXML
    private TableView<ArchiveCaseModel> archivecaseTV;
    @javafx.fxml.FXML
    private TableColumn<ArchiveCaseModel, String> caseidTVC;
    @javafx.fxml.FXML
    private TableColumn<ArchiveCaseModel, String> statustvc;
    @javafx.fxml.FXML
    private CheckBox yesCheckb;
    @javafx.fxml.FXML
    private CheckBox noCheckB;
    @javafx.fxml.FXML
    private TableColumn<ArchiveCaseModel, String> casenameTVC;
    @javafx.fxml.FXML
    private TableColumn<ArchiveCaseModel, String> completionTVC;
    @javafx.fxml.FXML
    private Label errormsglabel;
    private final List<ArchiveCaseModel> taskList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        caseidTVC.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        casenameTVC.setCellValueFactory(new PropertyValueFactory<>("caseName"));
        statustvc.setCellValueFactory(new PropertyValueFactory<>("status"));
        completionTVC.setCellValueFactory(new PropertyValueFactory<>("completionDate"));

        selectcaseidcb.getItems().addAll("C001", "C002", "C003");

        taskList.add(new ArchiveCaseModel("C001", "Property Dispute", "Completed", "2025-08-01"));

        archivecaseTV.getItems().setAll(taskList);

    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void archivebuttonhandle(ActionEvent actionEvent) {
        String caseId = selectcaseidcb.getValue();

        if (caseId == null || caseId.isEmpty()) {
            errormsglabel.setText("Please select a case ID.");
            return;
        }

        if (!yesCheckb.isSelected() && !noCheckB.isSelected()) {
            errormsglabel.setText("Please confirm Yes or No.");
            return;
        }

        if (noCheckB.isSelected()) {
            errormsglabel.setText("Archive cancelled for case " + caseId);
            return;
        }


        archivecaseTV.getItems().setAll(taskList);

    }
}
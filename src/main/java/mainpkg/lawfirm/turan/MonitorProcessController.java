package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class MonitorProcessController
{
    @javafx.fxml.FXML
    private TableColumn<MonitorProcessModel, String> assignedtoTVC;
    @javafx.fxml.FXML
    private TableView<MonitorProcessModel> tasprogressTV;
    @javafx.fxml.FXML
    private TableColumn<MonitorProcessModel, String> caseidTVC;
    @javafx.fxml.FXML
    private TableColumn<MonitorProcessModel, String> statustvc;
    @javafx.fxml.FXML
    private TableColumn<MonitorProcessModel, String> casenameTVC;
    @javafx.fxml.FXML
    private ComboBox<String> filterrolecb;
    @javafx.fxml.FXML
    private ComboBox<String> filterstatuscb1;
    @javafx.fxml.FXML
    private Label errormsglabel;
    private List<MonitorProcessModel> taskList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        caseidTVC.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        casenameTVC.setCellValueFactory(new PropertyValueFactory<>("caseName"));
        statustvc.setCellValueFactory(new PropertyValueFactory<>("status"));
        assignedtoTVC.setCellValueFactory(new PropertyValueFactory<>("assignedTo"));

        filterrolecb.getItems().addAll("Lawyer", "Paralegal", "Legal Assistant");
        filterstatuscb1.getItems().addAll("Pending", "In Progress", "Completed");

    }

    @javafx.fxml.FXML
    public void refreshbuttonhandle(ActionEvent actionEvent) {
        String roleFilter = filterrolecb.getValue();
        String statusFilter = filterstatuscb1.getValue();

        if (roleFilter == null || roleFilter.isEmpty() || statusFilter == null || statusFilter.isEmpty()) {
            errormsglabel.setText("Please select both filters.");
            return;
        }

        tasprogressTV.getItems().setAll(taskList);
    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
    }
}
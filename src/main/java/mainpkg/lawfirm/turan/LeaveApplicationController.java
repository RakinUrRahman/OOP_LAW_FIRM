package mainpkg.lawfirm.turan;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LeaveApplicationController
{

    @javafx.fxml.FXML
    private TableColumn<LeaveApplicationModel, String> EnameTVC;
    @javafx.fxml.FXML
    private TableView<LeaveApplicationModel> leaveappliTV;
    @javafx.fxml.FXML
    private ComboBox<String> employeenametcb;
    @javafx.fxml.FXML
    private TableColumn<LeaveApplicationModel, String> statusTvc;
    @javafx.fxml.FXML
    private TableColumn<LeaveApplicationModel, String> EidTVC;
    @javafx.fxml.FXML
    private TableColumn<LeaveApplicationModel, String> LtypeTVC;
    @javafx.fxml.FXML
    private ComboBox<String> deptcb;
    @javafx.fxml.FXML
    private ComboBox<String> employeeidcb;
    @javafx.fxml.FXML
    private TableColumn<LeaveApplicationModel, String> DeptTVC;
    private ArrayList<LeaveApplicationModel> leaveList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        EidTVC.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        EnameTVC.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        DeptTVC.setCellValueFactory(new PropertyValueFactory<>("department"));
        LtypeTVC.setCellValueFactory(new PropertyValueFactory<>("leaveType"));
        statusTvc.setCellValueFactory(new PropertyValueFactory<>("status"));

        leaveappliTV.setItems((ObservableList<LeaveApplicationModel>) leaveList);

        employeenametcb.getItems().addAll("Turan", "Rafsan", "Rakin", "Muhit", "Ronon", "Sojib", "Arafat");
        employeeidcb.getItems().addAll("L001", "L002", "L003", "L004", "L005", "L006", "L007");
        deptcb.getItems().addAll("HR", "Finance", "Legal");



    }

    @javafx.fxml.FXML
    public void rejectbuttonhandle(ActionEvent actionEvent) {
        LeaveApplicationModel selected = leaveappliTV.getSelectionModel().getSelectedItem();
        selected.setStatus("Rejected");
        leaveappliTV.refresh();
    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/turan/hr_dashboard.fxml"));
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
    public void showbuttonhandle(ActionEvent actionEvent) {
        leaveappliTV.setItems((ObservableList<LeaveApplicationModel>) leaveList);
    }

    @javafx.fxml.FXML
    public void approvehandlebutton(ActionEvent actionEvent) {
        LeaveApplicationModel selected = leaveappliTV.getSelectionModel().getSelectedItem();
        selected.setStatus("Approved");
        leaveappliTV.refresh();
    }
}
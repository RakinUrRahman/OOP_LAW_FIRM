package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class GenerateWeeklysummaryController
{
    @javafx.fxml.FXML
    private RadioButton weeklyrb;
    @javafx.fxml.FXML
    private DatePicker daterangedp2;
    @javafx.fxml.FXML
    private DatePicker daterangedp1;
    @javafx.fxml.FXML
    private RadioButton dailyrb;
    @javafx.fxml.FXML
    private ComboBox<String> filterrolecb;
    @javafx.fxml.FXML
    private ComboBox<String> filtercasetypecb;
    @javafx.fxml.FXML
    private Label errormsglabel;

    @javafx.fxml.FXML
    public void initialize() {
        filterrolecb.getItems().addAll("Lawyer", "Paralegal", "Legal Assistant", "Researcher", "Admin");
        filtercasetypecb.getItems().addAll("Criminal", "Civil", "Family", "Corporate", "Property");

    }

    @javafx.fxml.FXML
    public void generatereportbuttonhandle(ActionEvent actionEvent) {
        String selectedRole = filterrolecb.getValue();
        String selectedCaseType = filtercasetypecb.getValue();
        boolean isDailySelected = dailyrb.isSelected();
        boolean isWeeklySelected = weeklyrb.isSelected();
        boolean isDateRangeSelected = daterangedp1.getValue() != null && daterangedp2.getValue() != null;

        if (!isDailySelected && !isWeeklySelected) {
            errormsglabel.setText("Please select Daily or Weekly report.");
            return;
        }

        if (selectedRole == null || selectedRole.isEmpty()) {
            errormsglabel.setText("Please select Daily or Weekly report.");
            return;
        }

        if (selectedCaseType == null || selectedCaseType.isEmpty()) {
            errormsglabel.setText("Please select Daily or Weekly report.");
            return;
        }

        if (!isDateRangeSelected) {
            errormsglabel.setText("Please select Daily or Weekly report.");
            return;
        }
    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
    }
}
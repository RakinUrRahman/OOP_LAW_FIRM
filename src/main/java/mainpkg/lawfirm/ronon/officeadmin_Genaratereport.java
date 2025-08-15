package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.time.Month;

public class officeadmin_Genaratereport {

    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> monthComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> yearComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextArea reportTextArea;

    @javafx.fxml.FXML
    public void initialize() {

        reportTypeComboBox.getItems().addAll("Performance Report", "Billing Report");


        for (Month m : Month.values()) {
            monthComboBox.getItems().add(m.name());
        }

        int currentYear = java.time.Year.now().getValue();

        for (int i = 0; i <= 5; i++) {
            yearComboBox.getItems().add(String.valueOf(currentYear - i));
        }


    }

    @javafx.fxml.FXML
    public void genarateReportOnClickedButton(ActionEvent actionEvent) {
        String reportType = reportTypeComboBox.getValue();
        String month = monthComboBox.getValue();
        String year = yearComboBox.getValue();


        if (reportType == null) {
            outputLabel.setText("Please select a report type.");
            return;
        }
        if (month == null) {
            outputLabel.setText("Please select a month.");
            return;
        }
        if (year == null) {
            outputLabel.setText("Please select a year.");
            return;
        }


        String reportContent = generateDummyReport(reportType, month, year);


        reportTextArea.setText(reportContent);


        outputLabel.setText(reportType + " generated for " + month + " " + year + ".");
    }


    private String generateDummyReport(String type, String month, String year) {
        if (type.equals("Performance Report")) {
            return "Performance Report - " + month + " " + year + "\n\n"
                    + "Total Cases Handled: 24\n"
                    + "Cases Won: 18\n"
                    + "Cases Lost: 3\n"
                    + "Ongoing Cases: 3\n"
                    + "Average Resolution Time: 25 days\n";
        } else if (type.equals("Billing Report")) {
            return "Billing Report - " + month + " " + year + "\n\n"
                    + "Total Clients Billed: 15\n"
                    + "Total Revenue: $45,000\n"
                    + "Outstanding Payments: $5,000\n"
                    + "Average Billing per Client: $3,000\n";
        } else {
            return "No data available.";
        }
    }
}

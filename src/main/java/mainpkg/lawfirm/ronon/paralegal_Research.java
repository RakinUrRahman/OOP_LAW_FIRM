package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class paralegal_Research
{
    @javafx.fxml.FXML
    private ComboBox<String> yearComboBox;
    @javafx.fxml.FXML
    private TextField keyWordTextField;
    @javafx.fxml.FXML
    private ComboBox<String> jurisdictionComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> typeComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextArea noteTextArea;
    @javafx.fxml.FXML
    private Label resultLabel2;
    @javafx.fxml.FXML
    private Label resultLabel1;
    @javafx.fxml.FXML
    private Label resultLabel3;



    @FXML
    public void initialize() {

        yearComboBox.getItems().addAll("2025", "2024", "2023", "2022", "2021", "2020");
        jurisdictionComboBox.getItems().addAll("Federal", "State", "Local");
        typeComboBox.getItems().addAll("Case Law", "Statute", "Regulation", "Legal Opinion");

        clearResult();

    }

    private void clearResult() {
        resultLabel1.setText("Result1 show here");
        resultLabel2.setText("Result2 show here");
        resultLabel3.setText("Result3 show here");
    }

    @javafx.fxml.FXML
    public void searchOnButtonClicked(ActionEvent actionEvent) {

        String keyword = keyWordTextField.getText().trim();
        String year = yearComboBox.getValue();
        String jurisdiction = jurisdictionComboBox.getValue();
        String type = typeComboBox.getValue();

        if (keyword == null || keyword.isEmpty()) {
            outputLabel.setText("Please enter a keyword.");
            return;
        }

        resultLabel1.setText(keyword+"Case 1(" + year + ", " + jurisdiction + ", " + type + ")");
        resultLabel2.setText(keyword+"Case 2(" + year + ", " + jurisdiction + ", " + type + ")");
        resultLabel3.setText(keyword+"Case 3(" + year + ", " + jurisdiction + ", " + type + ")");

        outputLabel.setText("Search completed successfully.");

    }

    @javafx.fxml.FXML
    public void saveOnButtonClicked(ActionEvent actionEvent) {

        String note = noteTextArea.getText().trim();

        if (note==null || note.isEmpty()) {
            outputLabel.setText("Please enter a note.");
            return;
        }
        outputLabel.setText("Note saved successfully.✅");
    }
}
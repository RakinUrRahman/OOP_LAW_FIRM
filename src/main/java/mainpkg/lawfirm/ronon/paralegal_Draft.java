package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class paralegal_Draft
{
    @javafx.fxml.FXML
    private TextField caseIdTextFile;
    @javafx.fxml.FXML
    private TextField clientTextField;
    @javafx.fxml.FXML
    private ComboBox<String> documentTypeComboBox;
    @javafx.fxml.FXML
    private TextArea termsTextArea;
    @javafx.fxml.FXML
    private DatePicker dateLocalDatePicker;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<paralegal_DraftDocument,String> docTypeCol;
    @javafx.fxml.FXML
    private TableColumn<paralegal_DraftDocument,String> termsCol;
    @javafx.fxml.FXML
    private TableColumn<paralegal_DraftDocument,String> clientCol;
    @javafx.fxml.FXML
    private TableColumn<paralegal_DraftDocument, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<paralegal_DraftDocument, String> caseIdCol;
    @javafx.fxml.FXML
    private TableView<paralegal_DraftDocument> draftTableView;

    private ArrayList<paralegal_DraftDocument> draftList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        docTypeCol.setCellValueFactory(new PropertyValueFactory<>("docType"));
        termsCol.setCellValueFactory(new PropertyValueFactory<>("terms"));
        clientCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        caseIdCol.setCellValueFactory(new PropertyValueFactory<>("caseId"));

        documentTypeComboBox.getItems().addAll("Contract", "Agreement", "Notice", "Letter", "Power of Attorney","Will");

    }

    @javafx.fxml.FXML
    public void saveButtonOnClicked(ActionEvent actionEvent) {

        String documentType = documentTypeComboBox.getValue();
        String caseId = caseIdTextFile.getText().trim();
        String clientName = clientTextField.getText().trim();
        String terms = termsTextArea.getText().trim();
        LocalDate date = dateLocalDatePicker.getValue();

        if  (documentTypeComboBox.getValue() == null) {
            outputLabel.setText("Please select a Doc type.");
            return;
        }
        if (caseIdTextFile.getText().trim().isEmpty()) {
            outputLabel.setText("Please enter a case ID.");
            return;
        }
        if (clientTextField.getText().trim().isEmpty()) {
            outputLabel.setText("Please enter a client name.");
            return;

        }
        if (termsTextArea.getText().trim().isEmpty()) {
            outputLabel.setText("Please enter terms.");
            return;
        }
        if (dateLocalDatePicker.getValue() == null) {
            outputLabel.setText("Please select a date.");
            return;
        }

        for (paralegal_DraftDocument draft : draftList) {
            if (draft.getCaseId().equals(caseId)) {
                outputLabel.setText("Draft with this case ID already exists.");
                return;
            }
        }

        paralegal_DraftDocument newDraft = new paralegal_DraftDocument(documentType, caseId, clientName, date, terms);
        draftList.add(newDraft);
        draftTableView.getItems().add(newDraft);
        outputLabel.setText("Draft saved successfully.");


        documentTypeComboBox.setValue(null);
        caseIdTextFile.clear();
        clientTextField.clear();
        termsTextArea.clear();
        dateLocalDatePicker.setValue(null);



    }


}
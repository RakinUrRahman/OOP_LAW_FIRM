package mainpkg.lawfirm.rakin;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class LawyerCreateCaseController {
    @javafx.fxml.FXML
    private ComboBox<String> lawyerCB;
    @javafx.fxml.FXML
    private TextField caseNameTF;
    @javafx.fxml.FXML
    private ComboBox<String> caseTypeCB;
    @javafx.fxml.FXML
    private TextArea descriptionTA;
    @javafx.fxml.FXML
    private TextField clientNameTF;
    ArrayList<Lawyer_Case> arrayList = new ArrayList<>();
    @javafx.fxml.FXML
    private TextArea outputTA;

    @javafx.fxml.FXML
    public void initialize() {

        caseTypeCB.getItems().addAll("Criminal", "Civil", "Corporate", "Family");
        lawyerCB.getItems().addAll("Arafat", "Rakin", "Turan", "Ronon");


    }


    @javafx.fxml.FXML
    public void submitButtonOnClick(ActionEvent actionEvent) {


        String caseName = caseNameTF.getText();
        String clientName = clientNameTF.getText();
        String caseType = caseTypeCB.getValue();
        String description = descriptionTA.getText();
        String lawyer = lawyerCB.getValue();

        if (caseName.isEmpty() || clientName.isEmpty() || caseType.isEmpty() || description.isEmpty() || lawyer.isEmpty()) {


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Please Fill the fields");
            alert.showAndWait();
        }

        Lawyer_Case lawyer_case = new Lawyer_Case(
                caseNameTF.getText(),
                clientNameTF.getText(),
                caseTypeCB.getValue(),
                descriptionTA.getText(),
                lawyerCB.getValue()


        );

        arrayList.add(lawyer_case);

        outputTA.clear();
        outputTA.setText(lawyer_case.toString());


    }

    @javafx.fxml.FXML
    public void LawyerClientMessagesButtonOnClick(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void lawyerLogoutButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LawyerSubmitReportButtonOnClick(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void lawyerMyCasesButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void lawyerCloseCaseButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void lawyerAskExpertButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LawyerJoinHearingButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void lawyerDashboardButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void lawyerCreateCaseButtonOnClick(ActionEvent actionEvent) {
    }
}
package mainpkg.lawfirm.rakin;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
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
    private static final String FILE_NAME = "cases.dat";

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
            return;
        }

        Lawyer_Case newCase = new Lawyer_Case(caseName, clientName, caseType, description, lawyer);

        arrayList.add(newCase);
        LawyerMyCasesController.globalCasesList.add(newCase);


        outputTA.setText("Case Saved:\n" + newCase);

        caseNameTF.clear();
        clientNameTF.clear();
        caseTypeCB.setValue(null);
        descriptionTA.clear();
        lawyerCB.setValue(null);


    }


    @javafx.fxml.FXML
    public void LawyerClientMessagesButtonOnClick(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/lawyer_Client_Messages.fxml"));
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
    public void lawyerLogoutButtonOnClick(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/Login_Page.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();

            ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void LawyerSubmitReportButtonOnClick(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/lawyer_submit_report.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Submit Report");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void lawyerMyCasesButtonOnClick(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/lawyer_my_cases.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("My Cases");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void lawyerCloseCaseButtonOnClick(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/lawyer_close_case.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Close Case");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void lawyerAskExpertButtonOnClick(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/lawyer_ask_expert_help.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Ask Expert");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void LawyerJoinHearingButtonOnClick(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/lawyer_join_hearing.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Join Hearing");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void lawyerDashboardButtonOnClick(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/lawyer_dashboardashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void lawyerCreateCaseButtonOnClick(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/lawyer_Create_Case.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Create Case");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

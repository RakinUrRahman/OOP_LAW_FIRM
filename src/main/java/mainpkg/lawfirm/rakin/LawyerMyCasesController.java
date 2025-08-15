package mainpkg.lawfirm.rakin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LawyerMyCasesController
{
    @javafx.fxml.FXML
    private TableView<Lawyer_Case> lawyerMyCasesTV;
    @javafx.fxml.FXML
    private AnchorPane mainContentPane;
    @javafx.fxml.FXML
    private TextField lawyerSearchCaseIdTF;
    @javafx.fxml.FXML
    private TextArea outputTA;
    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String> caseNameCol;
    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String>  statusCol;
    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String>  clientNameCol;
    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String>  caseIdCol;
    @javafx.fxml.FXML
    private TableColumn <Lawyer_Case, String> lawyerCol;
    @javafx.fxml.FXML
    private TableColumn <Lawyer_Case, String> caseTypeCol;
    @javafx.fxml.FXML
    private TableColumn <Lawyer_Case, String> descriptionCol;


    ObservableList<Lawyer_Case> tableData = FXCollections.observableArrayList();
    public static ArrayList<Lawyer_Case> globalCasesList = new ArrayList<>();
    private static final String FILE_NAME = System.getProperty("user.home") + "/cases.dat";



    @javafx.fxml.FXML
    public void initialize() {

        caseIdCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("caseId"));
        caseNameCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("caseName"));
        clientNameCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("clientName"));
        caseTypeCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("caseType"));
        descriptionCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("description"));
        lawyerCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("lawyer"));

        lawyerMyCasesTV.setItems(tableData);
    }




    @javafx.fxml.FXML
    public void loadAllCasesButtonOnClick(ActionEvent actionEvent) {
        tableData.clear();
        tableData.addAll(LawyerMyCasesController.globalCasesList);
        outputTA.setText("Loaded " + tableData.size() + " cases from memory.");
    }

    @FXML
    public void searchButtonOnClick(ActionEvent actionEvent) {
        String searchText = lawyerSearchCaseIdTF.getText().trim().toLowerCase();
        if (searchText.isEmpty()) {
            outputTA.setText("Enter Case ID or Case Name to search.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Lawyer_Case c : tableData) {
            if (c.getCaseId().toLowerCase().contains(searchText) ||
                    c.getCaseName().toLowerCase().contains(searchText)) {
                sb.append(c).append("\n\n");
            }
        }


        if (sb.isEmpty()) {
            outputTA.setText("No cases found for: " + searchText);
        } else {
            outputTA.setText(sb.toString());
        }
    }



    @FXML
        public void generateReportButtonOnClick(ActionEvent actionEvent) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                oos.writeObject(new ArrayList<>(tableData));
                outputTA.setText("Report saved successfully as " + FILE_NAME);
            } catch (IOException e) {
                e.printStackTrace();
                outputTA.setText("Failed to save report.");
            }
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/LoginPage.fxml"));
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

    @Deprecated
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


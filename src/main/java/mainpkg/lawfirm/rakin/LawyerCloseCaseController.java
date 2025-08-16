package mainpkg.lawfirm.rakin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class LawyerCloseCaseController {

    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String> caseNameCol;
    @javafx.fxml.FXML
    private TableView<Lawyer_Case> lawyerMyCasesTV;
    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String> clientNameCol;
    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String> caseIdCol;
    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String> lawyerCol;
    @javafx.fxml.FXML
    private TextField searchCaseIDTF;
    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String> caseTypeCol;
    @javafx.fxml.FXML
    private TableColumn<Lawyer_Case, String> descriptionCol;

    private static final String FILE_NAME = System.getProperty("user.home") + "/cases.bin";
    ObservableList<Lawyer_Case> tableData = FXCollections.observableArrayList();


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
    public void loadBinFileButtonOnClick(ActionEvent actionEvent) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ArrayList<Lawyer_Case> loadedCases = (ArrayList<Lawyer_Case>) ois.readObject();

            tableData.clear();
            tableData.addAll(loadedCases);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void generateReportButtonOnClick(ActionEvent actionEvent) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(new ArrayList<>(tableData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void closeCaseButtonOnClick(ActionEvent actionEvent) {
        String searchText = searchCaseIDTF.getText().trim();

        if (searchText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Empty");
            alert.setContentText("Please Type In The Field");
            alert.showAndWait();
            return;
        }

        Lawyer_Case caseToRemove = null;

        for (Lawyer_Case lc : tableData) {
            if (lc.getCaseId().equalsIgnoreCase(searchText) ||
                    lc.getCaseName().equalsIgnoreCase(searchText)) {
                caseToRemove = lc;
                break;
            }
        }

        if (caseToRemove != null) {
            tableData.remove(caseToRemove);
            lawyerMyCasesTV.getItems().remove(caseToRemove); // update table

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Removed");
            alert.setContentText("Case Closed");
            alert.showAndWait();
            return;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not Found");
            alert.setContentText("Case Not FOund");
            alert.showAndWait();
            return;
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

    @FXML
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


    @Deprecated
    public void lawyerDraftDocumentsButtonOnClick(ActionEvent actionEvent) {
    }
}


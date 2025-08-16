package mainpkg.lawfirm.rakin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class FinancialOfficerClientPaymentController {

    private static final String FILE_NAME = "Payments.bin";

    @FXML
    private TableColumn<ClientPayment, String> caseRefCol;
    @FXML
    private TableColumn<ClientPayment, String> paymentDateCol;
    @FXML
    private TableColumn<ClientPayment, Double> amountCol;
    @FXML
    private TableColumn<ClientPayment, String> statusCol;
    @FXML
    private TableColumn<ClientPayment, String> clientNameCol;
    @FXML
    private TableColumn<ClientPayment, String> paymentMethodCol;
    @FXML
    private TableView<ClientPayment> clientPaymentTable;

    private ObservableList<ClientPayment> paymentList = FXCollections.observableArrayList();
    private static final String FILE = System.getProperty("user.home") + "/clientPayments.bin";

    @javafx.fxml.FXML
    public void initialize() {
        caseRefCol.setCellValueFactory(new PropertyValueFactory<>("caseRef"));
        paymentDateCol.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        clientNameCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        paymentMethodCol.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));


        paymentList.addAll(
                new ClientPayment("CASE-1001", "2025-08-16", 5000.0, "Paid", "Ronon", "Cash"),
                new ClientPayment("CASE-1002", "2025-08-15", 3000.0, "Pending", "Rakin", "Bank Transfer"),
                new ClientPayment("CASE-1003", "2025-08-14", 4500.0, "Paid", "Turan", "Card"),
                new ClientPayment("CASE-1004", "2025-08-14", 2500.0, "Paid", "Arafat", "Card")

        );
        clientPaymentTable.setItems(paymentList);

    }

    @FXML
    public void generateReportButtonOnAction(ActionEvent actionEvent) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(new ArrayList<>(paymentList));
            showAlert("Success", "Report saved successfully as " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save report.");
        }
    }



    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }



    @javafx.fxml.FXML
    public void foexportFinancialsButtonOnCLick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/financial_officer_export_statements.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Export Statements");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void foupdateBillingRatesButtonOnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/financial_officer_update_billings.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Update Billings");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void fogenerateReportPageButtonOnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/financial_officer_financial_report.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Update Billings");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @javafx.fxml.FXML
    public void fologoutButtonOnCLick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/Login_Page.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Update Billings");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void fologTransactionsButtonOnCLick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/financial_officer_new_transactions.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Update Billings");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void foapproveRejectPaymentPageButtonOnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/financial_officer_approve_reject_payment.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Update Billings");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void fomonitorDuesButtonOnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/financial_officer_dues.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Dues");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void foauditBillingErrorsButtonOnCLick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/financial_officer_audit.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Dues");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void foClientPaymentHistoryButtonOnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/financial_officer_client_payment.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Dues");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void ofDashboardButtonOnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/financial_officer_dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Dues");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
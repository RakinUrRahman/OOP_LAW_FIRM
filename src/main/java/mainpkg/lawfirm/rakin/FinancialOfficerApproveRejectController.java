package mainpkg.lawfirm.rakin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class FinancialOfficerApproveRejectController {

    @FXML
    private TableView<foPaymentRequest> foApprovePaymentsTV;
    @FXML
    private TableColumn<foPaymentRequest, String> foApprovePaymentsRequestIdCol;
    @FXML
    private TableColumn<foPaymentRequest, String> foApprovePaymentsClientNameCol;
    @FXML
    private TableColumn<foPaymentRequest, Double> foApprovePaymentsAmountCol;

    @FXML
    private javafx.scene.control.TextField foApprovePaymentsRequestIdTF;
    @FXML
    private javafx.scene.control.TextField foApprovePaymentsClientNameTF;
    @FXML
    private javafx.scene.control.TextField foApprovePaymentsAmountTF;
    @FXML
    private TableColumn<foPaymentRequest, String> foApprovePaymentsStatusCol;

    @FXML
    private javafx.scene.control.TextArea foApprovePaymentsCommtentTA;

    private ObservableList<foPaymentRequest> requestList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<foPaymentRequest, String> foApprovePaymentsDateRequestedCol;
    @FXML
    private TableColumn<foPaymentRequest, String> foApprovePaymentsPurposeCol;

    @FXML
    public void initialize() {
        foApprovePaymentsRequestIdCol.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        foApprovePaymentsClientNameCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        foApprovePaymentsAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        foApprovePaymentsStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));


        // Add dummy data
        requestList.addAll(
                new foPaymentRequest("REQ-1001", "Rakin", 5000),
                new foPaymentRequest("REQ-1002", "Ronon", 3000),
                new foPaymentRequest("REQ-1003", "Turan", 4500)
        );

        foApprovePaymentsTV.setItems(requestList);
    }

    @FXML
    public void approveButtonOnClick(ActionEvent actionEvent) {
        processRequest("Approved");
    }

    @FXML
    public void rejectButtonOnClick(ActionEvent actionEvent) {
        processRequest("Rejected");
    }

    private void processRequest(String status) {
        String id = foApprovePaymentsRequestIdTF.getText().trim();
        String client = foApprovePaymentsClientNameTF.getText().trim();
        String amountText = foApprovePaymentsAmountTF.getText().trim();

        if (id.isEmpty() || client.isEmpty() || amountText.isEmpty()) return;

        double amount;
        amount = Double.parseDouble(amountText);



        for (foPaymentRequest req : requestList) {
            if (req.getRequestId().equalsIgnoreCase(id) &&
                    req.getClientName().equalsIgnoreCase(client) &&
                    req.getAmount() == amount) {
                req.setStatus(status);
                foApprovePaymentsTV.refresh();

                foApprovePaymentsRequestIdTF.clear();
                foApprovePaymentsClientNameTF.clear();
                foApprovePaymentsAmountTF.clear();
                foApprovePaymentsCommtentTA.clear();

                break;
            }
        }
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/rakin/Login_Page.fxml"));
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

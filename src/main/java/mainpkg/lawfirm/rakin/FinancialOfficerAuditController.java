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

public class FinancialOfficerAuditController {

    @FXML
    private TableView<foAuditRecord> foAuditsTV;

    @FXML
    private TableColumn<foAuditRecord, String> errorIdCol;

    @FXML
    private TableColumn<foAuditRecord, String> clientIdCol;

    @FXML
    private TableColumn<foAuditRecord, String> descriptionCol;

    @FXML
    private TableColumn<foAuditRecord, Double> amountCol;

    @FXML
    private TableColumn<foAuditRecord, String> statusCol;

    @FXML
    private TableColumn<foAuditRecord, Void> actionCol;

    private final ObservableList<foAuditRecord> auditData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Setup TableView columns
        errorIdCol.setCellValueFactory(new PropertyValueFactory<>("errorId"));
        clientIdCol.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Example data
        auditData.add(new foAuditRecord("E001", "C123", "Incorrect billing rate", 120.0, "Pending"));
        auditData.add(new foAuditRecord("E002", "C456", "Duplicate invoice", 250.5, "Pending"));

        foAuditsTV.setItems(auditData);
    }

    @FXML
    public void flagButtonOnClick(ActionEvent actionEvent) {
        foAuditRecord selected = foAuditsTV.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Resolved");
            foAuditsTV.refresh();
        }
    }

    @FXML
    public void resolvedButtonOnClick(ActionEvent actionEvent) {
        foAuditRecord selected = foAuditsTV.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("For Review");
            foAuditsTV.refresh();
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
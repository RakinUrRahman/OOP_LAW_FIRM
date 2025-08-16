package mainpkg.lawfirm.rakin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

public class LawyerMessageController {

    @javafx.fxml.FXML
    private TableView<LawyerMessage> lawyerMessageTV;
    @javafx.fxml.FXML
    private TextArea lawyerMessageNewMessageTA;
    @javafx.fxml.FXML
    private TableColumn<LawyerMessage, String> lawyerMessageSenderCol;
    @javafx.fxml.FXML
    private TableColumn<LawyerMessage, String> lawyerMessageMessageCol;
    @javafx.fxml.FXML
    private TableColumn<LawyerMessage, String> lawyerMessageRecipientCol;
    @javafx.fxml.FXML
    private ComboBox<String> lawyerMessageRecipientCB;
    @javafx.fxml.FXML
    private TableColumn<LawyerMessage, LocalDateTime> lawyerTimeCol;

    private final String currentLawyerName = "Rakin";

    private final ObservableList<LawyerMessage> tableData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        lawyerMessageSenderCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("sender"));
        lawyerMessageRecipientCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("recipient"));
        lawyerMessageMessageCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("message"));
        lawyerTimeCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("time"));

        lawyerMessageTV.setItems(tableData);

        lawyerMessageRecipientCB.getItems().addAll("Arafat", "Rakin", "Turan", "Ronon");
        lawyerMessageRecipientCB.getItems().remove(currentLawyerName);

        refreshTable();
    }

    @javafx.fxml.FXML
    public void lawyerMessageSendButtonOnClick(ActionEvent actionEvent) {
        String recipient = lawyerMessageRecipientCB.getValue();
        String messageText = lawyerMessageNewMessageTA.getText();

        if (recipient == null || messageText.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Empty Fields");
            alert.setContentText("Please select a recipient and type a message.");
            alert.showAndWait();
            return;
        }

        LawyerMessage msg = new LawyerMessage(currentLawyerName, recipient, messageText, LocalDateTime.now());
        List.allMessages.add(msg);

        lawyerMessageNewMessageTA.clear();

        refreshTable();
    }

    private void refreshTable() {
        tableData.clear();
        for (LawyerMessage msg : List.allMessages) {
            if (msg.getRecipient().equals(currentLawyerName) || msg.getSender().equals(currentLawyerName)) {
                tableData.add(msg);
            }
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
}


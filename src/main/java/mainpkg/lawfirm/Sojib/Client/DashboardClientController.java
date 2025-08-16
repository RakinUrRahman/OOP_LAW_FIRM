package mainpkg.lawfirm.Sojib.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardClientController {

    @FXML
    void BookConsultationButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Client/bookConsultation.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("BookConsultation");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void ContactLawyerButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Client/communicateWithLawyer.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("communicateWithLawyer");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void PayLegalFeesButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Client/payFees.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("PayFees");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void backButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/Login_Page.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Export Statements");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void registerClientButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Client/registerClient.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("ClientRegistration");
        window.setScene(scene2);
        window.show();
    }



    @FXML
    void requestCaseClosureButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Client/requestCaseClosure.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("requestCaseClosure");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void submitDocumentsButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Client/submitCaseDocuments .fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("SubmitCaseDocuments");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void submitFeedbackButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Client/submitFeedback.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("SubmitFeedback");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void trackCaseProgressButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Client/trackCaseProgress.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("trackCaseProgress");
        window.setScene(scene2);
        window.show();
    }

}

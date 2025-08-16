package mainpkg.lawfirm.Sojib.Legal_Intern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardOfLegalInternController {

    @FXML
    public void initialize() {
    }


    @FXML
    void accessAssignedCasesButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Legal_Intern/accessAssignedCases .fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("AccessAssignedCases");
        window.setScene(scene2);
        window.show();
    }


    @FXML
    void attendCourtSessionsButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Legal_Intern/courtSessions.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("courtSessions");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void conductLegalResearchButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Legal_Intern/conductResearch.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("ConductResearch");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void draftLegalDocumentsButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Legal_Intern/draftDocuments.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("DraftDocuments");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void fileAndOrganizeDigitalRecordButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Legal_Intern/organizeDigitalRecords.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("OrganizeDigitalRecords");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void prepareCaseSummariesButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Legal_Intern/caseSummaries.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CaseSummaries");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void receiveInternshipEvaluationButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Legal_Intern/internshipEvaluation.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("InternshipEvaluation");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void scheduleInternalMeetingButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Legal_Intern/scheduleInternalMeetings.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("ScheduleInternalMeetings");
        window.setScene(scene2);
        window.show();
    }

}

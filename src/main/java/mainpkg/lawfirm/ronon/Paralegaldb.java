package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainpkg.lawfirm.HelloApplication;

public class Paralegaldb
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void casenNoteTrackOnButtonClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/mainpkg/lawfirm/ronon/paralegal_note.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("note !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void draftDoccumentOnButtonClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/mainpkg/lawfirm/ronon/paralegal_draft.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("draft !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void clientRecordOnButtonClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/mainpkg/lawfirm/ronon/paralegal_clientrecord.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("client record !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void caseReportOnButtonClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/mainpkg/lawfirm/ronon/paralegal_courtfiling.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Court Filling !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }

    }

    @javafx.fxml.FXML
    public void courtCalendarOnButtonClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/mainpkg/lawfirm/ronon/paralegal_courtcalendar.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Court Calendar !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void casePreparationOnButtonClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/mainpkg/lawfirm/ronon/paralegal_case.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Case !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void clientCommunicationOnButtonClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/mainpkg/lawfirm/ronon/paralegal_Communication.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Communation !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void researchCaseOnButtonClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/mainpkg/lawfirm/ronon/paralegal_research.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Research !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }
}
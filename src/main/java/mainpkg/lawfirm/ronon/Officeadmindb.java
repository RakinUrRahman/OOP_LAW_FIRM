package mainpkg.lawfirm.ronon;



import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainpkg.lawfirm.HelloApplication;

public class Officeadmindb
{
    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void handlePostNoticeOnClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/mainpkg/lawfirm/ronon/officeadmin_notice.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Notice !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void handleStaffRecordOnClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("officeadmin_staffrecord.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("staff record!");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void handleGenerateReportsOnClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("officeadmin_genaratereport.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("genarate report!");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void handleManageCalendarOnClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("officeadmin_managecalendar.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Manage Calendar!");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void handleUpdateCaseStatusOnClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("officeadmin_casestatus.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Case Status!");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void handleScheduleMeetingsOnClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("officeadmin_schedulemeeting.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Schedule Meeting !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void handleInventoryOnClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("officeadmin_inventory.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Inventory !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }

    }

    @javafx.fxml.FXML
    public void handleManageStaffOnClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("officeadmin_staffmanage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Staff Manage !");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {

        }
    }
}
package mainpkg.lawfirm.turan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ScheduleMeetingController
{
    @javafx.fxml.FXML
    private CheckBox ParalegalCheckB;
    @javafx.fxml.FXML
    private RadioButton onlinerb;
    @javafx.fxml.FXML
    private CheckBox LawyerCheckb;
    @javafx.fxml.FXML
    private DatePicker meetingdp;
    @javafx.fxml.FXML
    private RadioButton inpersonrb;
    @javafx.fxml.FXML
    private TextField meetinttitleTf;
    @javafx.fxml.FXML
    private ComboBox<String> selectcasecbcb;
    @javafx.fxml.FXML
    private Label errormsglabel;

    @javafx.fxml.FXML
    public void initialize() {
        selectcasecbcb.getItems().addAll("C001", "C002", "C003", "C004");

    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainpkg/lawfirm/turan/casemanager_dashboard.fxml.fxml"));
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
    public void schedulebuttonhandle(ActionEvent actionEvent) {
        String title = meetinttitleTf.getText();
        String selectedCase = selectcasecbcb.getValue();
        boolean lawyer = LawyerCheckb.isSelected();
        boolean paralegal = ParalegalCheckB.isSelected();
        boolean inPerson = inpersonrb.isSelected();
        boolean online = onlinerb.isSelected();
        String date = meetingdp.getValue() != null ? meetingdp.getValue().toString() : "";

        if (title.isEmpty() || selectedCase == null || (!lawyer && !paralegal) || (!inPerson && !online) || date.isEmpty()) {
            errormsglabel.setText("Please fill in all fields.");
            return;
        }
    }
}
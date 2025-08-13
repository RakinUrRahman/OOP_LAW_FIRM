package turan;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class PostJobController
{
    @javafx.fxml.FXML
    private TextField jobpost;
    @javafx.fxml.FXML
    private RadioButton parttimerb;
    @javafx.fxml.FXML
    private DatePicker applideadlinedp;
    @javafx.fxml.FXML
    private RadioButton fulltimerb;
    @javafx.fxml.FXML
    private ComboBox<String> deptcb;
    @javafx.fxml.FXML
    private ComboBox<String> experiencecb;
    @javafx.fxml.FXML
    private TextField jobdescriptiontextbox;
    @javafx.fxml.FXML
    private Label errormsglabel;

    @javafx.fxml.FXML
    public void initialize() {
        deptcb.getItems().addAll("HR", "Finance", "IT", "Marketing");
        experiencecb.getItems().addAll("Fresher", "1-2 years", "3-5 years", "5+ years");

        errormsglabel.setText("Error! Input Correct");

        fulltimerb.setOnAction(e -> {
            if (fulltimerb.isSelected()) {
                parttimerb.setSelected(false);
            }
        });

        parttimerb.setOnAction(e -> {
            if (parttimerb.isSelected()) {
                fulltimerb.setSelected(false);
            }
        });

    }

    @javafx.fxml.FXML
    public void postjobhandle(ActionEvent actionEvent) {
        String jobTitle = jobpost.getText();
        String jobType = fulltimerb.isSelected() ? "Full Time" :
                parttimerb.isSelected() ? "Part Time" : null;
        LocalDate deadline = applideadlinedp.getValue();
        String department = deptcb.getValue();
        String experience = experiencecb.getValue();
        String jobDescription = jobdescriptiontextbox.getText();

        if (jobTitle.isEmpty() || jobType == null || deadline == null ||
                department == null || experience == null || jobDescription.isEmpty()) {
            errormsglabel.setText("Please fill in all fields.");
            return;


        }

    }

    @javafx.fxml.FXML
    public void backbuttonhandle(ActionEvent actionEvent) {
    }}

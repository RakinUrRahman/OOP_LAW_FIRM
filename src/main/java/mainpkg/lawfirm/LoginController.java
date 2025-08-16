package mainpkg.lawfirm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class LoginController {

    @FXML
    private ComboBox<String> roleCB;

    @FXML
    private TextField nameTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
        // Populate the ComboBox with roles
        roleCB.getItems().addAll(
                "Lawyer",
                "Client",
                "Financial Officer",
                "Office Administrator",
                "Paralegal",
                "Legal Intern",
                "Senior Partner"
        );

        roleCB.getSelectionModel().selectFirst();
    }

    @FXML
    public void loginButtonOnClick(ActionEvent actionEvent) {
        String selectedRole = roleCB.getValue();
        String username = nameTF.getText();
        String password = passwordTF.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Please enter username and password.");
            return;
        }

        try {
            javafx.stage.Stage stage = (javafx.stage.Stage) loginButton.getScene().getWindow();
            javafx.scene.Parent root = null;

            switch (selectedRole) {
                case "Lawyer":
                    root = javafx.fxml.FXMLLoader.load(getClass().getResource("/mainpkg/lawfirm/rakin/lawyer_dashboard.fxml"));
                    break;
                case "Client":
                    root = javafx.fxml.FXMLLoader.load(getClass().getResource("ClientDashboard.fxml"));
                    break;
                case "Financial Officer":
                    root = javafx.fxml.FXMLLoader.load(getClass().getResource("/mainpkg/lawfirm/rakin/financial_officer_dashboard.fxml"));
                    break;
                case "Office Administrator":
                    root = javafx.fxml.FXMLLoader.load(getClass().getResource("/mainpkg/lawfirm/ronon/officeadmindb.fxml"));
                    break;
                case "Paralegal":
                    root = javafx.fxml.FXMLLoader.load(getClass().getResource("/mainpkg/lawfirm/ronon/paralegaldb.fxml"));
                    break;
                case "Case Manager":
                    root = javafx.fxml.FXMLLoader.load(getClass().getResource("/mainpkg/lawfirm/turan/hr_dashboard.fxml"));
                    break;
                case "HR Manager":
                    root = javafx.fxml.FXMLLoader.load(getClass().getResource("/mainpkg/lawfirm/turan/casemanager_dashboard.fxml"));
                    break;
            }

            if (root != null) {
                stage.getScene().setRoot(root); // Switch to new page
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

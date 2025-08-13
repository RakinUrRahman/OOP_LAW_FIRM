package mainpkg;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LoginPageController {
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField userIdTextField;


    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Login Page");

        String id, password;
        boolean flag = true;

        Alert alert = new Alert(Alert.AlertType.ERROR);

        id = userIdTextField.getText();
        password = passwordTextField.getText();


        if (id.isBlank()) {

            flag = false;
            alert.setTitle("User Id Error");
            alert.setContentText("User Id Can Not Be Blank");
            alert.showAndWait();



        }
        if (password.isBlank()) {

            flag = false;
            alert.setTitle("Password Id Error");
            alert.setContentText("Password Id Can Not Be Blank");
            alert.showAndWait();

        }
        if (flag) {
            if (id.length() == 5) {
                //Login As a Admin
            } else if (id.length() == 6) {
                //Login As a Lawyer
            } else if (id.length() == 7) {
                //Login As a Financial Officer
            } else if (id.length() == 8) {
                //Login As a consultant
            } else if (id.length() == 9) {
                //Login As a Client
            } else if (id.length() == 10) {
                //Login As a HR
            } else if (id.length() == 11) {
                //Login As a Case Manager
            } else if (id.length() == 12) {
                //Login As a Paralegal Assistant
            } else {
                alert.setTitle("User Id Error");
                alert.setContentText("User Id Type Does Not Exist");
                alert.showAndWait();

            }

        }
    }

    @javafx.fxml.FXML
    public void createAccountButtonOnAccount(ActionEvent actionEvent) {
    }

}
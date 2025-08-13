package mainpkg;


import javafx.event.ActionEvent;
import javafx.scene.control.*;
import mainpkg.rakin.Lawyer;

import java.time.LocalDate;


public class CreateAccountPageController
{
    @javafx.fxml.FXML
    private TextArea outputTA;
    @javafx.fxml.FXML
    private TextField phoneNoTextField;
    @javafx.fxml.FXML
    private RadioButton maleRB;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private DatePicker dobDatePicker;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private TextArea addressTextArea;
    @javafx.fxml.FXML
    private RadioButton femaleRB;
    @javafx.fxml.FXML
    private RadioButton otherRB;
    @javafx.fxml.FXML
    private PasswordField emergencyContactTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createAccountButtonOnAction(ActionEvent actionEvent) {

        String name, email, phone, gender = "",  emergency , address, password;
        LocalDate dob;
        boolean flag = true;


        name= nameTextField.getText();
        email = emailTextField.getText();
        phone= phoneNoTextField.getText();
        emergency= emergencyContactTF.getText();
        address = addressTextArea.getText();
        password = passwordField.getText();
        dob = dobDatePicker.getValue();

        if (maleRB.isSelected()){
            gender = "Male" ;

        } else if (femaleRB.isSelected()) {
            gender = "Female" ;


        }else if (otherRB.isSelected()) {
            gender = "Others" ;


        }
        Lawyer lawyer = new Lawyer(name, phone, email, address, gender, password, dob, 2,  emergency) ;

        outputTA.clear();
        outputTA.setText(lawyer.toString() );


        nameTextField.clear();
        emailTextField.clear();
        phoneNoTextField.clear();
        emergencyContactTF.clear();
        addressTextArea.clear();
        passwordField.clear();

    }
}
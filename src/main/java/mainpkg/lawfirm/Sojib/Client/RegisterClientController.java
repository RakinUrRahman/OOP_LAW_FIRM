package mainpkg.lawfirm.Sojib.Client;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpkg.lawfirm.Sojib.Client.AppendableObjectOutPutStream;
import mainpkg.lawfirm.Sojib.Client.RegisterClient;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterClientController {

    @FXML
    private TableColumn<LocalDate, RegisterClient> DateOfRegColumn;

    @FXML
    private TextArea addressTextArea;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private TableColumn<String, RegisterClient>  emailColumn;

    @FXML
    private TextField emailTextField;

    @FXML
    private TableColumn<String, RegisterClient> genderColumn;

    @FXML
    private ComboBox<String> genderComboBox;

    @FXML
    private TableColumn<String, RegisterClient> nameColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableColumn<Integer, RegisterClient> phoneNoColumn;

    @FXML
    private TextField phoneNoTextField;

    @FXML
    private TableView<RegisterClient> tableView;
    @FXML
    private TextField occupationTextField;

    @javafx.fxml.FXML
    public void initialize() {
        loadAllData();
        genderComboBox.getItems().addAll("Male", "Female");
        DateOfRegColumn.setCellValueFactory(new PropertyValueFactory<>("dateofBirth"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("clientname"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNoColumn.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

    }


    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainpkg/lawfirm/Sojib/Client/dashboardClient.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void registerButton(ActionEvent event) {
        tableView.getItems().clear();
        String clientname = nameTextField.getText();
        String email = emailTextField.getText();
        String occupation = occupationTextField.getText();
        int phoneNo = Integer.parseInt(phoneNoTextField.getText());
        LocalDate dob = dobPicker.getValue();
        String address = addressTextArea.getText();
        String gender = genderComboBox.getValue();

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("RegisterClient.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            RegisterClient y = new RegisterClient(clientname, email, phoneNo, occupation, address, dob, gender);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(RegisterClientController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(RegisterClientController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }


    @FXML
    public void loadAllDataButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        loadAllData();

    }

    public void loadAllData() {
        ObjectInputStream ois = null;
        try {
            RegisterClient y;
            ois = new ObjectInputStream(new FileInputStream("RegisterClient.bin"));
            while (true) {
                y = (RegisterClient) ois.readObject();
                tableView.getItems().add(y);
            }
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }
    }
}
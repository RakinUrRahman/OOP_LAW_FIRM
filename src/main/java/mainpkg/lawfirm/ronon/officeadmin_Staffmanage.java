package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class officeadmin_Staffmanage
{
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Staff, String> accessCol;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Staff, Integer> contactCol;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Staff,String> nameCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> roleComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> accessComboBox;
    @javafx.fxml.FXML
    private TextField contactTextField;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_Staff,String> roleCol;
    @javafx.fxml.FXML
    private TableView<officeadmin_Staff> staffTable;

    ArrayList<officeadmin_Staff> staffList = new ArrayList<>();
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        accessCol.setCellValueFactory(new PropertyValueFactory<>("accessLevel"));

        roleComboBox.getItems().addAll("Lawyer", "Admin","HR","Paralegal","Intern");
        accessComboBox.getItems().addAll("Read ", "Full Access", "Limited Access");

    }

    @javafx.fxml.FXML
    public void handleSaveOnClicked(ActionEvent actionEvent) {

        if(nameTextField.getText().trim().isEmpty()){
            outputLabel.setText("Please enter a name.");
            return;
        }
        if(contactTextField.getText().trim().isEmpty()){
            outputLabel.setText("Please enter a contact number.");
            return;
        }
        if(roleComboBox.getValue() == null) {
            outputLabel.setText("Please select a role.");
            return;
        }
        if(accessComboBox.getValue() == null) {
            outputLabel.setText("Please select an access level.");
            return;
        }

        for (officeadmin_Staff s : staffList) {
            if (s.getName().equals(nameTextField.getText())) {
                outputLabel.setText("Staff member already exists.");
                return;
            }
        }

        String name  = nameTextField.getText();
        String role = roleComboBox.getValue();
        Integer contact = Integer.parseInt(contactTextField.getText());
        String accessLevel = accessComboBox.getValue();

        officeadmin_Staff staff = new officeadmin_Staff(name, role, contact, accessLevel);
        staffList.add(staff);
        staffTable.getItems().add(staff);

        outputLabel.setText("Staff member added successfully.");

        nameTextField.clear();
        contactTextField.clear();
        roleComboBox.setValue(null);
        accessComboBox.setValue(null);

    }
}
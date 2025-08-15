package mainpkg.lawfirm.ronon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class officeadmin_Staffrecord {

    @FXML private TableView<officeadmin_StaffMember> staffTableView;
    @FXML private TableColumn<officeadmin_StaffMember, String> nameCol;
    @FXML private TableColumn<officeadmin_StaffMember, String> roleCol;
    @FXML private TableColumn<officeadmin_StaffMember, String> phoneCol;
    @FXML private TableColumn<officeadmin_StaffMember, String> emailCol;

    @FXML private TextField nameTextField;
    @FXML private ComboBox<String> roleComboBox;
    @FXML private TextField phoneTextField;
    @FXML private TextField emailTextField;

    @FXML private Label outputLabel;

    private final ObservableList<officeadmin_StaffMember> staffList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        roleComboBox.getItems().addAll("Lawyer", "Paralegal", "Office Admin", "Receptionist");

        staffList.add(new officeadmin_StaffMember("Turan", "Lawyer", "15484555555", "turan@gmail.com"));
        staffList.add(new officeadmin_StaffMember("Rakin", "Admin", "15484555556", "rakin@gmail.com"));

        staffTableView.setItems(staffList);
    }

    @FXML
    public void addOnButtonClicked(ActionEvent event) {
        String name = nameTextField.getText().trim();
        String role = roleComboBox.getValue();
        String phone = phoneTextField.getText().trim();
        String email = emailTextField.getText().trim();

        if (name.isEmpty() || role == null || phone.isEmpty() || email.isEmpty()) {
            outputLabel.setText("Fill all fields.");
            return;
        }

        for (officeadmin_StaffMember s : staffList) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                outputLabel.setText("Email already exists.");
                return;
            }
        }

        staffList.add(new officeadmin_StaffMember(name, role, phone, email));

        outputLabel.setText("Added: " + name);
        clearForm();
    }

    @FXML
    public void deleteOnClickedButton(ActionEvent event) {
        officeadmin_StaffMember selected = staffTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            outputLabel.setText("Select staff to delete.");
            return;
        }
        staffList.remove(selected);
        outputLabel.setText("Deleted: " + selected.getName());
        clearForm();
    }

    private void clearForm() {
        nameTextField.clear();
        roleComboBox.getSelectionModel().clearSelection();
        phoneTextField.clear();
        emailTextField.clear();
        staffTableView.getSelectionModel().clearSelection();
    }
}
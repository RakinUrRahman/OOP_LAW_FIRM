package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class paralegal_Clientrecord
{
    @javafx.fxml.FXML
    private TableColumn phoneCol;
    @javafx.fxml.FXML
    private TextField phoneNoTextField;
    @javafx.fxml.FXML
    private TextField clientIdTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<paralegal_Client,String> clientCol;
    @javafx.fxml.FXML
    private TableColumn<paralegal_Client,String> statusCol;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TableColumn<paralegal_Client,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<paralegal_Client,String> caseIdCol;
    @javafx.fxml.FXML
    private TextField caseTextField;
    @javafx.fxml.FXML
    private TableColumn<paralegal_Client,String> emailCol;
    @javafx.fxml.FXML
    private TableView<paralegal_Client> recordTableView;

    ArrayList<paralegal_Client> clientList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        statusComboBox.getItems().addAll("Active", "Close", "Pending");

        clientCol.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        caseIdCol.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));


    }

    @javafx.fxml.FXML
    public void addButtonOnClicked(ActionEvent actionEvent) {

        String clientId = clientIdTextField.getText().trim();
        String name = nameTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String phone = phoneNoTextField.getText().trim();
        String caseId = caseTextField.getText().trim();
        String status = statusComboBox.getValue();

        if (clientId.isEmpty() || name.isEmpty() || email.isEmpty()|| caseId.isEmpty()||status==null || phone.isEmpty()){
            outputLabel.setText("Please fill All field before adding");
            return;
        }

        for (paralegal_Client client: clientList){
            if (client.getClientId().equals(clientId)){
                outputLabel.setText("Client ID already exists.");
                return;
            }

        }

        paralegal_Client client = new paralegal_Client((clientId), name, email, phone, caseId, status);
        clientList.add(client);
        recordTableView.getItems().add(client);
        outputLabel.setText("Client added successfully.");

    }

    @javafx.fxml.FXML
    public void deleteButtonOnClicked(ActionEvent actionEvent) {
        paralegal_Client selectedClient = recordTableView.getSelectionModel().getSelectedItem();
        if (selectedClient == null) {
            outputLabel.setText("Please select a client to delete.");
            return;
        }

        clientList.remove(selectedClient);
        recordTableView.getItems().remove(selectedClient);
        outputLabel.setText("Client deleted successfully.");

        clientIdTextField.clear();
        nameTextField.clear();
        emailTextField.clear();
        phoneNoTextField.clear();
        caseTextField.clear();
        statusComboBox.setValue(null);
        recordTableView.getSelectionModel().clearSelection();
    }
}
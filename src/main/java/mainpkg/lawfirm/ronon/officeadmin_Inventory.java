package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class officeadmin_Inventory
{
    @javafx.fxml.FXML
    private ComboBox<String> vendorComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_InventoryItem, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_InventoryItem,Integer> quantityCol;
    @javafx.fxml.FXML
    private TableView<officeadmin_InventoryItem> inventoryTableView;
    @javafx.fxml.FXML
    private TextField itemTextField;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_InventoryItem,String> vendorCol;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_InventoryItem,String> itemCol;
    @javafx.fxml.FXML
    private DatePicker dateLocalDatePicker;

    ArrayList<officeadmin_InventoryItem> inventoryItemsList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        itemCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        vendorCol.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        vendorComboBox.getItems().addAll("Vendor 1", "Vendor 2", "Vendor 3");



    }

    @javafx.fxml.FXML
    public void addItemOnClickedButton(ActionEvent actionEvent) {

        if(itemTextField.getText().trim().isEmpty()){
            outputLabel.setText("Please enter an item name.");
            return;
        }
        if(vendorComboBox.getValue() == null) {
            outputLabel.setText("Please select a vendor.");
            return;
        }
        if(quantityTextField.getText().trim().isEmpty()) {
            outputLabel.setText("Please enter a quantity.");
            return;
        }
        if(dateLocalDatePicker.getValue() == null) {
            outputLabel.setText("Please select a date.");
            return;
        }

        String itemName = itemTextField.getText();
        String vendor = vendorComboBox.getValue();
        int quantity = Integer.parseInt(quantityTextField.getText());
        LocalDate date = dateLocalDatePicker.getValue();

        officeadmin_InventoryItem newItem = new officeadmin_InventoryItem(itemName, vendor, quantity, date);
        inventoryItemsList.add(newItem);
        inventoryTableView.getItems().add(newItem);

        outputLabel.setText("Item added successfully!");


        itemTextField.clear();
        vendorComboBox.setValue(null);
        quantityTextField.clear();
        dateLocalDatePicker.setValue(null);
        inventoryTableView.refresh();



    }
}
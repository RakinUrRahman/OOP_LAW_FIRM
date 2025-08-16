package mainpkg.lawfirm.Sojib.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PayFeesController {

    @FXML
    private TableColumn<PayFees, String> amountColumn;

    @FXML
    private TableColumn<PayFees, String> cardNoColumn;

    @FXML
    private TextField cardNumberTextField;

    @FXML
    private TableColumn<PayFees, LocalDate> dateColumn;

    @FXML
    private TableColumn<PayFees, String> methodColumn;

    @FXML
    private ComboBox<String> paymentMethodComboBox;

    @FXML
    private DatePicker paymentDatePicker;
    @FXML
    private TextField enterAmountTextField;

    @FXML
    private TableView<PayFees> tableView;


    @FXML
    public void initialize() {
        loadAllData();
        paymentMethodComboBox.getItems().addAll(
                "Cash",
                "Credit Card",
                "Debit Card",
                "Check",
                "Bank Transfer",
                "Mobile Payment");
        methodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        cardNoColumn.setCellValueFactory(new PropertyValueFactory<>("cardNo"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

    }

    @FXML
    void backToDashboardButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/lawfirmproject/Sojib/Client/dashboardClient.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void makePaymentButton(ActionEvent event) {
        tableView.getItems().clear();
        String cardNumber = cardNumberTextField.getText();
        String paymentMethod = paymentMethodComboBox.getValue();
        int enterAmount = enterAmountTextField.getText().length() ;
        LocalDate paymentDate = paymentDatePicker.getValue();


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("PayFees.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            PayFees y = new PayFees(cardNumber, paymentMethod, enterAmount, paymentDate);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(PayFeesController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PayFeesController.class.getName()).log(Level.SEVERE, null, ex);
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
            PayFees y;
            ois = new ObjectInputStream(new FileInputStream("PayFees.bin"));
            while (true) {
                y = (PayFees) ois.readObject();
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


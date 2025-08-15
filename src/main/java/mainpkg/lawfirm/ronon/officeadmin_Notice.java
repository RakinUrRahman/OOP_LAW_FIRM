package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class officeadmin_Notice
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_NoticeItem,String> messageCol;
    @javafx.fxml.FXML
    private TableColumn<officeadmin_NoticeItem,String> titleCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextArea messageTextArea;
    @javafx.fxml.FXML
    private TableView<officeadmin_NoticeItem> noticeTableView;

    private ArrayList<officeadmin_NoticeItem> noticeList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));

    }

    @javafx.fxml.FXML
    public void postOnClickedButton(ActionEvent actionEvent) {

        String title = titleTextField.getText().trim();
        String message = messageTextArea.getText().trim();

        if (title.isEmpty()) {
            outputLabel.setText("Please enter a title.");
            return;
        }
        if (message.isEmpty()) {
            outputLabel.setText("Please enter a message.");
            return;
        }

        officeadmin_NoticeItem newNotice = new officeadmin_NoticeItem(title, message);
        noticeList.add(newNotice);
        noticeTableView.getItems().add(newNotice);

        outputLabel.setText("Notice posted successfully.");

        titleTextField.clear();
        messageTextArea.clear();
        noticeTableView.refresh();

    }
}
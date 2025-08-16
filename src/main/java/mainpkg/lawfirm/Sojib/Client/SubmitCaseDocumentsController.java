package mainpkg.lawfirm.Sojib.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.text.CollationElementIterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubmitCaseDocumentsController {

    @FXML
    private TableColumn<SubmitCaseDocuments, String> caseTitleColumn;

    @FXML
    private TableColumn<SubmitCaseDocuments, String> descriptionColumn;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableColumn<SubmitCaseDocuments, String> documentTitleColumn;

    @FXML
    private TextField documentTitleTextField;

    @FXML
    private TableColumn<SubmitCaseDocuments, String> nameColumn;

    @FXML
    private ComboBox<String> selectCaseComboBox;

    @FXML
    private TableView<SubmitCaseDocuments> tableView;

    @FXML
    public void initialize() {
        loadAllData();
        boolean addAll = selectCaseComboBox.getItems().addAll("Contract Dispute", "Property Settlement", "Employment Termination");
        caseTitleColumn.setCellValueFactory(new PropertyValueFactory<>("caseTitle"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        documentTitleColumn.setCellValueFactory(new PropertyValueFactory<>("documentTitle"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/lawfirmproject/Sojib/Client/dashboardClient.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void submitButton(ActionEvent event) {
        tableView.getItems().clear();
        String documentTitle = documentTitleTextField.getText();
        String selectCase = selectCaseComboBox.getValue();
        String description = descriptionTextArea.getText();


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("SubmitCaseDocuments.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            SubmitCaseDocuments y = new SubmitCaseDocuments(documentTitle, selectCase, description);
            tableView.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(SubmitCaseDocumentsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SubmitCaseDocumentsController.class.getName()).log(Level.SEVERE, null, ex);
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
            SubmitCaseDocuments y;
            ois = new ObjectInputStream(new FileInputStream("SubmitCaseDocuments.bin"));
            while (true) {
                y = (SubmitCaseDocuments) ois.readObject();
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
    @FXML
    void uploadFileButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Document");

        // Optional: Restrict file types
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        // Show the file chooser dialog
        File selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

        if (selectedFile != null) {
            System.out.println("File selected: " + selectedFile.getAbsolutePath());

            // TODO: Save file path or upload the file to your storage/database
            // Example: store in a variable or display in a label
            CollationElementIterator uploadedFilePathLabel = null;
            uploadedFilePathLabel.setText(selectedFile.getName());
        } else {
            System.out.println("No file selected.");
        }
    }

}



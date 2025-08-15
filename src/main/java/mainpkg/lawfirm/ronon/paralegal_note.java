package mainpkg.lawfirm.ronon;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class paralegal_note
{
    @javafx.fxml.FXML
    private TableColumn<paralegal_CaseNote,String> caseCol;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<paralegal_CaseNote, LocalDate> dateCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<paralegal_CaseNote,String> noteCol;
    @javafx.fxml.FXML
    private TextArea noteTextArea;
    @javafx.fxml.FXML
    private TableView<paralegal_CaseNote> noteTableView;
    @javafx.fxml.FXML
    private ComboBox<String> caseComboBox;

    private ArrayList<paralegal_CaseNote> notelist = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        caseComboBox.getItems().addAll("Case 1", "Case 2", "Case 3");

        caseCol.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));

        noteTableView.getItems().clear();

    }

    @javafx.fxml.FXML
    public void addButtonOnClicked(ActionEvent actionEvent) {
        String caseID = caseComboBox.getValue();
        LocalDate date = dateDatePicker.getValue();
        String note = noteTextArea.getText().trim();

        if (caseID==null|| date==null || note.isEmpty()){
            outputLabel.setText("please fill all fields.");
            return;
        }
        paralegal_CaseNote caseNote = new paralegal_CaseNote(caseID,date, note);
        notelist.add(caseNote);
        noteTableView.getItems().add(caseNote);
        outputLabel.setText("Note Added" );

        caseComboBox.setValue(null);
        dateDatePicker.setValue(null);
        noteTextArea.clear();
    }

    @javafx.fxml.FXML
    public void deleteButtonOnClicked(ActionEvent actionEvent) {
        paralegal_CaseNote selectedNote = noteTableView.getSelectionModel().getSelectedItem();
        if (selectedNote == null){
            outputLabel.setText("please select a note to delete.");
            return;

        }
        notelist.remove(selectedNote);
        noteTableView.getItems().remove(selectedNote);
        outputLabel.setText("Note Deleted" );
    }
}
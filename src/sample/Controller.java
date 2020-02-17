package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    public Label averageLabel;
    @FXML
    public Label lowestLabel;
    @FXML
    public Label highestLabel;
    @FXML
    public TextField userAmountHeadsOrTails;
    @FXML
    public Label invalidInputLabel;
    @FXML
    private TextField userAmount;
    @FXML
    private TextField userWord;
    @FXML
    private ChoiceBox<String> headsOrTailsCB;
    @FXML
    private Label probabilityLabel;
    @FXML
    private TableView<Record> tableData;
    @FXML
    private TableColumn<Record, String> word;
    @FXML
    private TableColumn<Record, String> testNumber;
    @FXML
    private TableColumn<Record, String> attempts;
    @FXML
    private ObservableList<Record> records = FXCollections.observableArrayList();

    /**
     * findAWordGo - Method which is called when a user presses go after entering a needle and a measurement number
     *
     */
    public void findAWordGo() {
        if (!userWord.getText().matches("[\\Wa-z\\W]+")) {
            invalidInputLabel.setText("Invalid Input");
        }
        else {
            invalidInputLabel.setText("");
            NeedleFinder needleFinder = new NeedleFinder(userWord.getText(), "abcdefghijklmnopqrstuvwxyz ");
            needleFinder.needleFinderMeasure(Integer.parseInt(userAmount.getText()));

            records.clear();

            probabilityLabel.setText("1 in "+needleFinder.getProbability());
            highestLabel.setText("Highest: "+needleFinder.getHighest());
            lowestLabel.setText("Lowest: "+needleFinder.getLowest());
            averageLabel.setText("Average: "+needleFinder.getAverage());

            for (Record record : needleFinder.getRecordList()) {
                addToData(record);
            }

            word.setCellValueFactory(new PropertyValueFactory<>("Word"));
            testNumber.setCellValueFactory(new PropertyValueFactory<>("TestNumber"));
            attempts.setCellValueFactory(new PropertyValueFactory<>("Attempts"));
            tableData.setItems(records);
        }

    }

    /**
     * headsOrTailsGo - Method which is called when a user presses go after picking heads or tails and measurement number
     */
    public void headsOrTailsGo() {
        invalidInputLabel.setText("");
        String headsOrTails;
        if (headsOrTailsCB.getSelectionModel().getSelectedItem().equals("Heads")) {
            headsOrTails = "1";
        } else {
            headsOrTails = "2";
        }
        NeedleFinder needleFinder = new NeedleFinder(headsOrTails, "12");
        needleFinder.needleFinderMeasure(Integer.parseInt(userAmountHeadsOrTails.getText()));
        records.clear();
        probabilityLabel.setText("1 in " + needleFinder.getProbability());
        highestLabel.setText("Highest: " + needleFinder.getHighest());
        lowestLabel.setText("Lowest: " + needleFinder.getLowest());
        averageLabel.setText("Average: " + needleFinder.getAverage());
        for (Record record : needleFinder.getRecordList()) {
            addToData(record);
        }
        word.setCellValueFactory(new PropertyValueFactory<>("Word"));
        testNumber.setCellValueFactory(new PropertyValueFactory<>("TestNumber"));
        attempts.setCellValueFactory(new PropertyValueFactory<>("Attempts"));
        tableData.setItems(records);
    }

    /**
     * addToData - Method which is called when a record object must be created and stored in the table
     * @param record record
     */
    public void addToData(Record record) {
        records.add(record);
    }

}

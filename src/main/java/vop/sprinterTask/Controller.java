package vop.sprinterTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class Controller implements Initializable {

    String fileName = "challenge.csv";
    ReadCSV readCSV = new ReadCSV(fileName);

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ToggleGroup radioButtons;

    @FXML
    private RadioButton raceNumber;

    @FXML
    private RadioButton overallPos;

    @FXML
    private RadioButton halfTime;

    @FXML
    private TextArea textField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readCSV.readFile();
        Set<String> countries = readCSV.getMap().keySet();
        comboBox.getItems().addAll(countries);
    }

    @FXML
    void loadData(ActionEvent event) {
        String selectedCountry = comboBox.getSelectionModel().getSelectedItem();

        Set<Sprinter> sprinters = readCSV.getMap().get(selectedCountry);

        TreeSet<Sprinter> sortedSprinters = sortSprinters(sprinters);

        textField.clear();
        textField.setText(getSprinterString(sortedSprinters));
    }

    public TreeSet<Sprinter> sortSprinters(Set<Sprinter> sprinters){
        RadioButton selectedRadioButton = (RadioButton) radioButtons.getSelectedToggle();

        if(selectedRadioButton == raceNumber){
            return new TreeSet<>(sprinters);
        }else if(selectedRadioButton == overallPos){
            TreeSet<Sprinter> sortedSprinters = new TreeSet<Sprinter>(new ComparatorPosition());
            sortedSprinters.addAll(sprinters);
            return sortedSprinters;
        } else if(selectedRadioButton == halfTime){
            TreeSet<Sprinter> sortedSprinters = new TreeSet<Sprinter>(new ComparatorPosition());
            sortedSprinters.addAll(sprinters);
            return sortedSprinters;
        }
        return null;
    }


    private String getSprinterString(Set<Sprinter> sprinters){
        StringBuilder sprinterInformation = new StringBuilder();
        sprinters.forEach(sprinter ->{
            sprinterInformation.append(sprinter.toString()).append("\n");
        });
        return  String.valueOf(sprinterInformation);
    }
}

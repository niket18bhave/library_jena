package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FieldPageController implements Initializable {

    @FXML
    private VBox subfield;

    @FXML
    private ListView<FieldData> subfieldList;

    @FXML
    private VBox superfield;

    @FXML
    private ListView<FieldData> superfieldList;

    ObservableList<FieldData> Qlist = FXCollections.observableArrayList(getData());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subfieldList.setItems(Qlist);
        superfieldList.setItems(Qlist);
    }

    public FieldData getData(){
        return new FieldData("Machine Learning");
    }
}
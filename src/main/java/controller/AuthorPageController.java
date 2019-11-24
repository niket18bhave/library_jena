package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthorPageController implements Initializable {

    @FXML
    private VBox vBox;

    @FXML
    private ListView<Data> listView;

    ObservableList<Data> Qlist = FXCollections.observableArrayList(displayData());

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listView.setItems(Qlist);

    }

    public Data displayData(){

        Data data = new Data("Book", "", "ML", "loc1");

        return data;

    }
}

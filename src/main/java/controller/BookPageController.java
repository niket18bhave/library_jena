package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import model.BookDataModel;
import model.LocationDataModel;
import model.Main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookPageController implements Initializable {


    @FXML
    private ListView<LocationDataModel> listView;

    ObservableList<LocationDataModel> locationData = FXCollections.observableArrayList(displayLocationData());
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listView.setItems(locationData);


    }

    @FXML
    void backAction(ActionEvent event) throws IOException {

        Main.bookStage.close();
        new Main().openSearchWindow();


    }

    public LocationDataModel displayLocationData(){

        LocationDataModel locationData = new LocationDataModel("Aisle 2","4th Floor","ML","Abcde");

        return locationData;

    }
}

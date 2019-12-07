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
import query.FindBooksQuery;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookPageController implements Initializable {


    @FXML
    private ListView<BookDataModel> listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            List<BookDataModel>  Booklist = FindBooksQuery.findBookByTitle(SearchPageController.searchValue);
            listView.getItems().addAll(Booklist.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @FXML
    void backAction(ActionEvent event) throws IOException {

        Main.bookStage.close();
        new Main().openSearchWindow();

    }

}

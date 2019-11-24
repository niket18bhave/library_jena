package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import model.BookDataModel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookPageController implements Initializable {


    @FXML
    private TableView<BookDataModel> tableView;

    ObservableList<BookDataModel> bookData = FXCollections.observableArrayList(displayBookData());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookDataModel bs = new BookDataModel("Book","Author","fjsnf","fdfd");


        tableView.setItems(bookData);


    }

    public BookDataModel displayBookData(){

        BookDataModel bookData = new BookDataModel("Book", "", "ML", "loc1");

        return bookData;

    }
}

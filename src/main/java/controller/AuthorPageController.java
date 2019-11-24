package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import model.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AuthorPageController implements Initializable {

    @FXML
    private VBox vBox;

    @FXML
    private ListView<BookData> listView;

    ObservableList<BookData> bookData = FXCollections.observableArrayList(displayBookData());

    @FXML
    void backAction(ActionEvent event) throws IOException {

        Main.authorStage.close();
        new Main().openSearchWindow();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listView.setItems(bookData);

    }

    public BookData displayBookData(){

        BookData bookData = new BookData("Book", "", "ML", "loc1");

        return bookData;

    }
}

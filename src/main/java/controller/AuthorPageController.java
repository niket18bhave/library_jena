package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import model.BookDataModel;
import model.Main;
import query.FindBooksQuery;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.List;
import java.util.ResourceBundle;

public class AuthorPageController implements Initializable {

    @FXML
    private VBox vBox;

    @FXML
    private ListView<BookDataModel> listView;

    ObservableList<BookDataModel> bookData = FXCollections.observableArrayList(displayBookData());

    @FXML
    void backAction(ActionEvent event) throws IOException {

        Main.authorStage.close();
        new Main().openSearchWindow();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            List<BookDataModel> Booklist =FindBooksQuery.findAllBooks();
            listView.getItems().addAll(Booklist);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public BookDataModel displayBookData(){

        BookDataModel bookData = new BookDataModel("Book", "", "ML", "loc1");


        return bookData;

    }
}

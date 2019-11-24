package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import model.BookDataModel;
import model.FieldDataModel;
import model.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FieldPageController implements Initializable {

    @FXML
    private VBox subField;

    @FXML
    private ListView<FieldDataModel> subFieldListView;

    @FXML
    private VBox superField;

    @FXML
    private ListView<FieldDataModel> superFieldListView;

    @FXML
    private ListView<BookDataModel> bookListView;

    ObservableList<FieldDataModel> fieldData = FXCollections.observableArrayList(displayFieldData());
    ObservableList<BookDataModel> bookData = FXCollections.observableArrayList(displayBookData());


    @FXML
    void backAction(ActionEvent event) throws IOException {

        Main.fieldStage.close();
        new Main().openSearchWindow();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subFieldListView.setItems(fieldData);
        superFieldListView.setItems(fieldData);
        bookListView.setItems(bookData);
    }

    public FieldDataModel displayFieldData(){

        return new FieldDataModel("Machine Learning");
    }

    public BookDataModel displayBookData(){

        BookDataModel bookData = new BookDataModel("Book", "", "ML", "loc1");

        return bookData;

    }


}
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

public class FieldPageController implements Initializable {

    @FXML
    private VBox subField;

    @FXML
    private ListView<FieldData> subFieldListView;

    @FXML
    private VBox superField;

    @FXML
    private ListView<FieldData> superFieldListView;

    @FXML
    private ListView<BookData> bookListView;

    ObservableList<FieldData> fieldData = FXCollections.observableArrayList(displayFieldData());
    ObservableList<BookData> bookData = FXCollections.observableArrayList(displayBookData());


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

    public FieldData displayFieldData(){

        return new FieldData("Machine Learning");
    }

    public BookData displayBookData(){

        BookData bookData = new BookData("Book", "", "ML", "loc1");

        return bookData;

    }


}
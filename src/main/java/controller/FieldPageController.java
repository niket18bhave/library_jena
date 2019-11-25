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
import query.FindBooksQuery;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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



    @FXML
    void backAction(ActionEvent event) throws IOException {

        Main.fieldStage.close();
        new Main().openSearchWindow();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

                subFieldListView.setItems(fieldData);
                superFieldListView.setItems(fieldData);
                List<BookDataModel> Booklist = FindBooksQuery.findBookBySubject(SearchPageController.searchValue);
                bookListView.getItems().addAll(Booklist);
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public FieldDataModel displayFieldData(){

        return new FieldDataModel("Machine Learning");
    }



    }



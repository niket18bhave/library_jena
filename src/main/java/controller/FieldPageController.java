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
import model.Subfield;
import query.FindBooksQuery;
import query.FindSubfieldQuery;

import java.awt.print.Book;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FieldPageController implements Initializable {

    @FXML
    private VBox subField;

    @FXML
    private ListView<String> subFieldListView;

    @FXML
    private VBox superField;

    @FXML
    private ListView<String> superFieldListView;

    @FXML
    private ListView<BookDataModel> bookListView;

    ObservableList<FieldDataModel> fieldData = FXCollections.observableArrayList(displayFieldData());
    ObservableList<FieldDataModel> fieldData2 = FXCollections.observableArrayList(displayFieldData2());


    @FXML
    void backAction(ActionEvent event) throws IOException {

        Main.fieldStage.close();
        new Main().openSearchWindow();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {


                List<BookDataModel> Booklist = FindBooksQuery.findBookBySubject(SearchPageController.searchValue);
                bookListView.getItems().addAll(Booklist);
                List<String> superfielddata = new ArrayList<String>();
                List<String> subfielddata = new ArrayList<String>();
                String field = Booklist.get(0).getField();
                List<Subfield> subfieldList = FindSubfieldQuery.findSubFieldQuery(field);
                for(int i=0;i<Booklist.size();i++) {
                    superfielddata.add(FindBooksQuery.findBookBySubject(SearchPageController.searchValue).get(0).getSuperTopic());
                    break;
                }

                for(Subfield sub : subfieldList) {
                    subfielddata.add(sub.getSubField());
                }

                superFieldListView.getItems().addAll(superfielddata);
                subFieldListView.getItems().addAll(subfielddata);
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public FieldDataModel displayFieldData(){

        return new FieldDataModel("Matrix Semantics");
    }

    public FieldDataModel displayFieldData2(){

        return new FieldDataModel("Propositional Calculus");
    }


    }



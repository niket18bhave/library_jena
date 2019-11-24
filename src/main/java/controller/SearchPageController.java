package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Main;

import java.io.IOException;

public class SearchPageController {

    @FXML
    private ToggleGroup User;

    @FXML
    void searchAction(ActionEvent event) throws IOException {
        RadioButton selectedButton = (RadioButton) User.getSelectedToggle();

        if(selectedButton != null) {
            if(Constants.SEARCH_BY_AUTHOR.equalsIgnoreCase(selectedButton.getText())) {
                System.out.println("Searching for author");
                Main.searchStage.close();
                SearchPageController pageController = new SearchPageController();
                pageController.openAuthorWindow();

            } else if(Constants.SEARCH_BY_FIELD.equalsIgnoreCase(selectedButton.getText())) {
                System.out.println("Searching for field");
                Main.searchStage.close();
                SearchPageController pageController = new SearchPageController();
                pageController.openFieldWindow();
            } else {
                System.out.println("Other User Interfaces are not implemented yet");
            }
        }
    }

    public void openFieldWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FieldPage.fxml"));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        Stage fieldStage = new Stage();
        fieldStage.setScene(scene);
        fieldStage.show();
    }

    public void openAuthorWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("AuthorPage.fxml"));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        Stage authorStage = new Stage();
        authorStage.setScene(scene);
        authorStage.show();
    }
}
package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.xerces.dom.ChildNode;

import java.io.IOException;

public class Main extends Application {
    public static Stage searchStage, authorStage, fieldStage, bookStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.searchStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SearchPage.fxml"));
        root.setId("pane");
        primaryStage.setTitle("Library Management System");
        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().addAll(getClass().getClassLoader().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void openSearchWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("SearchPage.fxml"));
        GridPane pane = loader.load();
        Scene scene = new Scene(pane);
        searchStage = new Stage();
        scene.getStylesheets().addAll(getClass().getClassLoader().getResource("style.css").toExternalForm());
        searchStage.setScene(scene);
        searchStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        initializeStages();
    }

    private static void initializeStages() {
        authorStage = new Stage();
        fieldStage = new Stage();
        bookStage = new Stage();
    }
}

package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Stage searchStage, authorStage, fieldStage, bookStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SearchPage.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, 500, 275));
        openSearchWindow();
    }

    public void openSearchWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("SearchPage.fxml"));
        GridPane pane = loader.load();
        Scene scene = new Scene(pane);
        searchStage = new Stage();
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
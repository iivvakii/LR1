package com.example.lr1fx;

import com.example.lr1fx.file.WorkWithFiles;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WorkWithFiles workWithFiles = new WorkWithFiles();
        workWithFiles.write();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LR1FX.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 700, 450);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws IOException {


        launch();
    }
}
package com.mycompany.aprendizado.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TesteFX extends Application {
    @Override
    public void start(Stage stage) {

        Button btn = new Button("Testando JavaFX");

        VBox layout = new VBox();
        layout.getChildren().add(btn);

        Scene scene = new Scene(layout, 300, 200);

        stage.setTitle("Minha Aplicação");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

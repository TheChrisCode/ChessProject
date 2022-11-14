package com.example.chessproject;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;


public class ChessBoard extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        int a = 0;
        Rectangle [] rectangles = new Rectangle[64];
        for (int i = 0; i < 64; i++) {
            rectangles[i] = new Rectangle(0, 0, 64, 64);
        }

        GridPane gridPane=new GridPane();
        Scene scene = new Scene(gridPane,512,512);
        for (int i = 0; i < 64; i++) {
                gridPane.addRow(a, rectangles[i]);
            if (i != 0 && (i % 8) == 0) {
                a++;
            }
            System.out.println(a);
            System.out.println(i);
        }
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

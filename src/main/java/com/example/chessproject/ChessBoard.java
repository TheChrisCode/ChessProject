package com.example.chessproject;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

import java.util.Arrays;


public class ChessBoard extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        int a = 0;
        int b = 1;
        Image image = new Image("black_pawn.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitHeight(64);
        iv1.setFitWidth(64);
        Rectangle [] rectangles = new Rectangle[64];
        for (int i = 0; i < 64; i++) {
            rectangles[i] = new Rectangle(0, 0, 64, 64);

        }

        System.out.println(Arrays.toString(rectangles));

        GridPane gridPane=new GridPane();
        Scene scene = new Scene(gridPane,512,512);

        for (int i = 0; i < 64; i++) {
            if (i != 0 && (i % 8) == 0) {
                a++;
                if (b == 0) {
                    b = 1;
                } else if (b == 1) {
                    b = 0;
                }
            }
            if((i % 2) != b) {
                rectangles[i].setFill(Color.WHITE);
            }
            System.out.println(i);
            gridPane.addRow(a, rectangles[i]);

            System.out.println(a);
        }


        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

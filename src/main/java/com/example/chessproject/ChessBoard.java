package com.example.chessproject;
import javafx.event.EventHandler;
import javafx.scene.control.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

import java.io.FileInputStream;
import java.nio.file.attribute.GroupPrincipal;
import java.util.Arrays;


public class ChessBoard extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        int a = 0;
        int b = 1;
        StackPane pawn = new StackPane();
        Image image = new Image(new FileInputStream("C:\\Users\\chris\\IdeaProjects\\ChessProject\\src\\main\\resources\\com\\example\\chessproject\\black_pawn.jpg"));

        ImageView iv1 = new ImageView();
        iv1.setFitHeight(64);
        iv1.setFitWidth(64);
        iv1.setPreserveRatio(false);
        iv1.setImage(image);

        Rectangle [] rectangles = new Rectangle[64];
        for (int i = 0; i < 64; i++) {
            rectangles[i] = new Rectangle(0, 0, 64, 64);

        }
        pawn.getChildren().addAll(rectangles[0], iv1);
        System.out.println(Arrays.toString(rectangles));

        GridPane gridPane= new GridPane();
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


        GridPane.setConstraints(pawn, 4, 3);
        gridPane.getChildren().add(pawn);

        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.chessproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import com.example.chessproject.Pawn;

import java.io.FileInputStream;

import static com.example.chessproject.Pawn.*;


public class ChessBoard1 extends Application {
    public static boolean pawnMove = false;
    public static int iVal;
    public static int rowIndex;
    public static int columnIndex;
    public static Rectangle [] rectangles = new Rectangle[64];
    public static StackPane [] blackPawn = new StackPane[8];
    public static ImageView [] blackPawnImageView = new ImageView[8];

    @Override
    public void start(Stage stage) throws Exception {
        int a = 0;
        int b = 1;

        Image blackPawnImage = new Image(new FileInputStream("C:\\Users\\chris\\IdeaProjects\\ChessProject\\src\\main\\resources\\com\\example\\chessproject\\black_pawn.jpg"));
        makeBlackPawns();
        for(int i = 0; i < 8; i++) {
            blackPawnImageView[i].setFitHeight(64);
            blackPawnImageView[i].setFitWidth(64);
            blackPawnImageView[i].setPreserveRatio(false);
            blackPawnImageView[i].setImage(blackPawnImage);
        }




        for (iVal = 0; iVal < 64; iVal++) {
            rectangles[iVal] = new Rectangle(0, 0, 64, 64);

        }
        for(int i = 0; i < 8; i++) {
            blackPawn[i].getChildren().addAll((Node) rectangles[0], (Node) blackPawnImageView[i]);
        }


        GridPane gridPane= new GridPane();
        Scene scene = new Scene(gridPane,512,512);

        for (iVal = 0; iVal < 64; iVal++) {
            if (iVal != 0 && (iVal % 8) == 0) {
                a++;
                if (b == 0) {
                    b = 1;
                } else if (b == 1) {
                    b = 0;
                }
            }
            if((iVal % 2) != b) {
                rectangles[iVal].setFill(Color.WHITE);
            }

            gridPane.addRow(a, rectangles[iVal]);


            rectangles[iVal].setOnMouseClicked(new EventHandler<MouseEvent>() {



                public void handle(MouseEvent mouseEvent) {
                    System.out.println("start mouse event");
                    System.out.println("This triggered");
                    columnIndex = GridPane.getColumnIndex((Node) mouseEvent.getSource());
                    rowIndex = GridPane.getRowIndex((Node) mouseEvent.getSource());
                    if(pawnRules() == true) {
                        for(int i = 0; i < 8; i++) {
                            GridPane.setConstraints(blackPawn[i], columnIndex, rowIndex);
                        }
                        pawnMove = false;
                        pawnMoves++;
                    }
                    System.out.println("end mouse event");
                }
            });


        }




        for(int i = 0; i < 8; i++) {
            GridPane.setConstraints(blackPawn[i], 0+i, 6);
            gridPane.getChildren().add(blackPawn[i]);
            blackPawn[i].addEventFilter(MouseEvent.MOUSE_CLICKED, Pawn.eventHandler1);
        }

        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

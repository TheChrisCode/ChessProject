package com.example.chessproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import com.example.chessproject.ChessBoard1;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Pawn extends ChessBoard1 {

    public static int pawnMoves = 0;
    public static void makeBlackPawns() {
        for(int i = 0; i < 8; i++) {
            blackPawn[i] = new StackPane();
            blackPawnImageView[i] = new ImageView();

        }
    }

    static EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            pawnMove = true;

        }
    };

    public static boolean pawnRules() {
        for(int i = 0; i < 8; i++) {
            if(pawnMoves == 0) {
                if ((GridPane.getRowIndex(blackPawn[i]) - rowIndex) >= 0 && (GridPane.getRowIndex(blackPawn[i]) - rowIndex) <= 2) {
                    if (columnIndex == GridPane.getColumnIndex(blackPawn[i])) {
                        if (pawnMove == true) {

                            return true;
                        }
                        return false;

                    }
                    return false;
                }
                return false;
            } else {
                if ((GridPane.getRowIndex(blackPawn[i]) - rowIndex) >= 0 && (GridPane.getRowIndex(blackPawn[i]) - rowIndex) <= 1) {
                    if (columnIndex == GridPane.getColumnIndex(blackPawn[i])) {
                        if (pawnMove == true) {

                            return true;
                        }
                        return false;

                    }
                    return false;
                }
            }

        }

        return false;
    }

}

package com.example.chessproject;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


public class Pawn extends ChessBoard1 {

    public static int[] pawnMoves= new int[9];
    public static int pawnMovesCounter = 0;
    public static StackPane blackPawnIdentity;
    public static StackPane whitePawnIdentity;
    public static StackPane blackPawnIdentityChange;
    public static StackPane whitePawnIdentityChange;
    public static void makeBlackPawns() {
        for(int i = 0; i < 8; i++) {
            blackPawn[i] = new StackPane();
            blackPawnImageView[i] = new ImageView();
            pawnMoves[i] = 0;

        }
    }
    public static void makeWhitePawns() {
        for(int i = 0; i < 8; i++) {
            whitePawn[i] = new StackPane();
            whitePawnImageView[i] = new ImageView();

        }
    }

    static EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            pawnMove = true;
            blackPawnIdentity = (StackPane) mouseEvent.getSource();
            whitePawnIdentity = (StackPane) mouseEvent.getSource();
            System.out.println("Checkpoint 1");
            if (pawnMovesCounter == 8) {
                pawnMovesCounter = 0;
            }

                if (blackPawnIdentity != blackPawnIdentityChange || pawnMovesCounter == 0) {
                    System.out.println("test");
                    pawnMovesCounter++;

                }
                if (whitePawnIdentity != whitePawnIdentityChange || pawnMovesCounter == 0) {
                    System.out.println("test");
                    pawnMovesCounter++;

                }

            blackPawnIdentityChange = blackPawnIdentity;
            whitePawnIdentityChange = whitePawnIdentity;


            System.out.println(blackPawnIdentity);

        }
    };

    public static boolean pawnRules() {
            if(isBlackTurn == true) {
                if (pawnMoves[pawnMovesCounter] == 0) {
                    if ((GridPane.getRowIndex(blackPawnIdentity) - rowIndex) >= 0 && (GridPane.getRowIndex(blackPawnIdentity) - rowIndex) <= 2) {
                        if (columnIndex == GridPane.getColumnIndex(blackPawnIdentity)) {
                            if (pawnMove == true) {

                                return true;
                            }
                            return false;

                        }
                        return false;
                    }
                    return false;
                } else {
                    if ((GridPane.getRowIndex(blackPawnIdentity) - rowIndex) >= 0 && (GridPane.getRowIndex(blackPawnIdentity) - rowIndex) <= 1) {
                        if (columnIndex == GridPane.getColumnIndex(blackPawnIdentity)) {
                            if (pawnMove == true) {

                                return true;
                            }
                            return false;

                        }
                        return false;
                    }
                }
            } else {
                if (pawnMoves[pawnMovesCounter] == 0) {
                    if ((GridPane.getRowIndex(whitePawnIdentity) - rowIndex) >= 0 && (GridPane.getRowIndex(whitePawnIdentity) - rowIndex) <= 2) {
                        if (columnIndex == GridPane.getColumnIndex(whitePawnIdentity)) {
                            if (pawnMove == true) {

                                return true;
                            }
                            return false;

                        }
                        return false;
                    }
                    return false;
                } else {
                    if ((GridPane.getRowIndex(whitePawnIdentity) - rowIndex) >= 0 && (GridPane.getRowIndex(whitePawnIdentity) - rowIndex) <= 1) {
                        if (columnIndex == GridPane.getColumnIndex(whitePawnIdentity)) {
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

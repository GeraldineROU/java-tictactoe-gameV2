package Game.Tictactoe.Models;

import Game.Tictactoe.Controller.GameController;
import Game.Tictactoe.Views.MenuOut;

public class GameRules {

    public static final int SIZE = 3;

    public GameRules() {

    }



    private boolean isRowCompleted(Cell[][] gameBoard, MenuOut menuOut) {
        for (int row = 0; row < SIZE; row++) {
            if (gameBoard[row][0].isPlayed() && gameBoard[row][0].hasSameState(gameBoard[row][1]) && gameBoard[row][1].hasSameState(gameBoard[row][2])) {
                menuOut.rowCompleted();
                return true;
            }
        }
        return false;
    }

    private boolean isColumnCompleted(Cell[][] gameBoard, MenuOut menuOut) {
        for (int col = 0; col < SIZE; col++) {
            if (gameBoard[0][col].isPlayed() && gameBoard[0][col].hasSameState(gameBoard[1][col]) && gameBoard[1][col].hasSameState(gameBoard[2][col])) {
                menuOut.colCompleted();
                return true;
            }
        }
        return false;
    }

    private boolean isDiag1Completed(Cell[][] gameBoard, MenuOut menuOut) {
        if (gameBoard[0][0].isPlayed() && gameBoard[0][0].hasSameState(gameBoard[1][1]) && gameBoard[1][1].hasSameState(gameBoard[2][2])) {
            menuOut.diagCompleted();
            return true;
        } else {
            return false;
        }
    }

    private boolean isDiag2Completed(Cell[][] gameBoard, MenuOut menuOut) {
        if (gameBoard[2][0].isPlayed() && gameBoard[2][0].hasSameState(gameBoard[1][1]) && gameBoard[1][1].hasSameState(gameBoard[0][2])) {
            menuOut.diagCompleted();
            return true;
        } else {
            return false;
        }
    }

    public boolean isALineCompleted(Cell[][] gameBoard, MenuOut menuOut) {
        return isRowCompleted(gameBoard, menuOut) || isColumnCompleted(gameBoard, menuOut) || isDiag1Completed(gameBoard, menuOut) || isDiag2Completed(gameBoard, menuOut);
    }
}

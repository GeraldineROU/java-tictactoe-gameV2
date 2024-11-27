package Game.Tictactoe;

public class GameRules extends GameMaster {

    public static final int SIZE = 3;


    public int getBoardSize() {
        return SIZE;
    }

    private boolean isRowCompleted() {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][0].isPlayed() && board[row][0].hasSameState(board[row][1]) && board[row][1].hasSameState(board[row][2])) {
                menuOut.rowCompleted();
                return true;
            }
        }
        return false;
    }

    private boolean isColumnCompleted() {
        for (int col = 0; col < SIZE; col++) {
            if (board[0][col].isPlayed() && board[0][col].hasSameState(board[1][col]) && board[1][col].hasSameState(board[2][col])) {
                menuOut.colCompleted();
                return true;
            }
        }
        return false;
    }

    private boolean isDiag1Completed() {
        if (board[0][0].isPlayed() && board[0][0].hasSameState(board[1][1]) && board[1][1].hasSameState(board[2][2])) {
            menuOut.diagCompleted();
            return true;
        } else {
            return false;
        }
    }

    private boolean isDiag2Completed() {
        if (board[2][0].isPlayed() && board[2][0].hasSameState(board[1][1]) && board[1][1].hasSameState(board[0][2])) {
            menuOut.diagCompleted();
            return true;
        } else {
            return false;
        }
    }

    public boolean isALineCompleted() {
        return isRowCompleted() || isColumnCompleted() || isDiag1Completed() || isDiag2Completed();
    }
}

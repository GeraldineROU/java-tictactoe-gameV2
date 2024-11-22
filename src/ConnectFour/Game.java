package ConnectFour;

public class Game {

    private State state;
    private Menu menu;
    private Cell[][] board;
    private Player playerX;
    private Player playerO;
    private int totalOfRows = 6;
    private int totalOfColumns = 7;

    public Game() {
        menu = new Menu();
        playerX = new Player(State.X);
        playerO = new Player(State.O);

    }

    private Cell[][] initializeEmptyBoard() {
        Cell[][] board = new Cell[totalOfRows][totalOfColumns];
        for (int row = 0; row < totalOfRows; row++) {
            for (int col = 0; col < totalOfColumns; col++) {
                board[row][col].setState(State.EMPTY);
            }
        }
        return board;
    }

    private void playOneTurn(Player player, int row, int col) {
        playerGetCell(row, col, player);
        menu.displayGameBoard(board);
    }

    public boolean isInBoardBounds(int row, int col) {
        return row >= 0 && row < totalOfRows || col >= 0 && col < totalOfColumns;
    }

    private void playerGetCell(int row, int col, Player player) {
        State playerState = player.getState();
        board[row][col].setState(playerState);
    }

    private int rowToPlay(int column, Player player) {
        int row = totalOfRows - 1;

        while (row >= 0 && row < totalOfRows && !board[row][column].isEmpty()) {
            row --;
        }

        if (row == -1) {
            menu.displayColumnFull(column);
            int newColumn = menu.getPlayerInteraction().askPlayerColumnNumber();
            rowToPlay(newColumn, player);
        }

        return row;
    }



    public void playGame() {
        Cell[][] board = initializeEmptyBoard();
        startNewGame();
        int turn = 1;
        Player player;
        int col;
        int row;

        while (turn < 10) {
            if (turn % 2 == 0) {
                player = playerO;
                col = menu.getPlayer2Menu().askPlayerColumnNumber();
                row = rowToPlay(col, playerO);
            } else {
                player = playerX;
                col = menu.getPlayer1Menu().askPlayerColumnNumber();
                row = rowToPlay(col, playerX);
            }
            if (isInBoardBounds(row, col)) {
                playOneTurn(player, row, col);
                checkIfIsGameOver(player);
                turn ++;
            }

        }

//            if (isOutOfBoardBounds(row) || isOutOfBoardBounds(col)) {
//                menu.displayWrongInput();
//            } else if (board[row][col].isPlayed()) {
//                menu.displayNotAnEmptyCell();
//            } else {
//                playOneTurn(player, row, col);
////                checkIfIsGameOver(player);
//                turn++;
//            }

    }

    private void startNewGame() {
        menu.welcomeMenu();
        menu.startGame(board);

    }

    private boolean cellsHaveSameState(Cell cell1, Cell cell2) {
        return cell1.getState() == cell2.getState();
    }

    private String checkWhoWins(Player player) {
        String winner;
        winner = null;
        for (int row = 0; row < totalOfRows; row++) {
            for (int col = 0; col < totalOfColumns; col++) {
                if (hasPlayerCompletedAnyLine(row, col)) {
                    winner = player.toString();
                    return winner;
                }
            }
        }
        return winner;
    }

    private boolean hasPlayerCompletedAnyLine(int row, int col) {
        return isCompletingARow(row, col) || isCompletingAColumn(row, col) || isCompletingLeftDiagonal(row, col) || isCompletingRightDiagonal(row, col);
    }

    private boolean isCompletingARow(int row, int col) {
        for (int k = 1; k <= 4; k++) {
            if (cellsHaveSameState(board[row][col], board[row+k][col])) {
                menu.displayRowCompleted();
                return true;
            }
        }
        return false;
    }

    private boolean isCompletingAColumn(int row, int col) {
        for (int k = 1; k <= 4; k++) {
            if (cellsHaveSameState(board[row][col], board[row][col-k])) {
                menu.displayColumnCompleted();
                return true;
            }
        }
        return false;
    }

    private boolean isCompletingRightDiagonal (int row, int col) {
        for (int k = 1; k <= 4; k++) {
            if (cellsHaveSameState(board[row][col], board[row+k][col+k])) {
                menu.displayDiagonalCompleted();
                return true;
            }
        }
        return false;
    }

    private boolean isCompletingLeftDiagonal (int row, int col) {
        for (int k = 1; k <= 4; k++) {
            if (cellsHaveSameState(board[row][col], board[row+k][col-k])) {
                menu.displayDiagonalCompleted();
                return true;
            }
        }
        return false;
    }


    private void checkIfIsGameOver(Player player) {
        String winner = checkWhoWins(player);
        if (winner != null) {
            menu.displayVictory(winner);
            System.exit(0);
        }
    }

    //just to try modify a file....

}

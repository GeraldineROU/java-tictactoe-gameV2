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
        board = new Cell[totalOfRows][totalOfColumns];
    }

    private void initializeEmptyBoard() {
        for (int row = 0; row < totalOfRows; row++) {
            for (int col = 0; col < totalOfColumns; col++) {
                board[row][col] = new Cell();
            }
        }
    }

    private void playOneTurn(Player player, int[] playerMove) {
        int row = playerMove[0];
        int col = playerMove[1];
        playerGetCell(row, col, player);
        menu.displayGameBoard(board);
    }

    public boolean isOutOfBoardBounds(int number) {
        return number < 0 || number >= totalOfRows;
    }

    private void playerGetCell(int row, int col, Player player) {
        State playerState = player.getState();
        board[row][col].setState(playerState);
    }

    public void playGame() {
        initializeEmptyBoard();
        startNewGame();
        int turn = 1;
        Player player;

        while (turn <= totalOfRows * totalOfRows) {
            int[] choice;
            if (turn % 2 == 0) {
                player = playerO;
                choice = menu.getPlayer2Menu().askPlayerRowAndColumnNumber();
            } else {
                player = playerX;
                choice = menu.getPlayer1Menu().askPlayerRowAndColumnNumber();
            }

            int row = choice[0];
            int col = choice[1];

            if (isOutOfBoardBounds(row) || isOutOfBoardBounds(col)) {
                menu.displayWrongInput();
            } else if (board[row][col].isPlayed()) {
                menu.displayNotAnEmptyCell();
            } else {
                playOneTurn(player, choice);
                checkIfIsGameOver(player);
                turn++;
            }
        }
        if (turn > 9) {
            menu.displayNoWinner();
        }
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
        for (int row = 0; row < totalOfRows; row++) {
            if (board[row][0].isPlayed() && cellsHaveSameState(board[row][0], board[row][1]) && cellsHaveSameState(board[row][1], board[row][2])) {
                menu.displayRowCompleted();
                winner = player.toString();
                return winner;
            }
        }
        for (int col = 0; col < totalOfRows; col++) {
            if (board[0][col].isPlayed() && cellsHaveSameState(board[0][col], board[1][col]) && cellsHaveSameState(board[1][col], board[2][col])) {
                menu.displayColumnCompleted();
                winner = player.toString();
                return winner;
            }
        }
        if (board[0][0].isPlayed() && cellsHaveSameState(board[0][0], board[1][1]) && cellsHaveSameState(board[1][1], board[2][2])) {
            menu.displayDiagonalCompleted();
            winner = player.toString();
            return winner;
        }
        if (board[2][0].isPlayed() && cellsHaveSameState(board[2][0], board[1][1]) && cellsHaveSameState(board[1][1], board[0][2])) {
            menu.displayDiagonalCompleted();
            winner = player.toString();
            return winner;
        }
        winner = null;
        return winner;
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

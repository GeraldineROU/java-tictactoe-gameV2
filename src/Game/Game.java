package Game;

public class Game {

    private Menu menu;
    private Cell [][] board;
    private Player playerX;
    private Player playerO;
    private int size = 3;

    public Game() {
        menu = new Menu();
        playerX = new Player(Player.X_MARK);
        playerO = new Player(Player.O_MARK);
        board = new Cell[size][size];
    }

    private void initializeEmptyBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Cell("   ");
            }
        }
    }

    private void playOneTurn(Player player, int[] playerMove) {
        int row = playerMove[0];
        int col = playerMove[1];
        markCell(row, col, player);
        menu.displayGameBoard(board);
    }

    public boolean isInBoardBounds(int position) {
        return position >= 0 && position < size;
    }

    private void markCell(int row, int col, Player player) {
        String playerMark = player.getPlayerMark();
        board[row][col].setRepresentation(playerMark);
    }

    public void playGame() {
        initializeEmptyBoard();
        startNewGame();
        int turn = 1;
        Player player;

        while (turn <= size*size) {
            int[] choice;
            if (turn%2 == 0) {
                player = playerO;
                choice = menu.getPlayer2Menu().askPlayerRowAndColumnNumber();
            } else {
                player = playerX;
                choice = menu.getPlayer1Menu().askPlayerRowAndColumnNumber();
            }

            int row = choice[0];
            int col = choice[1];

            if (!isInBoardBounds(row) || !isInBoardBounds(col)) {
                menu.displayWrongInput();
            } if (!board[row][col].isEmpty()) {
                menu.displayNotAnEmptyCell();
            } else {
                playOneTurn(player, choice);
                checkIfIsGameOver(player);
                turn ++;
            }
        }
        if (turn > 9){
            menu.displayNoWinner();
        }
    }

    private void startNewGame() {
        menu.welcomeMenu();
        menu.startGame(board);

    }

    private String checkWhoWins(Player player) {
        String winner;
        for (int row = 0; row < size; row++) {
            if(!board[row][0].isEmpty() && board[row][0].hasTheSameRepresentation(board[row][1]) && board[row][1].hasTheSameRepresentation(board[row][2])) {
                menu.displayRowCompleted();
                winner = player.getPlayerMark();
                return winner;
            }
        }
        for (int col = 0; col < size; col++) {
            if(!board[0][col].isEmpty() && board[0][col].hasTheSameRepresentation(board[1][col]) && board[1][col].hasTheSameRepresentation(board[2][col])) {
                menu.displayColumnCompleted();
                winner = player.getPlayerMark();
                return winner;
            }
        }
        if(!board[0][0].isEmpty() && board[0][0].hasTheSameRepresentation(board[1][1]) && board[1][1].hasTheSameRepresentation(board[2][2])) {
            menu.displayDiagonalCompleted();
            winner = player.getPlayerMark();
            return winner;
        }
        if (!board[2][0].isEmpty() && board[2][0].hasTheSameRepresentation(board[1][1]) && board[1][1].hasTheSameRepresentation(board[0][2])) {
            menu.displayDiagonalCompleted();
            winner = player.getPlayerMark();
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

}

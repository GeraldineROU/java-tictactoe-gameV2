package Game.Tictactoe;

public class GameMaster {

    private GameRules gameRules;
    private GameFlow gameFlow;
    private MenuOut menuOut;
    private Cell[][] board;
    private Player playerX;
    private Player playerO;
    private Board boardGame;

    public GameMaster() {
        gameRules = new GameRules();
        gameFlow = new GameFlow();
        menuOut = new MenuOut();
        playerX = new Player(State.X);
        playerO = new Player(State.O);
        board = new Cell[gameRules.getBoardSize()][gameRules.getBoardSize()];
        board = boardGame.initBoard();
    }



    private void checkIfIsGameOver(Player player) {
        String winner = gameFlow.checksWhoWins(player);
        if (winner != null) {
            menuOut.victory(player);
            System.exit(0);
        }
    }

    public void startGame() {

    }



//    public void playGame() {
//        initializeEmptyBoard();
//        startNewGame();
//        int turn = 1;
//        Player player;
//
//        while (turn <= size * size) {
//            int[] choice;
//            if (turn % 2 == 0) {
//                player = playerO;
//                choice = menu.getPlayer2Menu().askPlayerRowAndColumnNumber();
//            } else {
//                player = playerX;
//                choice = menu.getPlayer1Menu().askPlayerRowAndColumnNumber();
//            }
//
//            int row = choice[0];
//            int col = choice[1];
//
//            if (isOutOfBoardBounds(row) || isOutOfBoardBounds(col)) {
//                menu.displayWrongInput();
//            } else if (board[row][col].isPlayed()) {
//                menu.displayNotAnEmptyCell();
//            } else {
//                playOneTurn(player, choice);
//                checkIfIsGameOver(player);
//                turn++;
//            }
//        }
//        if (turn > 9) {
//            menu.displayNoWinner();
//        }
//    }
//
//    private void startNewGame() {
//        menu.welcomeMenu();
//        menu.startGame(board);
//
//    }

//    private boolean cellsHaveSameState(Cell cell1, Cell cell2) {
//        return cell1.getState() == cell2.getState();
//    }
//
//    private String checkWhoWins(Player player) {
//        String winner;
//        for (int row = 0; row < size; row++) {
//            if (board[row][0].isPlayed() && cellsHaveSameState(board[row][0], board[row][1]) && cellsHaveSameState(board[row][1], board[row][2])) {
//                menu.displayRowCompleted();
//                winner = player.toString();
//                return winner;
//            }
//        }
//        for (int col = 0; col < size; col++) {
//            if (board[0][col].isPlayed() && cellsHaveSameState(board[0][col], board[1][col]) && cellsHaveSameState(board[1][col], board[2][col])) {
//                menu.displayColumnCompleted();
//                winner = player.toString();
//                return winner;
//            }
//        }
//        if (board[0][0].isPlayed() && cellsHaveSameState(board[0][0], board[1][1]) && cellsHaveSameState(board[1][1], board[2][2])) {
//            menu.displayDiagonalCompleted();
//            winner = player.toString();
//            return winner;
//        }
//        if (board[2][0].isPlayed() && cellsHaveSameState(board[2][0], board[1][1]) && cellsHaveSameState(board[1][1], board[0][2])) {
//            menu.displayDiagonalCompleted();
//            winner = player.toString();
//            return winner;
//        }
//        winner = null;
//        return winner;
//    }




}

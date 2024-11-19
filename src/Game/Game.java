package Game;

public class Game {
    private Menu menu;
    private Cell [][] board;
    private Player player;
    private int size = 3;
    private int turn;

    public Game() {
        menu = new Menu();
        player = new Player();
        board = new Cell[size][size];
        initializeEmptyBoard();
        turn = 1;
    }

    private void initializeEmptyBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Cell("   ");
            }
        }
    }

    private void playOneTurn(Cell[][] board) {
        menu.displayNewTurnBeginning(turn);
        int[] playerMove = menu.askPlayerRowAndColumnNumber();
        int row = playerMove[0];
        int col = playerMove[1];
        markCell(row, col);
        menu.displayGameBoard(board);
    }

    private void markCell(int row, int col) {
        String playerMark = player.getCrossMark();
        board[row][col].setContent(playerMark);
    }

    public void playGame() {
        //gère le déroulement de l'ensemble du jeu
        startNewGame();
        playOneTurn(board);
    }

    private void startNewGame() {
        //affiche start menu
        menu.startMenu();
        //récupère choix du joueur
        menu.startGame(board);

    }



}

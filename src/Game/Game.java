package Game;

public class Game {
    private Menu menu;
    private Cell [][] board;
    private Player player;
    private int size = 3;
    private int turn = 1;

    public Game() {
        menu = new Menu();
        player = new Player();
        board = new Cell[size][size];
        initializeEmptyBoard();
    }

    private void initializeEmptyBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Cell("   ");
            }
        }
    }

    public void playGame() {
        //gère le déroulement de l'ensemble du jeu
        startNewGame();
    }

    private void startNewGame() {
        //affiche start menu
        menu.startMenu();
        //récupère choix du joueur
        menu.startGame(board);

    }



}

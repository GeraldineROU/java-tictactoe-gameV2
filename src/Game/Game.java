package Game;

public class Game {

    private Menu menu;
    private Cell [][] board;
    private Player playerX;
    private Player playerO;
    private int size = 3;
    private int turn;

    public Game() {
        menu = new Menu();
        playerX = new Player(Player.X_MARK);
        playerO = new Player(Player.O_MARK);
        board = new Cell[size][size];
        turn = 1;
    }

    private void initializeEmptyBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Cell("   ");
            }
        }
    }

    private void playOneTurn(Player player) {
//        menu.displayNewTurnBeginning(turn);
        int[] playerMove = menu.askPlayerRowAndColumnNumber();
        int row = playerMove[0];
        int col = playerMove[1];
        if (!isInBoardBounds(row) || !isInBoardBounds(col)) {
            menu.displayWrongInput();
            playOneTurn(player);
        } else {
            if(board[row][col].isEmpty()) {
                markCell(row, col, player);
                menu.displayGameBoard(board);
            } else {
                menu.displayNotAnEmptyCell();
                playOneTurn(player);
            }
        }
    }

    public boolean isInBoardBounds(int position) {
        return position >= 0 && position < size;
    }

    private void markCell(int row, int col, Player player) {
        String playerMark = player.getPlayerMark();
        board[row][col].setRepresentation(playerMark);
    }

    public void playSoloGame() {
        initializeEmptyBoard();
        //gère le déroulement de l'ensemble du jeu
        startNewGame();
        while (!isGameOver()) {
            playOneTurn(playerX);
        }
    }

    public void play2PlayersGame() {
        initializeEmptyBoard();
        startNewGame();
        int turn = 1;
        Player player;
        while (!isGameOver()) {
            if (turn%2 == 0) {
                player = playerO;
            } else {
                player = playerX;
            }
            playOneTurn(player);
            turn ++;
        }
    }

    private void startNewGame() {
        //affiche start menu
        menu.startMenu();
        //récupère choix du joueur
        menu.startGame(board);

    }

    private boolean checkWin() {
        boolean isVictory = false;

        for (int row = 0; row < size; row++) {
            if(!board[row][0].isEmpty() && board[row][0].hasTheSameRepresentation(board[row][1]) && board[row][1].hasTheSameRepresentation(board[row][2])) {
                System.out.println("You've completed a row !!!");
                isVictory = true;
            }
        }
        for (int col = 0; col < size; col++) {
            if(!board[0][col].isEmpty() && board[0][col].hasTheSameRepresentation(board[1][col]) && board[1][col].hasTheSameRepresentation(board[2][col])) {
                System.out.println("You've completed a column !!!");
                isVictory = true;
            }
        }
        if(!board[0][0].isEmpty() && board[0][0].hasTheSameRepresentation(board[1][1]) && board[1][1].hasTheSameRepresentation(board[2][2])) {
            System.out.println("You've completed a diagonal !!!");
            isVictory = true;
        }
        if (!board[2][0].isEmpty() && board[2][0].hasTheSameRepresentation(board[1][1]) && board[1][1].hasTheSameRepresentation(board[0][2])) {
            System.out.println("You've completed a diagonal !!!");
            isVictory = true;
        }
        return isVictory;
    }


    private boolean isGameOver() {
        if (checkWin()) {
            menu.displayVictory();
            return true;
        }else {
            return false;
        }
    }

}

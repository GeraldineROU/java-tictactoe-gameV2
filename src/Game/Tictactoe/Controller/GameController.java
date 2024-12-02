package Game.Tictactoe.Controller;

import Game.Tictactoe.*;
import Game.Tictactoe.Models.Cell;
import Game.Tictactoe.Models.GameRules;
import Game.Tictactoe.Models.Player;
import Game.Tictactoe.Views.MenuIn;
import Game.Tictactoe.Views.MenuOut;

import java.util.Scanner;

public class GameController {

    private GameRules gameRules;
    private MenuOut menuOut;
    private Cell[][] boardGame;
    public Player playerX;
    public Player playerO;

    public GameController() {
        gameRules = new GameRules();
        menuOut = new MenuOut();
        boardGame = new Cell[3][3];
        boardGame = initBoard(3);
        playerX = new Player(State.X);
        playerO = new Player(State.O);
    }

    public Cell[][] initBoard(int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                boardGame[row][col] = new Cell();
            }
        }
        return boardGame;
    }

   public int [] getArtificialPlayerMove () {
       int row = (int)(Math.random()*3);
        menuOut.cpuRow(row);

       int column = (int)(Math.random()*3);
        menuOut.cpuCol(column);


       System.out.println("row: " + row + ", column: " + column);

       return new int[]{row, column};
   }

   public int getPlayerInt(Scanner scanner) {
       int number = -1;
       while (true) {
           if (scanner.hasNextInt()) {
               number = scanner.nextInt();
               break;
           } else {
               menuOut.wrongInput();
               menuOut.askInt();
               scanner.next();
           }
       }
       return number;
   }

   public int [] getHumanPlayerMove () {
       Scanner scanner = new Scanner(System.in);

       menuOut.askRow();
       int row = getPlayerInt(scanner);

       menuOut.askColumn();
       int column = getPlayerInt(scanner);

       System.out.println("row: " + row + ", column: " + column);

       int[] playerMove = {row, column};

       if(!canPlayThisCell(playerMove)) {
           menuOut.wrongInput();
           getHumanPlayerMove();
       }
       return playerMove;
   }

    public void playerMoveUpdatesBoard(Player player, int[] playerMove) {
        int row = playerMove[0];
        int col = playerMove[1];
        playerGetsCell(row, col, player);
        boardRepresentation();
    }

    private void playerGetsCell(int row, int col, Player player) {
        State playerState = player.getState();
        boardGame[row][col].setState(playerState);
    }

    public void boardRepresentation() {
        int totalOfRows = boardGame.length;
        int totalOfCols = boardGame[0].length;


        for (int row = 0; row < totalOfRows; row++) {
            displayHorizontalSeparationForBoard(totalOfCols);
            for (int col = 0; col < totalOfCols; col++) {
                displayCellRepresentation(boardGame[row][col]);
            }
            menuOut.endOfOneRow();
        }
        displayHorizontalSeparationForBoard(totalOfCols);
    }

    private void displayCellRepresentation(Cell cell) {
        String cellContent = cell.getRepresentation();
        menuOut.oneCell(cellContent);
    }

    private void displayHorizontalSeparationForBoard(int totalOfColumns) {

        for (int i = 0; i < totalOfColumns; i++) {
            menuOut.horizontalUpperLineOfOneCell();
        }
        menuOut.endOfLine();
    }


//
//    protected String checksWhoWins(Player player) {
//        String winner = null;
//        return winner;
//    }

//    private void checkIfIsGameOver(Player player) {
//        String winner = gameFlow.checksWhoWins(player);
//        if (winner != null) {
//            menuOut.victory(player);
//            System.exit(0);
//        }
//    }
//
//    public void startGame() {
//
//    }

    private boolean canPlayThisCell(int[] playerMove) {
        int row = playerMove[0];
        int col = playerMove[1];
        if(boardGame[row][col].isPlayed()) {
            menuOut.wrongInput();
            return false;
        } else if( row < 0 || col < 0 || row >= gameRules.SIZE || col >= gameRules.SIZE) {
            menuOut.wrongInput();
            return false;
        } else {
            return true;
        }
    }


    public void playGame() {
//        initializeEmptyBoard();
//        startNewGame();
        boardRepresentation();

        int turn = 1;
        int size = gameRules.SIZE;
        Player currentPlayer;

        while (turn < size * size || gameRules.isALineCompleted(boardGame, menuOut)) {
            int[] currentPlayerMove;
            if (turn % 2 == 0) {
                currentPlayerMove = getArtificialPlayerMove();
                playerMoveUpdatesBoard(playerO, currentPlayerMove);

            } else {
                currentPlayerMove = getHumanPlayerMove();
                playerMoveUpdatesBoard(playerX, currentPlayerMove);
            }
            turn ++;


//            int row = currentPlayerMove[0];
//            int col = currentPlayerMove[1];



//            if (isOutOfBoardBounds(row) || isOutOfBoardBounds(col)) {
//                menu.displayWrongInput();
//            } else if (board[row][col].isPlayed()) {
//                menu.displayNotAnEmptyCell();
//            } else {
//                playOneTurn(player, currentPlayerMove);
//                checkIfIsGameOver(player);
//                turn++;
//            }
        }
        System.out.println("Game over");
    }
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

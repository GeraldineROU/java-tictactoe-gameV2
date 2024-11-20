package Game;

import java.util.Scanner;

public class Menu {

    private PlayerInteraction player1Interaction;
    private PlayerInteraction player2Interaction;
    private MenuIn menuIn;
    private MenuOut menuOut;

    public Menu() {
        menuIn = new MenuIn();
        menuOut = new MenuOut();
    }

    public void welcomeMenu() {
        menuOut.writeLine("Welcome to TIC TAC TOE !");
    }

    private int askPlayerToStartGame() {
        menuOut.writeLine("Please choose a game mode :");
        menuOut.writeLine("-----> type 1 to start a new game against a human player");
        menuOut.writeLine("-----> type 2 to start a new game against an artificial player");
        menuOut.writeLine("-----> type 3 to start a new game played by 2 artificial players");
        int playerChoice = menuIn.getUserInt();
        return playerChoice;
    }

    public void displayWrongInput() {
        menuOut.writeLine("Invalid input, please try again");
    }

    public void displayNotAnEmptyCell() {
        menuOut.writeLine("This cell has already been played, please choose another one.");
    }

    public void startGame(Cell[][] board) {
        int playerInput = askPlayerToStartGame();
        switch (playerInput) {
            case 1:
                menuOut.writeLine("New Board created !");
                player1Interaction = new HumanPlayerInteraction();
                player2Interaction = new HumanPlayerInteraction();
                displayGameBoard(board);
                menuOut.writeLine("What is your first move?");
                break;
            case 2:
                menuOut.writeLine("New Board created !");
                player1Interaction = new HumanPlayerInteraction();
                player2Interaction = new ArtificialPlayerInteraction();
                displayGameBoard(board);
                break;
            case 3 :
                menuOut.writeLine("New Board created !");
                player1Interaction = new ArtificialPlayerInteraction();
                player2Interaction = new ArtificialPlayerInteraction();
                displayGameBoard(board);
                break;
            default:
                displayWrongInput();
                startGame(board);
        }
    }

    public void displaySeparationLine() {
        menuOut.writeLine("-------------");
    }

    private void displayOneCell(Cell cell) {
        String cellContent = cell.getRepresentation();
        menuOut.write("|");
        menuOut.write(cellContent);
    }

    public void displayGameBoard( Cell[][] board ) {
        for (int i = 0; i < board[0].length; i++) {
            displaySeparationLine();
            for (int j = 0; j < board[1].length; j++) {
                displayOneCell(board[i][j]);
            }
            menuOut.writeLine("|");
        }
        displaySeparationLine();
    }

    public void displayRowCompleted() {
        menuOut.writeLine("Row completed !");
    }

    public void displayColumnCompleted() {
        menuOut.writeLine("Column completed !");
    }

    public void displayDiagonalCompleted() {
        menuOut.writeLine("Diagonal completed !");
    }

    public void displayVictory(String winner) {
        menuOut.writeLine("Congrats player " + winner + ", you win!!! Yayyy !!");
    }

    public void displayNoWinner() {
        menuOut.writeLine("Board full, no winner.");
    }

    public PlayerInteraction getPlayer1Menu() {
        return player1Interaction;
    }

    public PlayerInteraction getPlayer2Menu() {
        return player2Interaction;
    }
}

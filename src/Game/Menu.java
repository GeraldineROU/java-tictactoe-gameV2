package Game;

import java.util.Scanner;

public class Menu {

    private PlayerInteraction player1Interaction;
    private PlayerInteraction player2Interaction;

    public void welcomeMenu() {

        System.out.println("Welcome to TIC TAC TOE !");
    }

    private int askPlayerToStartGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a game mode :");
        System.out.println("-----> type 1 to start a new game against a human player");
        System.out.println("-----> type 2 to start a new game against an artificial player");
        return scanner.nextInt();
    }

    public void displayNewTurnBeginning(int turnNumber) {
        System.out.println("Turn number: " + turnNumber);
    }

    public void displayWrongInput() {
        System.out.println("Invalid input, please try again");
    }

    public void displayNotAnEmptyCell() {
        System.out.println("This cell has already been played, please choose another one.");
    }

    public void startGame(Cell[][] board) {
        int playerInput = askPlayerToStartGame();
        //affiche tableau vide
        if (playerInput == 1) {
            //fction affichage
            System.out.println("New Board created !");
            player1Interaction = new HumanPlayerInteraction();
            player2Interaction = new HumanPlayerInteraction();
            displayGameBoard(board);
            System.out.println("What is your first move?");
        } else if (playerInput == 2) {
            player1Interaction = new HumanPlayerInteraction();
            player2Interaction = new ArtificialPlayerInteraction();
            displayGameBoard(board);
        } else {
            displayWrongInput();
            startGame(board);
        }
    }

    public void displaySeparationLine() {
        System.out.println("-------------");
    }

    private void displayOneCell(Cell cell) {
        String cellContent = cell.getRepresentation();
        System.out.print("|");
        System.out.print(cellContent);
    }

    public void displayGameBoard( Cell[][] board ) {
        for (int i = 0; i < board[0].length; i++) {
            displaySeparationLine();
            for (int j = 0; j < board[1].length; j++) {
                displayOneCell(board[i][j]);
            }
            System.out.println("|");
        }
        displaySeparationLine();
    }

    public void displayVictory() {
        System.out.println("You win!!! Yayyy !!");
    }

    public PlayerInteraction getPlayer1Menu() {
        return player1Interaction;
    }

    public PlayerInteraction getPlayer2Menu() {
        return player2Interaction;
    }
}

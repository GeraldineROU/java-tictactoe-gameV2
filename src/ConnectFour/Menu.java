package ConnectFour;

public class Menu {

    private PlayerInteraction player1Interaction;
    private PlayerInteraction player2Interaction;
    private PlayerInteraction playerInteraction;
    private MenuIn menuIn;
    private MenuOut menuOut;

    public Menu() {
        menuIn = new MenuIn();
        menuOut = new MenuOut();
    }

    public void welcomeMenu() {
        menuOut.writeLine("Welcome to Connect 4 Game !");
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

    public void displaySeparationLine(int totalOfColumns) {
        menuOut.write("--------");
        for (int i = 0; i < totalOfColumns; i++) {
            menuOut.write("+---");
        }
        menuOut.write("+\n");
    }

    private void displayOneCell(Cell cell) {
        String cellContent = cell.getRepresentation();
        menuOut.write("|");
        menuOut.write(cellContent);
    }

    public void displayGameBoard( Cell[][] board ) {
        int totalOfRows = board.length;
        int totalOfColumns = board[0].length;

        menuOut.write("column #|");
        for (int col = 0; col < totalOfColumns; col++) {
            menuOut.write(" " + (col + 1) + " |");
        }
        menuOut.write("\n");

        for (int i = 0; i < totalOfRows; i++) {
            displaySeparationLine(totalOfColumns);
            int rowNumber = i + 1;
            menuOut.write("row n°" + rowNumber + " ");
            for (int j = 0; j < totalOfColumns; j++) {
                displayOneCell(board[i][j]);
            }
            menuOut.writeLine("|");
        }
        displaySeparationLine(totalOfColumns);
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

    public void displayColumnFull(int column) {
        menuOut.writeLine("Column " + column + " full. Please choose another one :");
    }

    public PlayerInteraction getPlayerInteraction() {
        return playerInteraction;
    }

    public PlayerInteraction getPlayer1Menu() {
        return player1Interaction;
    }

    public PlayerInteraction getPlayer2Menu() {
        return player2Interaction;
    }
}

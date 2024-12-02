package Game.Tictactoe.Views;

import Game.Tictactoe.Models.Player;

public class MenuOut {

    private Messages message;
    private String text;

    public MenuOut() {
        message = new Messages();

    }



    public void displayGameBoard() {
        System.out.println("gameboard");
    }

    private void displayMessage (String message) {
        System.out.println(message);
    }

    private void displayMessageFollowedBy (String message) {
        System.out.print(message);
    }

    private void displayInt(int number) {
        System.out.println(number);
    }

    public void horizontalUpperLineBeforeColumns() {
        System.out.print("--------");
    }

    public void horizontalUpperLineOfOneCell() {
        System.out.print("+---");
    }

    public void endOfLine() {
        System.out.println("+");
    }

    public void oneCell(String cellContent) {
        System.out.print("|" + cellContent);
    }

    public void endOfOneRow() {
        System.out.println("|");
    }


    public void rowCompleted() {
        displayMessage(Messages.ROW);
    }

    public void colCompleted() {
        displayMessage(Messages.COL);
    }

    public void diagCompleted() {
        displayMessage(Messages.DIAG);
    }

    public void askRow() {
        displayMessage(Messages.ASK_ROW);
    }

    public void askColumn() {
        displayMessage(Messages.ASK_COL);
    }

    public void cpuRow(int row) {
        displayMessageFollowedBy(Messages.CPU_ROW);
        displayInt(row);
    }

    public void cpuCol(int col) {
        displayMessageFollowedBy(Messages.CPU_COL);
        displayInt(col);
    }

    public void victory(Player player) {
        displayMessage(Messages.VICTORY);
        displayMessageFollowedBy(player.toString());
        displayMessage(Messages.YOU_WIN);
    }

    public void wrongInput() {
        displayMessage(Messages.ERR);
    }

    public void askInt() {
        displayMessage(Messages.INT);
    }



}

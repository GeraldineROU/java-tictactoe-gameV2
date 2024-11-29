package Game.Tictactoe;

public class MenuOut {

    private Messages message;
    private String text;

    public MenuOut() {
        message = new Messages();

    }



    public void displayGameBoard(Board board) {
        System.out.println("gameboard");
    }

    private void displayMessage (String message) {
        System.out.println(message);
    }

    private void displayIntOnSameLine (int number) {
        System.out.print(number);
    }

    private void displayStringOnSameLine (String text) {
        System.out.print(text);
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
        displayMessage(Messages.CPU_ROW);
        displayIntOnSameLine(row);
    }

    public void cpuCol(int col) {
        displayMessage(Messages.CPU_COL);
        displayIntOnSameLine(col);
    }

    public void victory(Player player) {
        displayMessage(Messages.VICTORY);
        displayStringOnSameLine(player.toString());
        displayStringOnSameLine(Messages.YOU_WIN);
    }

    public void wrongInput() {
        displayMessage(Messages.ERR);
    }



}

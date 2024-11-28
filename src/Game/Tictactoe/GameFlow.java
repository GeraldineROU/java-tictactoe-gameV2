package Game.Tictactoe;

public class GameFlow {

    public void playsOneTurn(Player player, int[] playerMove) {
        int row = playerMove[0];
        int col = playerMove[1];
        playerGetsCell(row, col, player);
        menuOut.displayGameBoard(boardGame);
    }

    private void playerGetsCell(int row, int col, Player player) {
        State playerState = player.getState();
        board[row][col].setState(playerState);
    }

    protected String checksWhoWins(Player player) {
        String winner = null;
        return winner;
    }


}

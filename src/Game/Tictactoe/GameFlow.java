package Game.Tictactoe;

public class GameFlow extends GameMaster{

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

    private String checksWhoWins(Player player) {
        String winner = null;
        return winner;
    }
}

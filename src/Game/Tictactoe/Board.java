package Game.Tictactoe;

public class BoardGame {


    private GameRules gameRules;
    private int size;

    public BoardGame() {
        this.gameRules = new GameRules();
        this.size = GameRules.SIZE;
        boardGame = initBoard();
    }


    public Cell[][] initBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                boardGame[row][col] = new Cell();
            }
        }
        return boardGame;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isOutOfBoardBounds(int number) {
        return number < 0 || number >= size;
    }

}

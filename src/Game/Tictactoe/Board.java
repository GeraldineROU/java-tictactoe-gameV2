package Game.Tictactoe;

public class Board {

    private Cell[][] boardGame;
    private GameRules gameRules;
    private int size;

//    public Board() {
//        this.gameRules = new GameRules();
//        this.size = GameRules.SIZE;
//        this.board = new Cell[size][size];
//        board = initBoard();
//    }

    public Board() {
        this.gameRules = new GameRules();
        this.size = gameRules.getBoardSize();
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

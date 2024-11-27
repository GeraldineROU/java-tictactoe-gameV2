package Game.Tictactoe;

public class HumanPlayerInteraction implements PlayerInteraction{

    private MenuIn menuIn;
    private MenuOut menuOut;

    public HumanPlayerInteraction() {
        menuIn = new MenuIn();
        menuOut = new MenuOut();
    }

    @Override
    public int[] chosesNextMove() {
        menuOut.askRow();
        int row = menuIn.getUserInt();
        menuOut.askColumn();
        int column = menuIn.getUserInt();
        int[] playerMove = {row, column};
        return playerMove;
    }
}

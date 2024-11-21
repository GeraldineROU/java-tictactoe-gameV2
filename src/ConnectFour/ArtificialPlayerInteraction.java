package ConnectFour;

public class ArtificialPlayerInteraction implements PlayerInteraction {

    private MenuOut menuOut;

    public ArtificialPlayerInteraction() {
        menuOut = new MenuOut();
    }

    @Override
    public int[] askPlayerRowAndColumnNumber() {
        int row = (int)(Math.random()*3);
        menuOut.writeLine("Artificial player chose to play row number " + row + " !");
        int column = (int)(Math.random()*3);
        menuOut.writeLine("Artificial player chose to play column number " + column + " !");
        int[] playerMove = {row, column};
        return playerMove;
    }
}

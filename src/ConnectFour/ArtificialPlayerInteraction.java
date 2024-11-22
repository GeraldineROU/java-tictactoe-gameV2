package ConnectFour;

public class ArtificialPlayerInteraction implements PlayerInteraction {

    private MenuOut menuOut;

    public ArtificialPlayerInteraction() {
        menuOut = new MenuOut();
    }

    @Override
    public int askPlayerColumnNumber() {

        int column = (int)(Math.random()*3);
        menuOut.writeLine("Artificial player chose to play column number " + column + " !");
        return column;
    }
}

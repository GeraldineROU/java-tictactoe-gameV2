package ConnectFour;

public class HumanPlayerInteraction implements PlayerInteraction {

    private MenuIn menuIn;
    private MenuOut menuOut;

    public HumanPlayerInteraction() {
        menuIn = new MenuIn();
        menuOut = new MenuOut();
    }

    @Override
    public int askPlayerColumnNumber() {
//        menuOut.writeLine("Please choose a row to play (number between 0 and 2)");
//        int row = menuIn.getUserInt();
        menuOut.writeLine("Please choose a column to play (number between 0 and 2)");
        int column = menuIn.getUserInt();
        return column;
    }
}

package Game.Tictactoe;

public class ArtificialPlayerInteraction implements PlayerInteraction {



    @Override
    public int[] chosesNextMove() {

        int row = (int)(Math.random()*3);
//        menuOut.cpuRow(row);

        int column = (int)(Math.random()*3);
//        menuOut.cpuCol(column);

        int[] playerMove = {row, column};
        return playerMove;
    }
}

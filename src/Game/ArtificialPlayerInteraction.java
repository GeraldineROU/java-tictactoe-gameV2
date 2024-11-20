package Game;

import java.util.Scanner;

public class ArtificialPlayerInteraction implements PlayerInteraction{
    @Override
    public int[] askPlayerRowAndColumnNumber() {
        System.out.println("Artificial player is choosing which row to play...");
        int row = (int)(Math.random()*3);
        System.out.println("Row number " + row);
        System.out.println("Artificial player is choosing which column to play...");
        int column = (int)(Math.random()*3);
        System.out.println("Column number " + column);
        int[] playerMove = {row, column};
        return playerMove;

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please choose which row to play (number between 0 and 2)");
//        int row = scanner.nextInt();
//        System.out.println("Please choose which column to play (number between 0 and 2)");
//        int column = scanner.nextInt();
//        int[] playerMove = {row, column};
//        return playerMove;
    }
}

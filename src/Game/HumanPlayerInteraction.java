package Game;

import java.util.Scanner;

public class HumanPlayerInteraction implements PlayerInteraction{

    @Override
    public int[] askPlayerRowAndColumnNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a row to play (number between 0 and 2)");
        int row = scanner.nextInt();
        System.out.println("Please choose a column to play (number between 0 and 2)");
        int column = scanner.nextInt();
        int[] playerMove = {row, column};
        return playerMove;
    }
}

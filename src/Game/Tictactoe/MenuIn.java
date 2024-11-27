package Game.Tictactoe;

import java.util.Scanner;

public class MenuIn {

    private PlayerInteraction player1Interaction;
    private PlayerInteraction player2Interaction;

    public int getUserInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public PlayerInteraction getPlayer1Interaction() {
        return player1Interaction;
    }

    public PlayerInteraction getPlayer2Interaction() {
        return player2Interaction;
    }
}

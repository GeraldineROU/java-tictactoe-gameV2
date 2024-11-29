package Game.Tictactoe;

public class Main {
    public static void main(String[] args) {
        GameController game = new GameController();

        System.out.println("test choix joueur humain");

        game.getHumanPlayerMove();

        System.out.println("test choix joueur machine");

        game.getArtificialPlayerMove();
//
//        game.playGame();
    }
}

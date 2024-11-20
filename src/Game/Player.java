package Game;

public class Player {
    public static final String X_MARK = " X ";
    public static final String O_MARK = " O ";

    private String playerMark;

    public Player(String playerMark) {
        this.playerMark = playerMark;
    }

    public String getPlayerMark() {
        return playerMark;
    }
}

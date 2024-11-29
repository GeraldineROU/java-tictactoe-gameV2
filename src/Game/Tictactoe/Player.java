package Game.Tictactoe;

public class  Player {
    private State state;
    private String type;
    public static final String HUMAN = "Human";
    public static final String COMPUTER = "Computer";

    public Player(State state) {
        this.state = state;
        this.type = HUMAN;
    }

    public State getState() {
        return state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return state.getValue();
    }
}

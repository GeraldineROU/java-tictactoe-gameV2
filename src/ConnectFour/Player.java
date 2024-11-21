package ConnectFour;

public class Player {
    private State state;

    public Player(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return state.getValue();
    }
}

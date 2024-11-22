package ConnectFour;

public class Cell {
    private State state;

    public Cell() {
        state = State.EMPTY;
    }

    public String getRepresentation() {
        return state.getValue();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isPlayed() {
        return state != State.EMPTY;
    }

    public boolean isEmpty() {
        return state == State.EMPTY;
    }

}

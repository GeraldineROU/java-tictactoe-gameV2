package Game;

public enum State {

    EMPTY ("   "),
    X (" X "),
    O(" O ");

    private final String value;

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package Game;

public class Cell {
    private String representation;

    public Cell(String content) {
        this.representation = content;
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    public boolean isEmpty() {
        return representation.equals("   ");
    }

    public boolean isCrossMarked(Player player) {
        return representation.equals(player.getPlayerMark());
    }

    public boolean hasTheSameRepresentation(Cell cell) {
        return representation.equals(cell.getRepresentation());
    }

}

package src;

public class Knight extends Piece {
    public Knight(Pos pos, boolean isWhite) {
        super(pos, 3, isWhite, "Knight", 'k');
    }

    public boolean canMove(Pos moveTo) {

        int moveToRow = moveTo.getRow();
        int moveToColum = moveTo.getColum();
        int currentRow = this.getPos().getRow();
        int currentColum = this.getPos().getColum();

        if ((currentRow + 1 == moveToRow && currentColum + 2 == moveToColum)
                || (currentRow - 1 == moveToRow && currentColum - 2 == moveToColum)
                || (currentRow + 1 == moveToRow && currentColum - 2 == moveToColum)
                || (currentRow - 2 == moveToRow && currentColum - 1 == moveToColum)
                || (currentRow + 2 == moveToRow && currentColum - 1 == moveToColum)
                || (currentRow + 2 == moveToRow && currentColum + 1 == moveToColum)
                || (currentRow + 1 == moveToRow && currentColum + 2 == moveToColum)
                || (currentRow - 1 == moveToRow && currentColum + 2 == moveToColum)
                || (currentRow - 2 == moveToRow && currentColum + 1 == moveToColum)) {
            return true;
        }
        return false;
    }

}

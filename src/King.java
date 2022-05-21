package src;

public class King extends Piece {
    private boolean isInCheck = false;

    public King(Pos pos, boolean isWhite) {
        super(pos, 100, isWhite, "King", 'K');
    }

    public boolean canMove(Pos moveTo) {
        int moveToRow = moveTo.getRow();
        int moveToColum = moveTo.getColum();
        int currentRow = this.getPos().getRow();
        int currentColum = this.getPos().getColum();

        if(currentColum + 1 == moveToColum || currentRow + 1 == moveToRow || currentColum - 1 == moveToColum || currentRow - 1 == moveToRow){

        }
        return false;
    }

}

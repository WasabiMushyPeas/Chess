package src;

public class Knight extends Piece {
    public Knight(Pos pos, Boolean isWhite) {
        super(pos, 3, isWhite, "Knight", 'k');
    }

    public Boolean move(Pos moveTo) {
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

                    if(Main.chessBoard.getBoard(moveTo) == null){
                        super.moved();
                        Main.chessBoard.setPos(this, this.getPos(), moveTo);
                        return true;
                    }else{
                        if(Main.chessBoard.getBoard(moveTo).isWhite() != this.isWhite())
                        Main.chessBoard.takePos(moveTo, this.isWhite());
                        super.moved();
                        Main.chessBoard.setPos(this, this.getPos(), moveTo);
                        return true;
                    }

        }
        return false;

    }

}

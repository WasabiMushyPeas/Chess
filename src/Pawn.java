package src;

public class Pawn extends Piece {

    public Pawn(Pos pos, boolean isWhite) {
        super(pos, 1, isWhite, "pawn", 'p');
    }


    public boolean canMove(Pos moveTo) {
        if (super.isWhite()) {
            if (super.getPos().getColum() - 1 == moveTo.getColum()) {
                if (Main.chessBoard.getBoard(moveTo) == null && moveTo.getRow() == super.getPos().getRow()) {
                    return true;
                }

                if (Main.chessBoard.getBoard(moveTo) != null && (super.getPos().getRow() + 1 == moveTo.getRow()
                        || super.getPos().getRow() - 1 == moveTo.getRow())) {

                    return true;

                }
            } else {
                if (super.getPos().getColum() - 2 == moveTo.getColum() && Main.chessBoard.getBoard(moveTo) == null
                        && moveTo.getRow() == super.getPos().getRow()
                        && Main.chessBoard.getBoard(new Pos(moveTo.getRow(), moveTo.getColum() + 1)) == null) {

                    return true;
                }

            }
        } else {
            if (super.getPos().getColum() + 1 == moveTo.getColum()) {
                if (Main.chessBoard.getBoard(moveTo) == null && moveTo.getRow() == super.getPos().getRow()) {

                    return true;
                }

                if (Main.chessBoard.getBoard(moveTo) != null && (super.getPos().getRow() + 1 == moveTo.getRow()
                        || super.getPos().getRow() - 1 == moveTo.getRow())) {
                    return true;

                }
            } else {
                if (super.getPos().getColum() + 2 == moveTo.getColum() && Main.chessBoard.getBoard(moveTo) == null
                        && moveTo.getRow() == super.getPos().getRow()
                        && Main.chessBoard.getBoard(new Pos(moveTo.getRow(), moveTo.getColum() - 1)) == null) {
                    return true;
                }

            }
        }
        return false;

    }

}

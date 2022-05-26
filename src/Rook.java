package src;

public class Rook extends Piece {
    public Rook(Pos pos, boolean isWhite) {
        super(pos, 5, isWhite, "Rook", 'R');
    }

    public boolean canMove(Pos moveTo) {
        int moveToRow = moveTo.getRow();
        int moveToColum = moveTo.getColum();
        int currentRow = this.getPos().getRow();
        int currentColum = this.getPos().getColum();

        if (moveToRow == currentRow) {
            if (moveToColum < currentColum) {
                for (int i = currentColum - 1; i > moveToColum; i--) {
                    if (Main.chessBoard.getBoard(new Pos(currentRow, i)) != null) {
                        // System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            } else {
                if (currentColum < moveToColum) {
                    for (int i = currentColum + 1; i < moveToColum; i++) {
                        if (Main.chessBoard.getBoard(new Pos(currentRow, i)) != null) {
                            // System.out.println("There is a piece in the way");
                            return false;
                        }
                    }
                }
            }
        } else {
            if (moveToColum == currentColum) {
                if (moveToRow < currentRow) {
                    for (int i = moveToRow + 1; i < currentRow; i++) {
                        if (Main.chessBoard.getBoard(new Pos(i, currentColum)) != null) {
                            // System.out.println("There is a piece in the way");
                            return false;
                        }
                    }
                } else {
                    if (currentRow < moveToRow) {
                        for (int i = currentRow + 1; i < moveToRow; i++) {
                            if (Main.chessBoard.getBoard(new Pos(i, currentColum)) != null) {
                                // System.out.println("There is a piece in the way");
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if ((moveToRow == currentRow) || (moveToColum == currentColum)) {
            return true;
        }
        return false;
    }

}

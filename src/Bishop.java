package src;

public class Bishop extends Piece {
    public Bishop(Pos pos, boolean isWhite) {
        super(pos, 5, isWhite, "Bishop", 'B');
    }

    public boolean move(Pos moveTo) {
        int moveToRow = moveTo.getRow();
        int moveToColum = moveTo.getColum();
        int currentRow = this.getPos().getRow();
        int currentColum = this.getPos().getColum();
        int diff = Math.abs(moveToRow - currentRow);

        if (Math.abs(moveToRow - currentRow) == Math.abs(moveToColum - currentColum)) {
            if (moveToColum < currentColum && moveToRow < currentRow) {
                for (int i = 1; i <= diff - 1; i++) {
                    if (Main.chessBoard.getBoard(new Pos(currentColum - i, currentRow - i)) != null) {
                        System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
            if (moveToColum > currentColum && moveToRow < currentRow) {
                for (int i = 1; i <= diff - 1; i++) {
                    if (Main.chessBoard.getBoard(new Pos(currentRow - i, currentColum + i)) != null) {
                        System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
            if (moveToColum < currentColum && moveToRow > currentRow) {
                for (int i = 1; i <= diff - 1; i++) {
                    if (Main.chessBoard.getBoard(new Pos(currentRow + i, currentColum - i)) != null) {
                        System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
            if (moveToColum > currentColum && moveToRow > currentRow) {
                for (int i = 1; i <= diff - 1; i++) {
                    if (Main.chessBoard.getBoard(new Pos(currentRow + i, currentColum + i)) != null) {
                        System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        if (Main.chessBoard.getBoard(moveTo) == null) {
            super.moved();
            Main.chessBoard.setPosBoard(this, this.getPos(), moveTo);
            return true;
        } else {
            if (!Main.chessBoard.getBoard(moveTo).isWhite() == this.isWhite()) {
                Main.chessBoard.takePos(moveTo, this.isWhite());
                super.moved();
                Main.chessBoard.setPosBoard(this, this.getPos(), moveTo);
                return true;
            }

        }
        return false;

    }

}

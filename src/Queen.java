package src;

public class Queen extends Piece {
    public Queen(Pos pos, boolean isWhite) {
        super(pos, 9, isWhite, "Queen", 'Q');
    }


    public boolean canMove(Pos moveTo) {
        int moveToRow = moveTo.getRow();
        int moveToColum = moveTo.getColum();
        int currentRow = this.getPos().getRow();
        int currentColum = this.getPos().getColum();
        int diff = Math.abs(moveToRow - currentRow);

        if (moveToRow == currentRow) {
            if (moveToColum < currentColum) {
                for (int i = currentColum - 1; i > moveToColum; i--) {
                    if (Main.chessBoard.getBoard(new Pos(currentRow, i)) != null) {
                        //System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            } else {
                if (currentColum < moveToColum) {
                    for (int i = currentColum + 1; i < moveToColum; i++) {
                        if (Main.chessBoard.getBoard(new Pos(currentRow, i)) != null) {
                            //System.out.println("There is a piece in the way");
                            return false;
                        }
                    }
                }
            }
        } else if (moveToColum == currentColum) {
            if (moveToRow < currentRow) {
                for (int i = moveToRow + 1; i > currentRow; i++) {
                    if (Main.chessBoard.getBoard(new Pos(i, currentColum)) != null) {
                        //System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            } else {
                if (currentRow < moveToRow) {
                    for (int i = currentRow + 1; i < moveToRow; i++) {
                        if (Main.chessBoard.getBoard(new Pos(i, currentColum)) != null) {
                            //System.out.println("There is a piece in the way");
                            return false;
                        }
                    }
                }
            }
        } else if (Math.abs(moveToRow - currentRow) == Math.abs(moveToColum - currentColum)) {

            if (moveToColum < currentColum && moveToRow < currentRow) {
                for (int i = 1; i <= diff - 1; i++) {
                    if (Main.chessBoard.getBoard(new Pos(currentColum - i, currentRow - i)) != null) {
                        //System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
            if (moveToColum > currentColum && moveToRow < currentRow) {
                for (int i = 1; i <= diff - 1; i++) {
                    if (Main.chessBoard.getBoard(new Pos(currentRow - i, currentColum + i)) != null) {
                        //System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
            if (moveToColum < currentColum && moveToRow > currentRow) {
                for (int i = 1; i <= diff - 1; i++) {
                    if (Main.chessBoard.getBoard(new Pos(currentRow + i, currentColum - i)) != null) {
                        //System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }
            if (moveToColum > currentColum && moveToRow > currentRow) {
                for (int i = 1; i <= diff - 1; i++) {
                    if (Main.chessBoard.getBoard(new Pos(currentRow + i, currentColum + i)) != null) {
                        //System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }

        } else {
            return false;
        }
        if((Math.abs(moveToRow - currentRow) == Math.abs(moveToColum - currentColum)) || (moveToRow == currentRow) || (moveToColum == currentColum)){
            return true;
        }else{
            return false;
        }
        
    }
}

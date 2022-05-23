package src;

public class King extends Piece {
    private boolean isInCheck = false;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = " \u001b[31m";

    public King(Pos pos, boolean isWhite) {
        super(pos, 100, isWhite, "King", 'K');
    }

    public boolean canMove(Pos moveTo) {
        int moveToRow = moveTo.getRow();
        int moveToColum = moveTo.getColum();
        int currentRow = this.getPos().getRow();
        int currentColum = this.getPos().getColum();

        if (currentColum + 1 == moveToColum || currentRow + 1 == moveToRow || currentColum - 1 == moveToColum
                || currentRow - 1 == moveToRow) {
                    if(!this.isInCheck(moveTo)){
                        return true;
                    }else{
                        System.out.println("You can't move into check");
                        return false;
                    }
        }
        if (!this.hasMoved() && !this.isInCheck(moveTo) && currentRow + 3 == moveToRow && Main.chessBoard.getBoard(moveTo).getLetter() == 'R' && !Main.chessBoard.getBoard(moveTo).hasMoved()){
            return true;
        }
        if (!this.hasMoved() && !this.isInCheck(moveTo) && currentRow - 4 == moveToRow && Main.chessBoard.getBoard(moveTo).getLetter() == 'R' && !Main.chessBoard.getBoard(moveTo).hasMoved()){
            return true;
        }

        return false;
    }

    public boolean move(Pos moveTo){
        int moveToRow = moveTo.getRow();
        int moveToColum = moveTo.getColum();
        int currentRow = this.getPos().getRow();
        int currentColum = this.getPos().getColum();
        if (!this.hasMoved() && !this.isInCheck(moveTo) && currentRow + 3 == moveToRow && Main.chessBoard.getBoard(moveTo).getLetter() == 'R' && !Main.chessBoard.getBoard(moveTo).hasMoved()){
            Main.chessBoard.setPosBoard(Main.chessBoard.getBoard(moveTo), Main.chessBoard.getBoard(moveTo).getPos(), new Pos(Main.chessBoard.getBoard(moveTo).getPos().getRow() - 2, Main.chessBoard.getBoard(moveTo).getPos().getColum()));
            Main.chessBoard.setPosBoard(this, this.getPos(), new Pos(currentRow + 2, currentColum));
            return true;
        }
        if (!this.hasMoved() && !this.isInCheck(moveTo) && currentRow - 4 == moveToRow && Main.chessBoard.getBoard(moveTo).getLetter() == 'R' && !Main.chessBoard.getBoard(moveTo).hasMoved()){
            Main.chessBoard.setPosBoard(Main.chessBoard.getBoard(moveTo), Main.chessBoard.getBoard(moveTo).getPos(), new Pos(Main.chessBoard.getBoard(moveTo).getPos().getRow() + 3, Main.chessBoard.getBoard(moveTo).getPos().getColum()));
            Main.chessBoard.setPosBoard(this, this.getPos(), new Pos(currentRow - 2, currentColum));
            return true;
        }
        return false;
    }

    public boolean isInCheck() {
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (Main.chessBoard.getBoard(new Pos(i, k)) != null
                        && Main.chessBoard.getBoard(new Pos(i, k)).isWhite() != this.isWhite()
                        && canMove(this.getPos())) {
                    if(isInCheck){
                        Main.chessBoard.endGame(this.isWhite());
                    }
                    if(this.isWhite()){
                        System.out.println(ANSI_RED + "blue is in check" + ANSI_RESET);
                        
                    }else{
                        System.out.println(ANSI_RED + "red is in check" + ANSI_RESET);
                        
                    }
                    isInCheck = true;
                    return true;
                }
            }
        }
        isInCheck = false;
        return false;
        
    }

    public boolean isInCheck(Pos isPosInCheck) {
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (Main.chessBoard.getBoard(new Pos(i, k)) != null
                        && Main.chessBoard.getBoard(new Pos(i, k)).isWhite() != this.isWhite()
                        && canMove(isPosInCheck)) {
                    return true;
                }
            }
        }
        return false;
    }

}

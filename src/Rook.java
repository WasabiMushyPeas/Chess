package src;

public class Rook extends Piece {
    public Rook(Pos pos, Boolean isWhite) {
        super(pos, 5, isWhite, "Rook", 'R');
    }

    public Boolean move(Pos moveTo) {

        if (this.getPos().getRow() == moveTo.getRow()) {
            if (this.getPos().getColum() > moveTo.getColum()) {
                for (int i = 0; i < (this.getPos().getColum() - moveTo.getColum()) + 1; i++) {
                    int test1 = (i + moveTo.getColum());
                    if (Main.chessBoard.getBoard(new Pos(moveTo.getRow(), (i + moveTo.getColum()))) != null) {
                        return false;
                    }
                }

            } else {
                for (int i = 0; i < (moveTo.getColum() - this.getPos().getColum()) - 1; i++) {
                    int test2 = (this.getPos().getColum() - i);
                    if (Main.chessBoard
                            .getBoard(new Pos(moveTo.getRow(), (this.getPos().getColum() - i))) != null) {
                        return false;
                    }
                }

            }
            






            if (Main.chessBoard.getBoard(moveTo) == null) {

                super.moved();
                Main.chessBoard.setPos(this, this.getPos(), moveTo);
                return true;

            } else {
                Main.chessBoard.takePos(moveTo, this.isWhite());
                super.moved();
                Main.chessBoard.setPos(this, this.getPos(), moveTo);
                return true;
            }



        } else {
            if (this.getPos().getColum() == moveTo.getColum()) {

                if (this.getPos().getRow() > moveTo.getRow()) {
                    for (int i = 0; i < (this.getPos().getRow() - moveTo.getRow()) + 1; i++) {
                        int test1 = (i + moveTo.getRow()) + 1;
                        if (Main.chessBoard.getBoard(new Pos((i + moveTo.getRow()) + 1, moveTo.getColum())) != null) {
                            return false;
                        }
                    }
            
                } else {
                    for (int i = 0; i < (moveTo.getRow() - this.getPos().getRow()) - 1; i++) {
                        int test2 = (this.getPos().getRow() - i) - 1;
                        if (Main.chessBoard.getBoard(new Pos((this.getPos().getRow() - i) - 1, moveTo.getColum())) != null) {
                            return false;
                        }
                    }
            
                }
               

            if (Main.chessBoard.getBoard(moveTo) == null) {

                super.moved();
                Main.chessBoard.setPos(this, this.getPos(), moveTo);
                return true;

            } else {
                Main.chessBoard.takePos(moveTo, this.isWhite());
                super.moved();
                Main.chessBoard.setPos(this, this.getPos(), moveTo);
                return true;
            }


            }


        }
        return false;
    }

}

package src;

public class Rook extends Piece {
    public Rook(Pos pos, Boolean isWhite) {
        super(pos, 5, isWhite, "Rook", 'R');
    }

    public Boolean move(Pos moveTo) {
        int moveToRow = moveTo.getRow();
        int moveToColum = moveTo.getColum();
        int currentRow = this.getPos().getRow();
        int currentColum = this.getPos().getColum();


        if(moveToRow == currentRow){
            if(moveToColum < currentColum){
                for(int i = currentColum - 1; i > moveToColum; i--){
                    if(Main.chessBoard.getBoard(new Pos(currentRow, i)) != null){
                        System.out.println("There is a piece in the way");
                        return false;
                    }
                }
            }else{
                if(currentColum < moveToColum){
                    for(int i = currentColum + 1; i < moveToColum; i++){
                        if(Main.chessBoard.getBoard(new Pos(currentRow, i)) != null){
                            System.out.println("There is a piece in the way");
                            return false;
                        }
                    }
                }
            }
        }else{
            if(moveToColum == currentColum){
                if(moveToRow < currentRow){
                    for(int i = currentRow - 1; i > moveToRow; i++){
                        if(Main.chessBoard.getBoard(new Pos(i, currentColum)) != null){
                            System.out.println("There is a piece in the way");
                            return false;
                        }
                    }
                }else{
                    if(currentRow < moveToRow){
                        for(int i = currentRow + 1; i < moveToRow; i++){
                            if(Main.chessBoard.getBoard(new Pos(i, currentColum)) != null){
                                System.out.println("There is a piece in the way");
                                return false;
                            }
                        }
                    }
                }
            }
        }


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

}

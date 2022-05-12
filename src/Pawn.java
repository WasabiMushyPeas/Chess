package src;
public class Pawn extends Piece {

    public Pawn(Pos pos, Boolean isWhite){
        super(pos, 1, isWhite);
    }

    public Boolean move(Pos moveTo){
        if(super.isWhite()){
            if(super.getPos().getColum() + 1 == moveTo.getColum()){
                if(Main.chessBoard.getBoard(moveTo) == null && moveTo.getRow() == super.getPos().getRow()){
                    super.move();
                    Main.chessBoard.setPos(this, this.getPos(), moveTo);
                    return true;
                }
                if(Main.chessBoard.getBoard(moveTo) != null){

                }
            }
        }

        
    }
    
}

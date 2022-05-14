package src;
public class Pawn extends Piece {

    public Pawn(Pos pos, Boolean isWhite){
        super(pos, 1, isWhite, "pawn");
    }

    public Boolean move(Pos moveTo){
        if(super.isWhite()){
            if(super.getPos().getColum() + 1 == moveTo.getColum()){
                if(Main.chessBoard.getBoard(moveTo) == null && moveTo.getRow() == super.getPos().getRow()){
                    super.move();
                    Main.chessBoard.setPos(this, this.getPos(), moveTo);
                    return true;
                }
                if(Main.chessBoard.getBoard(moveTo) != null && (super.getPos().getRow() + 1 == moveTo.getRow() || super.getPos().getRow() - 1 == moveTo.getRow())){
                    Main.chessBoard.getBoard(moveTo).take();

                }
            }
        }

        
    }
    
}

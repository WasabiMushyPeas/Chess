package src;
public class Pawn extends Piece {

    public Pawn(Pos pos, Boolean isWhite){
        super(pos, 1, isWhite, "pawn", 'p');
    }

    public Boolean move(Pos moveTo){
        if(super.isWhite()){
            if(super.getPos().getColum() - 1 == moveTo.getColum()){
                if(Main.chessBoard.getBoard(moveTo) == null && moveTo.getRow() == super.getPos().getRow()){
                    super.moved();
                    Main.chessBoard.setPos(this, this.getPos(), moveTo);
                    return true;
                }

                if(Main.chessBoard.getBoard(moveTo) != null && (super.getPos().getRow() + 1 == moveTo.getRow() || super.getPos().getRow() - 1 == moveTo.getRow())){
                    Main.chessBoard.takePos(moveTo);
                    super.moved();
                    Main.chessBoard.setPos(this, this.getPos(), moveTo);
                    return true;

                }
            }else{
                if(super.getPos().getColum() - 2 == moveTo.getColum() && Main.chessBoard.getBoard(moveTo) == null && moveTo.getRow() == super.getPos().getRow() && Main.chessBoard.getBoard(new Pos(moveTo.getRow(), moveTo.getColum()-1)) == null){
                    super.moved();
                    Main.chessBoard.setPos(this, this.getPos(), moveTo);
                    return true;
                }

            }
        }
        return false;        
    }
    
}

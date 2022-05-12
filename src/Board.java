package src;
public class Board {
    private Piece[][] board = new Piece[8][8];

    public Board(){
        board = setupBoard();
    }

    public Piece[][] getBoard(){
        return board;
    }

    public Piece[] getBoard(int row){
        return board[row];
    }

    public Piece getBoard(Pos pos){
        return board[pos.getRow()][pos.getColum()];
    }

    public Piece[][] setPos(Piece piece, Pos OldPos, Pos NewPos){
        board[OldPos.getRow()][OldPos.getColum()] = null;
        board[NewPos.getRow()][NewPos.getColum()] = piece;
        return board;
    }

    public Pos getPosOfPiece(Piece piece){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j].equals(piece)){
                    Pos piecePos = new Pos(i, j);
                    return piecePos;
                }
            }
        }
        Pos piecePos = new Pos(-1, -1);
        return piecePos;
    }


    private Piece[][] setupBoard(){
        Piece[][] tempBoard = new Piece[8][8];
        
        

        return tempBoard;
    }
}

package src;


public class Board {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = " \u001b[31m";
    public static final String ANSI_BLUE = " \u001b[34m";

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
        for(int i = 0; i < tempBoard.length; i++){
            tempBoard[i][1] = new Pawn(new Pos(i, 1), true);
        }

        for(int i = 0; i < tempBoard.length; i++){
            tempBoard[i][6] = new Pawn(new Pos(i, 6), false);
        }

        
        

        return tempBoard;
    }

    public void printBoard(){
        int cPieceCol = 0;
        int cPieceRow = 0;
        for(int i = 0; i < board.length*2 + 1; i++){
            if((i + 2) % 2 == 0){
                for(int j = 0; j < board.length*5 + 2; j++){
                    System.out.print("=");
                }
                System.out.println("");
            }else{
                for(int j = 0; j < board.length*2 + 1; j++){
                    
                    if((j + 2) % 2 == 0){
                        System.out.print("||");
                    }else{
                        if(this.getBoard(new Pos(cPieceCol, cPieceRow)) != null){
                            if(this.getBoard(new Pos(cPieceCol, cPieceRow)).isWhite()){
                                System.out.print(ANSI_BLUE+this.getBoard(new Pos(cPieceCol, cPieceRow)).getLetter()+ " "+ANSI_RESET);
                            }else{
                                System.out.print(ANSI_RED+this.getBoard(new Pos(cPieceCol, cPieceRow)).getLetter()+ " "+ANSI_RESET);
                            }
                            
                        }else{
                            System.out.print("   ");
                        }

                        cPieceCol++;
                    }
                }
                System.out.println("");
                cPieceRow++;
                cPieceCol = 0;
            }
        }
    }
}

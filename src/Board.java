package src;

public class Board {
    char[] chessLingoLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = " \u001b[31m";
    public static final String ANSI_BLUE = " \u001b[34m";

    private Piece[][] board = new Piece[8][8];

    public Board() {
        board = setupBoard();
    }

    public Piece[][] getBoard() {
        return board;
    }

    public Piece[] getBoard(int row) {
        return board[row];
    }

    public Piece getBoard(Pos pos) {
        return board[pos.getRow()][pos.getColum()];
    }

    public Piece[][] setPosBoard(Piece piece, Pos OldPos, Pos NewPos) {
        board[OldPos.getRow()][OldPos.getColum()] = null;
        board[NewPos.getRow()][NewPos.getColum()] = piece;
        piece.setPos(NewPos);
        return board;
    }

    public void takePos(Pos setPos, boolean isWhite) {
        if (this.getBoard(setPos).isWhite() != isWhite) {
            board[setPos.getRow()][setPos.getColum()] = null;
        }
    }

    public Pos getPosOfPiece(Piece piece) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(piece)) {
                    Pos piecePos = new Pos(i, j);
                    return piecePos;
                }
            }
        }
        Pos piecePos = new Pos(-1, -1);
        return piecePos;
    }

    public Pos getPosOfPiece(boolean isWhite, Character letter) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].isWhite() == isWhite && board[i][j].getLetter() == letter) {
                    Pos piecePos = new Pos(i, j);
                    return piecePos;
                }
            }
        }
        Pos piecePos = new Pos(-1, -1);
        return piecePos;
    }

    public void endGame(boolean winnerIsWhite){
        if(winnerIsWhite){
            System.out.println("The winner is blue!");
            System.exit(0);
        }else{
            System.out.println("The winner is red!");
            System.exit(0);
        }
        
    }

    public boolean humanInput(String input) {
        int currentRow = 0;
        int currentColum = 0;
        int moveRow = 0;
        int moveColum = 0;
        if (input.length() == 5) {
            if (input.charAt(1) != ' ') {
                currentColum = 7 - (Character.getNumericValue(input.charAt(1)) - 1);
            } else {
                return false;
            }
            if (input.charAt(0) != ' ') {
                for (int i = 0; i < chessLingoLetters.length; i++) {
                    if (input.charAt(0) == chessLingoLetters[i]) {
                        currentRow = i;
                    }
                }

            } else {
                return false;
            }

            if (input.charAt(4) != ' ') {
                moveColum = 7 - (Character.getNumericValue(input.charAt(4)) - 1);
            } else {
                return false;
            }
            if (input.charAt(3) != ' ') {
                for (int i = 0; i < chessLingoLetters.length; i++) {
                    if (input.charAt(3) == chessLingoLetters[i]) {
                        moveRow = i;
                    }
                }

            } else {
                return false;
            }
            if (moveRow >= 0 && moveRow <= 7) {
                if (Main.chessBoard.getBoard(new Pos(currentRow, currentColum)) != null
                        /*&& Main.chessBoard.getBoard(new Pos(currentRow, currentColum)).isWhite()*/) {
                    return Main.chessBoard.getBoard(new Pos(currentRow, currentColum))
                            .move(new Pos(moveRow, moveColum));
                }
            }

        }
        return false;

    }

    private Piece[][] setupBoard() {
        Piece[][] tempBoard = new Piece[8][8];
        for (int i = 0; i < tempBoard.length; i++) {
            tempBoard[i][1] = new Pawn(new Pos(i, 1), false);
        }

        for (int i = 0; i < tempBoard.length; i++) {
            tempBoard[i][6] = new Pawn(new Pos(i, 6), true);
        }
        tempBoard[0][0] = new Rook(new Pos(0, 0), false);
        tempBoard[7][0] = new Rook(new Pos(7, 0), false);
        tempBoard[1][0] = new Knight(new Pos(1, 0), false);
        tempBoard[6][0] = new Knight(new Pos(6, 0), false);
        tempBoard[2][0] = new Bishop(new Pos(2, 0), false);
        tempBoard[5][0] = new Bishop(new Pos(5, 0), false);
        tempBoard[3][0] = new Queen(new Pos(3, 0), false);
        tempBoard[4][0] = new King(new Pos(4, 0), false);

        tempBoard[0][7] = new Rook(new Pos(0, 7), true);
        tempBoard[7][7] = new Rook(new Pos(7, 7), true);
        tempBoard[1][7] = new Knight(new Pos(1, 7), true);
        tempBoard[6][7] = new Knight(new Pos(6, 7), true);
        tempBoard[2][7] = new Bishop(new Pos(2, 7), true);
        tempBoard[5][7] = new Bishop(new Pos(5, 7), true);
        tempBoard[3][7] = new Queen(new Pos(3, 7), true);
        tempBoard[4][7] = new King(new Pos(4, 7), true);

        return tempBoard;
    }

    public void printBoard() {
        int cPieceCol = 0;
        int cPieceRow = 0;
        int chessRow = 8;
        System.out.print("  ");
        for (int k = 0; k < board.length; k++) {
            System.out.print("   " + chessLingoLetters[k] + " ");
        }
        System.out.println("");
        for (int i = 0; i < board.length * 2 + 1; i++) {

            if ((i + 2) % 2 == 0) {
                for (int j = 0; j < board.length * 5 + 4; j++) {
                    if (j == 0 || j == 1) {
                        System.out.print(" ");

                    } else {
                        System.out.print("=");
                    }

                }
                System.out.println("");
            } else {
                System.out.print(chessRow + " ");
                chessRow--;
                for (int j = 0; j < board.length * 2 + 1; j++) {

                    if ((j + 2) % 2 == 0) {
                        System.out.print("||");
                    } else {
                        if (this.getBoard(new Pos(cPieceCol, cPieceRow)) != null) {
                            if (this.getBoard(new Pos(cPieceCol, cPieceRow)).isWhite()) {
                                System.out.print(ANSI_BLUE + this.getBoard(new Pos(cPieceCol, cPieceRow)).getLetter()
                                        + " " + ANSI_RESET);
                            } else {
                                System.out.print(ANSI_RED + this.getBoard(new Pos(cPieceCol, cPieceRow)).getLetter()
                                        + " " + ANSI_RESET);
                            }

                        } else {
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

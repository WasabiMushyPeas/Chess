package src;

public class Piece {
    private Pos position = new Pos();
    private int value;
    private boolean isWhite = true;
    private boolean HasMoved = false;
    private String name;
    private Character letter;

    public Piece(Pos pos, int value, boolean isWhite, String name, Character leter) {
        position = pos;
        this.value = value;
        this.isWhite = isWhite;
        this.name = name;
        this.letter = leter;
    }

    public Pos setPos(Pos pos) {
        Pos temp = position;
        position = pos;
        return temp;
    }

    public Pos getPos() {
        return position;
    }

    public boolean hasMoved() {
        return HasMoved;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public int getValue() {
        return value;
    }

    public boolean equals(Piece piece) {
        return position == piece.getPos() && isWhite == piece.isWhite() && value == piece.getValue();
    }

    public String name() {
        return name;
    }

    public Character getLetter() {
        return letter;
    }

    public boolean move(Pos moveTo) {
        if (canMove(moveTo)) {
            if (Main.chessBoard.getBoard(moveTo) == null) {
                HasMoved = true;
                Main.chessBoard.setPosBoard(this, this.getPos(), moveTo);
                Main.chessBoard.getBoard(Main.chessBoard.getPosOfPiece(!this.isWhite(), 'K')).isInCheck();
                return true;
            } else {
                if (Main.chessBoard.getBoard(moveTo).isWhite() != this.isWhite())
                    Main.chessBoard.takePos(moveTo, this.isWhite());
                HasMoved = true;
                Main.chessBoard.setPosBoard(this, this.getPos(), moveTo);
                Main.chessBoard.getBoard(Main.chessBoard.getPosOfPiece(!this.isWhite(), 'K')).isInCheck();
                return true;
            }
        }
        return false;

    }

    public boolean isInCheck(){
        return false;
    }
    public boolean canMove(Pos moveTo){
        return false;
    }
}

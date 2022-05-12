package src;
public class Piece {
    private Pos position = new Pos();
    private int value;
    private Boolean isAlive = true;
    private Boolean isWhite = true;
    private Boolean HasMoved = false;

    public Piece(Pos pos, int value, boolean isWhite){
        position = pos;
        this.value = value;
        this.isWhite = isWhite;
    }

    public Pos setPos(Pos pos){
        Pos temp = position;
        position = pos;
        return temp;
    }

    public Pos getPos(){
        return position;
    }

    public void move(){
        HasMoved = true;
    }

    public boolean hasMoved(){
        return HasMoved;
    }

    public boolean isWhite(){
        return isWhite;
    }

    
}

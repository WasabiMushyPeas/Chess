package src;
public class Piece {
    private Pos position = new Pos();
    private int value;
    private Boolean isAlive = true;
    private Boolean isWhite = true;
    private Boolean HasMoved = false;
    private String name;
    private Character letter;

    public Piece(Pos pos, int value, boolean isWhite, String name, Character leter){
        position = pos;
        this.value = value;
        this.isWhite = isWhite;
        this.name = name;
        this.letter = leter;
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

    public int getValue(){
        return value;
    }

    public boolean equals(Piece piece){
        return position == piece.getPos() && isWhite == piece.isWhite() && value == piece.getValue();
    }

    public String name(){
        return name;
    }

    public void take(){

    }

    public Character getLetter(){
        return letter;
    }

    
}

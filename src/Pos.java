package src;

public class Pos {
    private int row;
    private int colum;

    public Pos() {
        row = 0;
        colum = 0;
    }

    public Pos(int row, int colum) {
        this.row = row;
        this.colum = colum;
    }

    public int[] getPos() {
        int[] pos = { row, colum };
        return pos;
    }

    public int getRow() {
        return row;
    }

    public int getColum() {
        return colum;
    }

    public void setPos(int[] RowColum) {
        row = RowColum[0];
        colum = RowColum[1];
    }

    public void setPos(int row, int colum) {
        this.row = row;
        this.colum = colum;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

}

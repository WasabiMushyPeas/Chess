package src;

import java.util.Scanner;

public class Main{
    public static Board chessBoard = new Board();
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
    
        chessBoard.printBoard();
        
        System.out.println("You are blue your move first type you move (EX Piece R at a8 to a5 so \"a8 a5\"):");
        while(true){
            String input = myScanner.nextLine();
            if(input != ""){
                chessBoard.humanInput(input);
            }
            chessBoard.printBoard();
            System.out.println("Take another move:");
        }
        
    }
}
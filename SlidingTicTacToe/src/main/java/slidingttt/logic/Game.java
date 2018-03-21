/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;
import java.util.Scanner;

/**
 *
 * @author Valhe Kouneli
 */
public class Game {
    
    private Board board;
    
    
    public Game(int size) {
        board = new Board(size);

    }
    
    public void start() {
        Scanner reader = new Scanner(System.in);
        reader.close();
        System.out.println(board.toString());
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean move(Piece piece, int destination) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}

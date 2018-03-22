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
    
    private Situation situation;
    
    
    public Game(int size) {
        situation = new Situation(size);

    }
    
    public void start() {
        Scanner reader = new Scanner(System.in);
        int orientation;
        int index;
        int from;
        int destination;
        Color turn;
        
        do {
            turn = situation.getTurn();
            do {
                System.out.println(situation.toString());
                System.out.println("Give orientation.");
                orientation = reader.nextInt();
                System.out.println("Give line index.");
                index = reader.nextInt();
                System.out.println("Give position 'from'.");
                from = reader.nextInt();
                System.out.println("Give destination.");
                destination = reader.nextInt();
            } while (!situation.move(new Move(situation.getTurn(), Orientation.values()[orientation], 
                    index, from, destination)));
        } while (!situation.checkForThreeInARow(turn));
        
        System.out.println("Winner: " + turn.name());
        
        
        reader.close();
        
    }
    
    public boolean move(Piece piece, int destination) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import slidingttt.board.Move;
import slidingttt.board.Situation;
import java.util.Scanner;

/**
 *
 * @author Valhe Kouneli
 */
public class HumanPlayer extends Player {

    Scanner reader;
    
    public HumanPlayer(Color  color) {
        super(color);
    }
    
    public void setScanner(Scanner reader) {
        this.reader = reader;
    }
    
    @Override
    Move getNextMove(Situation situation) {
        int orientation_nro;
        Orientation orientation;
        int index;
        int from;
        int dest;
        System.out.println(situation.toString());
        System.out.println("Give orientation.");
        orientation_nro = reader.nextInt();
        orientation = Orientation.values()[reader.nextInt()];
        System.out.println("Give line index.");
        index = reader.nextInt();
        System.out.println("Give position 'from'.");
        from = reader.nextInt();
        System.out.println("Give destination.");
        dest = reader.nextInt();
                
        return new Move(situation.getTurn(), orientation, 
                    index, from, dest);
    }
    
}

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
public class HumanPlayer extends Player {

    Scanner reader;
    
    public HumanPlayer(PieceColor  color) {
        super(color);
    }
    
    public void setScanner(Scanner reader) {
        this.reader = reader;
    }
    
    @Override
    public int[] getNextMove(Game game) {
        int x_from;
        int y_from;
        int x_to;
        int y_to;
        System.out.println(game.toString());
        System.out.println("Give x_from.");
        x_from = reader.nextInt();
        System.out.println("Give y_from index.");
        y_from = reader.nextInt();
        System.out.println("Give x_to.");
        x_to = reader.nextInt();
        System.out.println("Give y_to.");
        y_to = reader.nextInt();
                
        return new int[]{x_from, y_from, x_to, y_to};
    }
    
}

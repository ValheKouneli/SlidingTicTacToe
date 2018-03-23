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
    
    //TODO: Separate interface from Player!!
    @Override
    public int[] getNextMove(Game game) {
        int x_from;
        int y_from;
        int x_to;
        int y_to;
        final int boardSize = game.getSize();
        
        System.out.println(game.toString());
        
        do {
            System.out.println("Give x_from.");
            x_from = reader.nextInt();
        } while (!isLegal(x_from, boardSize));
        
        do {
            System.out.println("Give y_from index.");
            y_from = reader.nextInt();
        } while (!isLegal(y_from, boardSize));

        do {
            System.out.println("Give x_to.");
            x_to = reader.nextInt();
        } while (!isLegal(x_to, boardSize));
        
        do {
            System.out.println("Give y_to.");
            y_to = reader.nextInt();
        } while (!isLegal(y_to, boardSize));
                
        return new int[]{x_from, y_from, x_to, y_to};
    }
    
    private boolean isLegal(int i, int boardSize){
        boolean isLegal = i>=0 && i<=boardSize+1;
        if (!isLegal) {
            System.out.println("Not a valid coordinate.");
        }
        return isLegal;
    }
    
}

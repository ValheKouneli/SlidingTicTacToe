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
        int row_from;
        int col_from;
        int row_to;
        int col_to;
        final int boardSize = game.getSize();
        
        System.out.println(game.toString());
        
        do {
            System.out.println("Give row_from.");
            row_from = reader.nextInt();
        } while (!isLegal(row_from, boardSize));
        
        do {
            System.out.println("Give col_from index.");
            col_from = reader.nextInt();
        } while (!isLegal(col_from, boardSize));

        do {
            System.out.println("Give row_to.");
            row_to = reader.nextInt();
        } while (!isLegal(row_to, boardSize));
        
        do {
            System.out.println("Give y_to.");
            col_to = reader.nextInt();
        } while (!isLegal(col_to, boardSize));
                
        return new int[]{row_from, col_from, row_to, col_to};
    }
    
    private boolean isLegal(int i, int boardSize){
        boolean isLegal = i>=0 && i<=boardSize+1;
        if (!isLegal) {
            System.out.println("Not a valid coordinate.");
        }
        return isLegal;
    }
    
}

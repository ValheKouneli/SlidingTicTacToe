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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game(3);
        HumanPlayer red = new HumanPlayer(PieceColor.RED);
        HumanPlayer black = new HumanPlayer(PieceColor.BLACK);
        Scanner reader = new Scanner(System.in);
        red.setScanner(reader);
        black.setScanner(reader);
        PieceColor winner = null;
        PieceColor beginningColor = PieceColor.RED;
        
        while (true) {
            Player p;
            int[] move;
            PieceColor turn = beginningColor;
            do {
                if (turn == PieceColor.RED) {
                    p = red;
                } else {
                    p = black;
                }
                move = p.getNextMove(game);
                
            } while (!game.move(move));
            
            if (game.thereIsThreeInARow()) {
                break;
            }
            turn = game.nextTurn();
        } 
        
        winner = game.whoWasBefore();
        

    }
    
}

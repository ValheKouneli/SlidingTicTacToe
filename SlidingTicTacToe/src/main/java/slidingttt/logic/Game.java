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
public class Game {
    
    private Situation situation;
    private Player[] players;
    
    
    public Game(int size) {
        situation = new Situation(size);
        players = new Player[]
                {new HumanPlayer(Color.RED), new HumanPlayer(Color.BLACK)};

    }
    
    public void start() {
        //init();
        
        Move move;
        
        while (true) {
            do {
                move = players[situation.getTurn().ordinal()]
                        .getNextMove(situation);
            } while (!situation.move(move));
            if (situation.thereIsThreeInARow(situation.getTurn())) {
                break;
            }
            situation.nextTurn();
        } 
        
        System.out.println("Winner: " + situation.getTurn().toString());
        
 
        
    }
    
    
}

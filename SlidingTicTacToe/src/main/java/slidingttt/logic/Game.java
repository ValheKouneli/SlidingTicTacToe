/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;
import slidingttt.board.Move;
import slidingttt.board.Situation;

/**
 *
 * @author Valhe Kouneli
 */
public abstract class Game {
    
    private Situation situation;
    protected Player[] players;
    
    
    public Game(int size) {
        situation = new Situation(size);
        init();
        setPlayers();
    }
    
    public abstract void setPlayers();
    
    public void start() {
        
        Move move;
        
        while (true) {
            refreshDisplay();
            do {
                move = players[situation.getTurn().ordinal()]
                        .getNextMove(situation);
            } while (!situation.move(move));
            if (situation.thereIsThreeInARow(situation.getTurn())) {
                break;
            }
            situation.nextTurn();
        } 
        
        announceWinner();
    }
    
    public Situation getSituation() {
        return situation;
    }
    public abstract void init();
    public abstract void refreshDisplay();
    public abstract void announceWinner();
    
    
}

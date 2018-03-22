/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

/**
 *
 * @author Valhe Kouneli
 */
public abstract class Player {
    
    Color color;
    
    public Player(Color color) {
        this.color = color;
    }
    
    abstract Move getNextMove(Situation situation);
}

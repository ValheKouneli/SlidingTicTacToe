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
public abstract class Player {
    
    private PieceColor color;
    
    public Player(PieceColor color) {
        this.color = color;
    }
    
    abstract Move getNextMove(Situation situation);

    /**
     * @return the color
     */
    public PieceColor getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(PieceColor color) {
        this.color = color;
    }
}

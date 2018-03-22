/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.board;

import slidingttt.logic.Color;
import slidingttt.logic.Orientation;

/**
 *
 * @author Valhe Kouneli
 */
public class Move {
    

    private final int from;
    private final int to;
    private final Orientation orientation;
    private final int lineIndex;
    private final Color color;
    
    public Move(Color color, Orientation orientation, int lineIndex, int from, int to) {
        this.color = color;
        this.orientation = orientation;
        this.from = from;
        this.to = to;
        this.lineIndex = lineIndex;
    }
    
    public Orientation getOrientation() {
        return orientation;
    }
    
    public int getLineIndex() {
        return lineIndex;
    }
    
    public Color getColor() {
        return color;
    }
    
    public int getFrom() {
        return from;
    }
    
    public int getTo() {
        return to;
    }
    
    public Move getCopy() {
        return new Move(color, orientation, lineIndex, from, to);
    }
    
    public Move getOppositeMove() {
        return new Move(color, orientation, lineIndex, to, from);
    }
    
}

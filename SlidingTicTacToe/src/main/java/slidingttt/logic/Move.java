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
public class Move {
    

    private final int from;
    private final int to;
    private final int orientation;
    private final int lineIndex;
    private final int color;
    
    public Move(int color, int orientation, int lineIndex, int from, int to) {
        this.color = color;
        this.orientation = orientation;
        this.from = from;
        this.to = to;
        this.lineIndex = lineIndex;
    }
    
    public int getOrientation() {
        return orientation;
    }
    
    public int getLineIndex() {
        return lineIndex;
    }
    
    public int getColor() {
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

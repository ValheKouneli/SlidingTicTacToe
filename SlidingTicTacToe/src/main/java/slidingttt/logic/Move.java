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
    private final int line_number;
    private final int color;
    
    public Move(int color, int orientation, int line_number, int from, int to) {
        this.color = color;
        this.orientation = orientation;
        this.from = from;
        this.to = to;
        this.line_number = line_number;
    }
    
    public int getOrientation() {
        return orientation;
    }
    
    public int getLineNumber() {
        return line_number;
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
    
}

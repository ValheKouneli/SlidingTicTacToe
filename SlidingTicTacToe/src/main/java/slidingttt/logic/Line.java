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
public abstract class Line {
    
    private final int length;
    private int redPosition;
    private int blackPosition;
    private final String orientation;
    
    public Line(String orientation, int length){
        this.orientation = orientation;
        this.length = length;
    }
    
    public abstract void initLine();
    public abstract void setPieces(int redPosition, int blackPosition);
    
    public int getRedPosition() {
        return redPosition;
    }
    public int getBlackPosition() {
        return blackPosition;
    }
    public abstract boolean moveRed(int destination);
    public abstract boolean moveBlack(int destination);
    
    public String getOrientation() {
        return orientation;
    }
}

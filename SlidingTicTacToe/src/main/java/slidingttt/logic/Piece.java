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
public class Piece {
    
    private final int color;
    private int position;
    private final int orientation;
    private Piece otherPiece; //the other Piece on the same Line
    
    public Piece(int color, int orientation, int position) {
        this.color = color;
        this.orientation = orientation;
        this.position = position;
    }
    
    public void setOtherPiece(Piece piece) {
        this.otherPiece = piece;
    }
    
    public int getColor() {
        return color;
    }
    
    public int getOrientation() {
        return orientation;
    }
    
    public int getPosition(){
        return position;
    }
    
    public Piece getOtherPiece() {
        return otherPiece;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    
    public Piece getCopy(){
        Piece copy = new Piece(color, orientation, position);
        return copy;
    }
    
}

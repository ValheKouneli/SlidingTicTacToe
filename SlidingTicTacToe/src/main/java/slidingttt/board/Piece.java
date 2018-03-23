/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.board;

import slidingttt.logic.PieceColor;
import slidingttt.logic.Orientation;


/**
 *
 * @author Valhe Kouneli
 */
public class Piece {
    
    private final PieceColor color;
    private int position;
    private Orientation orientation;
    private Piece otherPiece; //the other Piece on the same Line
    
    public Piece(PieceColor color, Orientation orientation, int position) {
        this.color = color;
        this.orientation = orientation;
        this.position = position;
    }
    
    public void setOtherPiece(Piece piece) {
        this.otherPiece = piece;
    }
    
    public PieceColor getColor() {
        return color;
    }
    
    public Orientation getOrientation() {
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

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
    private int[] coordinates;
    private Orientation orientation;
    private Piece otherPiece; //the other Piece on the same Line
    
    public Piece(PieceColor color, Orientation orientation, int[] coordinates) {
        this.color = color;
        this.orientation = orientation;
        this.coordinates = coordinates;
    }
    
    public void setOtherPiece(Piece piece) {
        this.otherPiece = piece;
    }
    
    public PieceColor getColor() {
        return color;
    }
    
    public int getPosition(Orientation orientation) {
        return coordinates[orientation.ordinal()];
    }

    
    public Piece getOtherPiece() {
        return otherPiece;
    }
    public void setPosition(int position) {
        coordinates[orientation.ordinal()] = position;
    }
    
    public Piece getCopy(){
        Piece copy = new Piece(color, orientation, coordinates);
        return copy;
    }
    
}

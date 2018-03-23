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
    public boolean setPosition(int position) {
        /*
        * move is "physically impossible" if moved piece passes other piece on the same line
        */
        if (pieceIsTryingToPassAnother(coordinates[orientation.ordinal()], position, 
                otherPiece.getPosition(orientation))) {
            return false;
        } else {
            coordinates[orientation.ordinal()] = position;
            return true;
        }
    }
    
    private boolean pieceIsTryingToPassAnother(int orig, int dest,
            int otherPiecesPosition) {
        if (orig<dest) {
            return (orig < otherPiecesPosition && otherPiecesPosition < dest);
        } else {
            return (dest < otherPiecesPosition && otherPiecesPosition < orig);
        }
    }
    
    public Piece getCopy(){
        Piece copy = new Piece(color, orientation, coordinates);
        return copy;
    }
    
}

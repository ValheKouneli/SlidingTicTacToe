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
    
    private final String color;
    private int position;
    private Piece otherPieceOnTheSameLine;
    private final String orientation;
    
    public Piece(String color, String orientation) {
        this.color = color;
        this.orientation = orientation;
        this.otherPieceOnTheSameLine = null;
    }
    
    public void setOtherPiece(Piece otherPieceOnTheSameLine) {
        this.otherPieceOnTheSameLine = otherPieceOnTheSameLine;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getOrientation() {
        return orientation;
    }
    
    public int getPosition(){
        return position;
    }
    
    public void setPosition(int position){
        this.position = position;
    }
    
    public boolean move(int destinaton) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int[] getPossibleMoves(int reds_on_field, int blacks_on_field) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Piece getOtherPiece() {
        return otherPieceOnTheSameLine;
    }
    
    public Piece getCopy(){
        Piece copy = new Piece(color, orientation);
        copy.setOtherPiece(otherPieceOnTheSameLine);
        copy.setPosition(position);
        return copy;
    }
    
}

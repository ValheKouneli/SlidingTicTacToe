/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.board;

import slidingttt.board.Piece;
import java.security.InvalidParameterException;
import slidingttt.logic.PieceColor;
import slidingttt.logic.Orientation;

/**
 *
 * @author Valhe Kouneli
 */
public class Line {
    
    private final int length;
    private final int[] coordinates; //start of line
    private Piece red;
    private Piece black;
    private final Orientation orientation;
    
    public Line(Orientation orientation, int[] coordinates, int length){
        this.orientation = orientation;
        this.length = length;
        this.coordinates = coordinates;
        setBeginningPosition();
    }
    
    private void setBeginningPosition() {
        int[] red_coordinates = coordinates.clone();
        int[] black_coordinates = coordinates.clone();
        boolean redFirst = true;
        for (int i=0; i<coordinates.length; i++){
            if (coordinates[i] % 2 != 0) {
                redFirst = !redFirst;
                //I have no idea if this is right in 3-dimensions and up >.<
            }
        }
        
        if (redFirst) {
            red_coordinates[orientation.ordinal()] = 0;
            black_coordinates[orientation.ordinal()] = length-1;
        } else {
            red_coordinates[orientation.ordinal()] = length-1;
            black_coordinates[orientation.ordinal()] = 0;
        }
        red = new Piece(PieceColor.RED, orientation, red_coordinates);
        black = new Piece(PieceColor.BLACK, orientation, black_coordinates);
        red.setOtherPiece(black);
        black.setOtherPiece(red);

    }
    
    public boolean move(PieceColor color, int position) {
        return getPiece(color).setPosition(position);
    }
    
    public PieceColor getColorInPosition(int position) {
        if (red.getPosition(orientation) == position) {
            return PieceColor.RED;
        } else if (black.getPosition(orientation) == position) {
            return PieceColor.BLACK;
        } else {
            return null;
        }
    }
    
    private Piece getPiece(PieceColor color){
        switch (color) {
            case RED:     return red;
            case BLACK:   return black;
            default:            throw new InvalidParameterException("Color not in use.");
        }
    }
    
    public int getPiecePosition(PieceColor color) {
        return getPiece(color).getPosition(orientation);
    }
    
    public Orientation getOrientation() {
        return orientation;
    }
    
    public int getCoordinate(Orientation orientation) {
        return coordinates[orientation.ordinal()];
    }
    
    public int getLength() {
        return length;
    }
    
    public Line getCopy() {
        Line copy = new Line(orientation, coordinates, length);
        copy.move(PieceColor.RED, red.getPosition(orientation));
        copy.move(PieceColor.BLACK, black.getPosition(orientation));
        return copy;
    }
}

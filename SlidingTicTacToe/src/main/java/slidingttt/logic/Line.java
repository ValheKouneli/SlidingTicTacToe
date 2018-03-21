/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import java.security.InvalidParameterException;

/**
 *
 * @author Valhe Kouneli
 */
public class Line {
    
    private final int length;
    private final int index;
    private Piece red;
    private Piece black;
    private final int orientation;
    
    public Line(int orientation, int index, int length){
        this.orientation = orientation;
        this.length = length;
        this.index = index;
        setBeginningPosition();
    }
    
    private void setBeginningPosition() {
        int red_position;
        int black_position;
        if (index % 2 == 0) {
            red_position = 0;
            black_position = length-1;
        } else {
            red_position = length-1;
            black_position = 0;
        }
        red = new Piece(Const.RED, orientation, red_position);
        black = new Piece(Const.BLACK, orientation, black_position);
        red.setOtherPiece(black);
        black.setOtherPiece(red);

    }
    
    public void setPiecePositions(int red_position, int black_position) {
        red.setPosition(red_position);
        black.setPosition(black_position);
    }
    
    public boolean move(int color, int destination) {
        switch (color) {
            case Const.RED:     return red.setPosition(destination);
            case Const.BLACK:   return black.setPosition(destination);
            default:        throw new InvalidParameterException("Color not in use.");
        }
    }
    
    public int getColorInPosition(int position) {
        if (red.getPosition() == position) {
            return Const.RED;
        } else if (black.getPosition() == position) {
            return Const.BLACK;
        } else {
            return Const.NO_COLOR;
        }
    }
    
    public Piece getPiece(int color){
        switch (color) {
            case Const.RED:     return red;
            case Const.BLACK:   return black;
            default:            throw new InvalidParameterException("Color not in use.");
        }
    }
    
    public int getOrientation() {
        return orientation;
    }
    
    public int getNumber() {
        return index;
    }
    
    public int getLength() {
        return length;
    }
    
    public Line getCopy() {
        Line copy = new Line(orientation, index, length);
        copy.setPiecePositions(red.getPosition(), black.getPosition());
        return copy;
    }
}

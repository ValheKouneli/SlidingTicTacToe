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
    private final int number;
    private Piece red;
    private Piece black;
    private final int orientation;
    
    public Line(int orientation, int number, int length){
        this.orientation = orientation;
        this.length = length;
        this.number = number;
        setBeginningPosition();
    }
    
    private void setBeginningPosition() {
        red = new Piece(Const.RED, orientation, 0);
        black = new Piece(Const.BLACK, orientation, 0);
        red.setOtherPiece(black);
        black.setOtherPiece(red);
        if (number % 2 == 1) {
            red.setPosition(0);
            black.setPosition(length-1);
        } else {
            black.setPosition(0);
            red.setPosition(length-1);
        }
    }
    
    public void setPiecePositions(int red_position, int black_position) {
        red.setPosition(red_position);
        black.setPosition(black_position);
    }
    
    public boolean move(int color, int destination) {
        switch (color) {
            case Const.RED:     return red.move(destination);
            case Const.BLACK:   return black.move(destination);
            default:        throw new InvalidParameterException("Color not in use.");
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
        return number;
    }
    
    public int getLength() {
        return length;
    }
    
    public Line getCopy() {
        Line copy = new Line(orientation, number, length);
        copy.setPiecePositions(red.getPosition(), black.getPosition());
        return copy;
    }
}

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
    private final String orientation;
    
    public Line(String orientation, int number, int length){
        this.orientation = orientation;
        this.length = length;
        this.number = number;
        red = new Piece("red", orientation);
        black = new Piece("black", orientation);
        setBeginningPosition();
    }
    
    private void setBeginningPosition() {
        if (number % 2 == 0) {
            red.setPosition(0);
            black.setPosition(length);
        } else {
            black.setPosition(0);
            red.setPosition(length);
        }
    }
    
    public  void setPieces(Piece red, Piece black) {
        this.red = red;
        this.black = black;
        red.setOtherPiece(black);
        black.setOtherPiece(red);
    }
    
    public boolean move(String color, int destination) {
        switch (color) {
            case "red":     return red.move(destination);
            case "black":   return black.move(destination);
            default:        throw new InvalidParameterException("Color not in use.");
        }
    }
    
    public Piece getPiece(String color){
        switch (color) {
            case "red":     return red;
            case "black":   return black;
            default:        throw new InvalidParameterException("Color not in use.");
        }
    }
    
    public String getOrientation() {
        return orientation;
    }
    
    public Line getCopy() {
        Line copy = new Line(orientation, number, length);
        copy.setPieces(red.getCopy(), black.getCopy());
        return copy;
    }
}

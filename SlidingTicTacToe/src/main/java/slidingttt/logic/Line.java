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
    }
    
    public void setBeginningPosition() {
        red = new Piece("red", orientation);
        black = new Piece("black", orientation);
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
    
    public int getNumber() {
        return number;
    }
    
    public int getLength() {
        return length;
    }
    
    public Line getCopy() {
        Line copy = new Line(orientation, number, length);
        copy.setPieces(red.getCopy(), black.getCopy());
        return copy;
    }
}

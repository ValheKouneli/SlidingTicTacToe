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
    private final Orientation orientation;
    
    public Line(Orientation orientation, int index, int length){
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
        red = new Piece(Color.RED, orientation, red_position);
        black = new Piece(Color.BLACK, orientation, black_position);
        red.setOtherPiece(black);
        black.setOtherPiece(red);

    }
    
    public void setPiecePositions(int red_position, int black_position) {
        red.setPosition(red_position);
        black.setPosition(black_position);
    }
    
    public void move(Color color, int destination) {
        switch (color) {
            case RED:     red.setPosition(destination);
                                break;
            case BLACK:   black.setPosition(destination);
                                break;
            default:        throw new InvalidParameterException("Color not in use.");
        }
    }
    
    public Color getColorInPosition(int position) {
        if (red.getPosition() == position) {
            return Color.RED;
        } else if (black.getPosition() == position) {
            return Color.BLACK;
        } else {
            return null;
        }
    }
    
    public Piece getPiece(Color color){
        switch (color) {
            case RED:     return red;
            case BLACK:   return black;
            default:            throw new InvalidParameterException("Color not in use.");
        }
    }
    
    public Orientation getOrientation() {
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

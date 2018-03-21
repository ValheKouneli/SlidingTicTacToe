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
public class Situation {
    
    private static final int RED = 1;
    private static final int BLACK = 2;
    private int reds_on_field;
    private int blacks_on_field;
    private boolean[][] red_positions;
    private boolean[][] black_positions;
    private final int size;
    private final Board board;
    private int turn;
    
    public Situation(int size) {
        this.size = size;
        board = new Board(size);
        reds_on_field = 0;
        blacks_on_field = 0;
        
        red_positions = new boolean[size][size];
        black_positions = new boolean[size][size];
        
        turn = RED;
    }
    
    public boolean move(String orientation, int line_number, int destination) {
        int row;
        switch (orientation) {
            case "horizontal":  row = 0;
                                break;
            case "vertical":    row = 1;
                                break;
            default:            throw new InvalidParameterException("Orientation not in use.");
        }
        
        return board.getLines()[row][line_number-1].move(turn, destination);
    }
    
    public boolean checkForThreeInARow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int getBlacksOnField() {
        return blacks_on_field;
    }
    
    public int getRedsOnField() {
        return reds_on_field;
    }
    
    public boolean getRedPositions(int x, int y) {
        return red_positions[x][y];
    }
    
    public boolean getBlackPositions(int x, int y) {
        return black_positions[x][y];
    }
    
    public int getSize() {
        return size;
    }
    
    public Situation getCopy(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}

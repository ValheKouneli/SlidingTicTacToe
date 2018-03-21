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
    //TODO: simplify: only one int(!) array, number tells if occupied and
    //by what color
    private boolean[][] red_positions;
    private boolean[][] black_positions;
    private final Board board;
    private int turn;
    
    public Situation(int size) {
        board = new Board(size);
        reds_on_field = 0;
        blacks_on_field = 0;
        
        red_positions = new boolean[size][size];
        black_positions = new boolean[size][size];
        
        turn = RED;
    }
    
    //TODO: change turn
    public boolean move(Move move) {
        // does not check that the move color and the turn color match
        return moveHelp(move, Const.DO);
    }
    
    //TODO: change turn
    public boolean undoMove(Move move) {
        // does not check that the move color and the turn color match
        return moveHelp(move, Const.UNDO);
    }
    
    private boolean moveHelp(Move move, int direction) {
        int row = move.getOrientation();
        int col = move.getLineNumber();
        int dest;
        Line line = board.getLines()[row][col]; //line affected in the move
        switch (direction) {
            case Const.DO:      dest = move.getTo();
                                break;
            case Const.UNDO:    dest = move.getFrom();
                                break;
            default:            throw new InvalidParameterException("Color not in use.");
            
        }
        
        return line.move(turn, dest);
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
        return board.getSize();
    }
    
    public Situation getCopy(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}

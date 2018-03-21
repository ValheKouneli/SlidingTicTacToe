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
        if (turn != move.getColor()) {
            throw new InvalidParameterException("Move does not match turn.");
        }
        // does not check that the move color and the turn color match
        return moveHelp(move, Const.DO);
    }
    
    //TODO: change turn
    public boolean undoMove(Move move) {
        if (turn == move.getColor()) {
            throw new InvalidParameterException("Undo-move matches turn"
                    + "but it should't.");
        }
        // does not check that the move color and the turn color match
        return moveHelp(move, Const.UNDO);
    }
    
    private boolean moveHelp(Move move, int direction) {
        int row = move.getOrientation();
        int col = move.getLineNumber();
        int dest;
        int orig;
        int size = board.getSize();
        int pieces_on_field;
        //TODO: simplify
        switch (turn) {
            case RED:   pieces_on_field = reds_on_field;
                        break;
            case BLACK: pieces_on_field = blacks_on_field;
                        break;
            default:    throw new InvalidParameterException("Color not in use.");
        }
        
        Line line = board.getLines()[row][col]; //line affected in the move
        
        switch (direction) {
            case Const.DO:      dest = move.getTo();
                                orig = move.getFrom();
                                break;
            case Const.UNDO:    dest = move.getFrom();
                                orig = move.getTo();
                                break;
            default:            throw new InvalidParameterException("Color not in use.");
            
        }
        
        if (pieces_on_field == 3 &&
                (orig == 0 || orig == size+2) && (0 < dest && dest < size+2)) {
            return false;
        } else if (red_positions[row][col] || black_positions[row][col]) {
            return false;
        } else if (pieceIsTryingToPassAnother()) {
            return false;
        } else {
            line.move(turn, dest);
            return true;
        }
        
        
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

    //Problem: how can one get the position of the other piece
    //on the same line now?
    private boolean pieceIsTryingToPassAnother() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

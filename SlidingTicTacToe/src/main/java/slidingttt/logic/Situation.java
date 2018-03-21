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
    private int[] piecesOnField; //red pieces on field and black pieces on field
    //TODO: simplify: only one int(!) array, number tells if occupied and
    //by what color
    private boolean[][][] piecePositions;
    private final Board board;
    private int turn;
    
    public Situation(int size) {
        board = new Board(size);
        piecesOnField = new int[Const.NUMBER_OF_COLORS];
        piecePositions = new boolean[Const.NUMBER_OF_COLORS][size][size];
        
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
        int orientation = move.getOrientation();
        int index = move.getLineNumber();
        int dest;
        int orig;
        int row_from;
        int col_from;
        int row_to;
        int col_to;
        int size = board.getSize();
        int color = move.getColor();
        Line line = board.getLines()[orientation][index]; //line affected in the move
        Piece movingPiece = line.getPiece(color);
        Piece oppositePiece = movingPiece.getOtherPiece();
        int posNow = movingPiece.getPosition();
        boolean turnMatchesMovingPiece;
        int newPiecesToField = 0;
        
        
        switch (direction) {
            case Const.DO:      dest = move.getTo();
                                orig = move.getFrom();
                                turnMatchesMovingPiece = true;
                                break;
            case Const.UNDO:    dest = move.getFrom();
                                orig = move.getTo();
                                turnMatchesMovingPiece = false;
                                break;
            default:            throw new InvalidParameterException("Color not in use.");
            
        }
        
        switch (orientation) {
            case Const.HORIZONTAL:  row_to = index;
                                    col_to = dest;
                                    row_from = index;
                                    col_from = posNow;
                                    break;
            case Const.VERTICAL:    row_to = dest;
                                    col_to = index;
                                    row_from = posNow;
                                    col_from = index;
                                    break;
            default:                throw new InvalidParameterException("Orientation not in use.");
        }
        
        if (orig != posNow) {
            //throw new InvalidParameterException("Move.from does not match "
             //       + "current position of the Piece being moved.");
        }
        if ((turn == movingPiece.getColor()) == turnMatchesMovingPiece) {
            throw new InvalidParameterException("Move.color does not match "
                    + "turn.");
        }
        
        if ((orig == 0 || orig == size+2) && (0 < dest && dest < size+2)) {
            if (piecesOnField[color] == 3) {
                return false;
            } else {
                newPiecesToField = 1;
            }
        }
        
        if (piecePositions[0][row_to][col_to] || piecePositions[1][row_to][col_to]) {
            //check if destination space is empty
            return false;
        }
        
        if (pieceIsTryingToPassAnother(orig, dest, oppositePiece.getPosition())) {
            return false;
        } 
        
        line.move(color, dest);
        piecePositions[color][row_from][col_from] = false;
        piecePositions[color][row_to][col_to] = true;
        piecesOnField[color] += newPiecesToField;
        return true;
        
        
        
    }
    
    public boolean checkForThreeInARow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int getPiecesOnField(int color) {
        return piecesOnField[color];
    }
    
    
    public boolean getPiecePositions(int color, int x, int y) {
        return piecePositions[color][x][y];
    }
    
    
    public int getSize() {
        return board.getSize();
    }
    
    public Situation getCopy(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int getTurn() {
        return turn;
    }

    //Problem: how can one get the position of the other piece
    //on the same line now?
    private boolean pieceIsTryingToPassAnother(int orig, int dest,
            int otherPiecesPosition) {
        return (orig < otherPiecesPosition && otherPiecesPosition < dest) ||
                (dest < otherPiecesPosition && otherPiecesPosition < dest);
    }
    
    @Override
    public String toString(){
        return board.toString();
    }
    
    
}

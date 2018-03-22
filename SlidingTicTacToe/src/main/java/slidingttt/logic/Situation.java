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
    
    private int[] piecesOnField; //red pieces on field and black pieces on field
    //TODO: simplify: only one int(!) array, number tells if occupied and
    //by what color
    private boolean[][][] piecePositions;
    private final Board board;
    private int turn;
    
    public Situation(int size) {
        board = new Board(size);
        piecesOnField = new int[Const.NUMBER_OF_COLORS];
        piecePositions = new boolean[Const.NUMBER_OF_COLORS][size+2][size+2];
        
        turn = Const.RED;
    }
    
    public boolean move(Move move) {
        
        Piece pieceToBeMoved = board.getLine(move.getOrientation(), 
                                             move.getLineIndex())
                .getPiece(move.getColor());
        
        int piecesPositionNow = pieceToBeMoved.getPosition();
        int piecesNewPosition = move.getTo();
        
        int otherPiecesPosition = pieceToBeMoved.getOtherPiece().getPosition();
        
        int piecesXcoordinateFrom;
        int piecesYcoordinateFrom;
        int piecesXcoordinateTo;
        int piecesYcoordinateTo;
        
        switch (move.getOrientation()) {
            case Const.HORIZONTAL :     piecesXcoordinateFrom = move.getLineIndex()+1;
                                        piecesYcoordinateFrom = piecesPositionNow;
                                        piecesXcoordinateTo = move.getLineIndex()+1;
                                        piecesYcoordinateTo = piecesNewPosition;
                                        break;
            case Const.VERTICAL :       piecesXcoordinateFrom = piecesPositionNow;
                                        piecesYcoordinateFrom = move.getLineIndex()+1;
                                        piecesXcoordinateTo = piecesNewPosition;
                                        piecesYcoordinateTo = move.getLineIndex()+1;
                                        break;
            default :                   throw new InvalidParameterException("Orientation not in use.");
        }
        
        int newPiecesOnField = 0; // intrinsically, a move does not bring
                                  // new pieces to field
        if (piecesPositionNow == 0 || piecesPositionNow == board.getSize()+1) {
            //no need to check if piece ends up in another base; not possible
            newPiecesOnField = 1;

        }
        
//        /* 
//        * check to make sure the move makes sense
//        */
//        if (piecesPositionNow != move.getFrom()) {
//            throw new InvalidParameterException("Move.form does not match "
//                    + "moving piece's current position.");
//        }
        
        /*
        * move is illegal if moved piece passes other piece on the same line
        */
        if (pieceIsTryingToPassAnother(piecesPositionNow, piecesNewPosition, 
                otherPiecesPosition)) {
            return false;
        }
 
        /*
        * move is illegal if if brings more than MAX_NUMBER_ON_FIELD pieces
        */
        if (newPiecesOnField > 0 && piecesOnField[move.getColor()] == Const.MAX_NUMBER_ON_FIELD) {
            return false;
        }
        
        /*
        * move is illegal if the destination spot is occupied
        */
        if (piecePositions[Const.RED][piecesXcoordinateTo]
                                     [piecesYcoordinateTo] ||
                piecePositions[Const.BLACK][piecesXcoordinateTo]
                                           [piecesYcoordinateTo]) {
            return false;
        }
        
        /*
        * Reaching this means the move does not break any rules.
        * We can make the move and update class variables accordingly.
        */
        pieceToBeMoved.setPosition(piecesNewPosition);
        turn = whoIsNext(turn);
        piecesOnField[move.getColor()] += newPiecesOnField;
        piecePositions[move.getColor()]
                [piecesXcoordinateFrom][piecesYcoordinateFrom] = false;
        piecePositions[move.getColor()]
                [piecesXcoordinateTo][piecesYcoordinateTo] = true;
        
        return true;
        
    }
    
    public boolean checkForThreeInARow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int whoIsNext(int turnNow) {
        switch (turnNow) {
            case Const.RED :    return Const.BLACK;
            case Const.BLACK :  return Const.RED;
            default:            throw new InvalidParameterException("Color not in use.");
        }
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

    public boolean pieceIsTryingToPassAnother(int orig, int dest,
            int otherPiecesPosition) {
        return (orig < otherPiecesPosition && otherPiecesPosition < dest) ||
                (dest < otherPiecesPosition && otherPiecesPosition < dest);
    }
    
    @Override
    public String toString(){
        return board.toString();
    }
    
    
}

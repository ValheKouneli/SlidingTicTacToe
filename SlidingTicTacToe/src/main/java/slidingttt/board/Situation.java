/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.board;

import java.security.InvalidParameterException;
import slidingttt.logic.PieceColor;
import slidingttt.logic.Const;
import slidingttt.logic.Orientation;


/** Class has the functions to take care that the rules of the game
 *  Sliding Tic Tac Toe are being followed.
 *
 * @author Valhe Kouneli
 */
public class Situation extends Board {
    
    private int[] piecesOnField; //red pieces on field and black pieces on field
    //TODO: simplify: only one int(!) array, number tells if occupied and
    //by what color
    private boolean[][][] piecePositions;

    private PieceColor turn;
    
    public Situation(int size) {
        super(size);
        piecesOnField = new int[Const.NUMBER_OF_COLORS];
        piecePositions = new boolean[Const.NUMBER_OF_COLORS][size+2][size+2];
        
        turn = PieceColor.RED;
    }
    
    public boolean move(Move move) {
        

        int piecesPositionNow = move.getFrom();
        int piecesNewPosition = move.getTo();

        int piecesXcoordinateFrom;
        int piecesYcoordinateFrom;
        int piecesXcoordinateTo;
        int piecesYcoordinateTo;
        
        switch (move.getOrientation()) {
            case HORIZONTAL :     piecesXcoordinateFrom = move.getLineIndex()+1;
                                        piecesYcoordinateFrom = piecesPositionNow;
                                        piecesXcoordinateTo = move.getLineIndex()+1;
                                        piecesYcoordinateTo = piecesNewPosition;
                                        break;
            case VERTICAL :       piecesXcoordinateFrom = piecesPositionNow;
                                        piecesYcoordinateFrom = move.getLineIndex()+1;
                                        piecesXcoordinateTo = piecesNewPosition;
                                        piecesYcoordinateTo = move.getLineIndex()+1;
                                        break;
            default :                   throw new InvalidParameterException("Orientation not in use.");
        }
        
        int newPiecesOnField = 0; // intrinsically, a move does not bring
                                  // new pieces to field
        if (piecesPositionNow == 0 || piecesPositionNow == super.getSize()+1) {
            //no need to check if piece ends up in another base; not possible
            newPiecesOnField = 1;

        }

 
        /*
        * move is illegal if if brings more than MAX_NUMBER_ON_FIELD pieces
        */
        if (newPiecesOnField > 0 &&
                piecesOnField[move.getColor().ordinal()] == 
                Const.MAX_NUMBER_ON_FIELD) {
            return false;
        }
        
        /*
        * move is illegal if the destination spot is occupied
        */
        if (piecePositions[PieceColor.RED.ordinal()][piecesXcoordinateTo]
                                     [piecesYcoordinateTo] ||
                piecePositions[PieceColor.BLACK.ordinal()][piecesXcoordinateTo]
                                           [piecesYcoordinateTo]) {
            return false;
        }
        
        /*
        * Reaching this means the move does not break any rules.
        * We can try to make the move and update class variables accordingly.
        */
        if (super.movePiece(move.getColor(), move.getOrientation(),
                move.getLineIndex(), move.getTo())) {
            
            piecesOnField[move.getColor().ordinal()] += newPiecesOnField;
            piecePositions[move.getColor().ordinal()]
                [piecesXcoordinateFrom][piecesYcoordinateFrom] = false;
            piecePositions[move.getColor().ordinal()]
                [piecesXcoordinateTo][piecesYcoordinateTo] = true;
        
            return true;
        } else {
            return false;
        }
        
        
        
    }
    
    public void nextTurn(){
        turn = whoIsNext(turn);
    }
    
    public boolean thereIsThreeInARow(PieceColor color) {
        //check downward diagonal 3-in-a-rows
        for (int i=1; i<=super.getSize()-2; i++) {
            for (int j=1; j<=super.getSize()-2; j++) {
                if (piecePositions[color.ordinal()][i][j] &&
                        piecePositions[color.ordinal()][i+1][j+1] &&
                        piecePositions[color.ordinal()][i+2][j+2]) {
                        //downward diagonal 3-in-a-row found
                        return true;
                }
                
            }
        }
        //check for horizontal 3-in-a-row
        for (int i=1; i<=super.getSize(); i++) {
            for (int j=1; j<=super.getSize()-2; j++) {
                if (piecePositions[color.ordinal()][i][j] &&
                        piecePositions[color.ordinal()][i][j+1] &&
                        piecePositions[color.ordinal()][i][j+2]) {
                    //horiontal 3-in-a-row found
                    return true;
                }
            }
        }
        //check for vertical diagonal 3-in-a-row
        for (int i=1; i<=super.getSize()-2; i++) {
            for (int j=1; j<=super.getSize(); j++) {
                 if (piecePositions[color.ordinal()][i][j] &&
                        piecePositions[color.ordinal()][i+1][j] &&
                        piecePositions[color.ordinal()][i+2][j]) {
                    //vertical 3-in-a-row found
                    return true;
                }
            }
        }
        //check for upward diagonal 3-in-a-rows
        for (int i=1; i<=super.getSize()-2; i++) {
            for (int j=super.getSize(); j>2; j--) {
                if (piecePositions[color.ordinal()][i][j] &&
                        piecePositions[color.ordinal()][i-1][j-1] &&
                        piecePositions[color.ordinal()][i-2][j-1]) {
                    //upward diagonal 3-in-a-row found
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    public PieceColor whoIsNext(PieceColor turnNow) {
        //if there are more than two colors, should consult a static final list
        //that lists the turn order
        switch (turnNow) {
            case RED :    return PieceColor.BLACK;
            case BLACK :  return PieceColor.RED;
            default:            throw new InvalidParameterException
                                                ("Color not in use.");
        }
    }
    
    public PieceColor whoWasBefore(PieceColor turnNow) {
        //if there are more than two colors, should consult a static final list
        //that lists the turn order
        switch (turnNow) {
            case RED :    return PieceColor.BLACK;
            case BLACK :  return PieceColor.RED;
            default:            throw new InvalidParameterException
                                                ("Color not in use.");
        }
    }
    
    public int getPiecesOnField(PieceColor color) {
        return piecesOnField[color.ordinal()];
    }
    
    
    public boolean getPiecePositions(PieceColor color, int x, int y) {
        return piecePositions[color.ordinal()][x][y];
    }
    
    @Override
    public Situation getCopy(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public PieceColor getTurn() {
        return turn;
    }

    public boolean pieceIsTryingToPassAnother(int orig, int dest,
            int otherPiecesPosition) {
        if (orig<dest) {
            return (orig < otherPiecesPosition && otherPiecesPosition < dest);
        } else {
            return (dest < otherPiecesPosition && otherPiecesPosition < orig);
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + "It's " + turn.name() + "'s turn.\n";
    }
    
    
}

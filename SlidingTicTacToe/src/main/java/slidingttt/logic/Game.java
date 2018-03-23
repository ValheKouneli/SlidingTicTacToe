/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.security.InvalidParameterException;
import slidingttt.board.Board;


/**
 * Takes care of moving pieces on the board according to the rules of the game.
 * Keeps an account of whose turn it is. Has a method for finding out if
 * there is a 3-in-a-row on the Field of the board.
 * 
 * @author Valhe Kouneli
 */
public class Game {
    
    protected Board board;
    private PieceColor turn;
    private int[] piecesOnField;
    private boolean[][][] piecePositions;
    
    public Game(int size) {
        if (size % 2 == 0) {
            throw new InvalidParameterException("Size can not be even.");
        }
        board = new Board(size);
        turn = PieceColor.RED;
        piecesOnField = new int[2];
        piecePositions = new boolean[2][size+2][size+2];
    }
  
    /**
     * Make a move if it is valid and return if it was valid.
     * Update piecesOnField.
     * @param move  move given in coordinates from_x, from_y, to_x, to_y
     * @return      return if move was made or not depending if it was valid
     */
    public boolean move(int[] move) {
        
        //check that chosen piece is in turn
        //check if piece stays on its line
        //check that piece does not pass another
        //check that piece does not move to occupied space
        
        if (!pieceIsOfTheColorInTurn(move) ||
                !pieceDoesNotMoveToOccupiedSpace(move) ||
                !pieceStaysOnItsLine(move) ||
                !pieceDoesNotPassAnother(move)) {
            return false;
        }
        //check that move does not bring more than three pieces of the same
        //color on Field. Update piecesOnField
        PieceColor color = board.getPieceColor(move[0], move[1]);
        if (moveBringsNewPieceOnField(move)) {
            if (piecesOnField[color.ordinal()] == 3) {
                return false;
            } else {
                piecesOnField[color.ordinal()] += 1;
            }
        }
        
        return true;
    }
    
    private boolean pieceIsOfTheColorInTurn(int[] move) {
        return board.getPieceColor(board.getBoardXY(move[0], move[1])) ==
                turn;
    }
    
    private boolean pieceStaysOnItsLine(int[] move) {
        char piece = board.getBoardXY(move[0], move[1]);
        if (board.getOrientation(piece) == Orientation.HORIZONTAL) {
            return move[0] == move[2];
        } else {
            return move[1] == move[3];
        }
    }
    
    private boolean pieceDoesNotPassAnother(int[] move) {
        /*
        * Figure out the char representation of the opposing color piece
        * on the same line...
        */
        PieceColor color = board.getPieceColor(move[0], move[1]);
        Orientation orientation = board.getOrientation(move[0], move[1]);
        
        PieceColor otherColor;
        if (color == PieceColor.RED) {
            otherColor = PieceColor.BLACK;
        } else {
            otherColor = PieceColor.RED;
        }
 
        char oppositePiece = board.getCharacter(otherColor, orientation);
        /*
        * ...done!
        */
             
        /*
        * Look for oppositePiece in coordinates between move-from and move-to
        */
        int from;
        int to;
        int constantCoordinate;
        boolean oppositePieceFoundInBetween = false;
        
        if (orientation == Orientation.HORIZONTAL) {
            constantCoordinate = move[0];
            from = min(move[1], move[3]);
            to = max(move[1], move[3]);
            for (int i=from+1; i<to; i++) {
                if (board.getBoardXY(constantCoordinate, i) == oppositePiece) {
                    oppositePieceFoundInBetween = true;
                    break;
                }
            }
            
        } else {
            constantCoordinate = move[1];
            from = min(move[0], move[2]);
            to = max(move[0], move[2]);
            for (int i=from+1; i<to; i++) {
                if (board.getBoardXY(i, constantCoordinate) == oppositePiece) {
                    oppositePieceFoundInBetween = true;
                    break;
                }
            }
        }
        
        return oppositePieceFoundInBetween;
    }
    
    private boolean pieceDoesNotMoveToOccupiedSpace(int[] move) {
        return board.getBoardXY(move[2], move[3]) == 0;
    }
    
    private boolean moveBringsNewPieceOnField(int[] move) {
        Orientation orientation = board.getOrientation(move[0], move[1]);
        int from = move[orientation.ordinal()];
        return from == 0 || from == board.getSize()+1;
    }
    
    public boolean thereIsThreeInARow() {
        return false;
    }
    
    private PieceColor giveTheOtherColor(PieceColor color) {
        if (color == PieceColor.RED) {
            return PieceColor.BLACK;
        } else {
            return PieceColor.RED;
        }
    }
    
    public PieceColor nextTurn() {
        turn = giveTheOtherColor(turn);
        return turn;
    }
    
    public PieceColor whoWasBefore() {
        return giveTheOtherColor(turn);
    }
    
    public int getSize() {
        return board.getSize();
    }
    
    @Override
    public String toString() {
        String temp = board.toString();
        temp += "Turn: " + turn.toString() + '\n';
        return temp;
    }

        
}

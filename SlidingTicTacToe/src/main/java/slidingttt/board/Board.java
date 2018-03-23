/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.board;

import slidingttt.board.Line;
import java.util.Arrays;
import slidingttt.logic.PieceColor;
import slidingttt.logic.Const;
import slidingttt.logic.Orientation;


public class Board {
    
    /**
     * Characters for printing the Board's String representation.
     */
    static final char CORNER = ' ';
    static final char EMPTY = '+';
    static final char RED_VERTICAL = 'r';
    static final char RED_HORIZONTAL = 'R';
    static final char BLACK_VERTICAL = 'b';
    static final char BLACK_HORIZONTAL = 'B';
    static final char BASE_VERTICAL = '|';
    static final char BASE_HORIZONTAL = '–';
    

    
    private final int size;
    protected Line[][] lines;
    private char[][] emptyBoardRepresentation;

    /**
     * Creates a STTT board with size amount of horizontal and vertical lines.
     * If size is an even number, size will be set to size plus one.
     * @param size  The number of horizontal/vertical lines on the STTT board.
     */
    Board(int size) {
        if (size % 2 == 0) {
            System.out.println("Size has to be an odd number. Size set to "
                    + (size+1) + " instead.");
            size++;
        }
        this.size = size;
        
        initializeLines();
        
        setEmptyBoardRepresentation();
    }
    
    private void setEmptyBoardRepresentation() {
        emptyBoardRepresentation = new char[size+2][size+2];
        String topAndBottom = "" + CORNER;
        String middle = "" + BASE_HORIZONTAL;
        for (int i=0; i<size; i++){
            topAndBottom += BASE_VERTICAL;
            middle += EMPTY;
        }
        topAndBottom += CORNER;
        middle += BASE_HORIZONTAL;
        emptyBoardRepresentation[0] = topAndBottom.toCharArray();
        emptyBoardRepresentation[size+1] = topAndBottom.toCharArray();
        for (int i=1; i<size+1; i++){
            emptyBoardRepresentation[i] = middle.toCharArray();
        }
    }

    private void initializeLines() {
        this.lines = new Line[Const.NUMBER_OF_ORIENTATIONS][size];
        
        //TODO: simplify
        for (int i=0; i<size; i++) {
            this.lines[0][i] = new Line(Orientation.HORIZONTAL, i, size+2);
        }
        for (int i=0; i<size; i++) {
            this.lines[1][i] = new Line(Orientation.VERTICAL, i, size+2);
        }
    }

    public int getSize() {
        return this.size;
    }
    
    public int getPiecePosition(PieceColor color, Orientation orientation,
            int lineIndex) {
        return lines[orientation.ordinal()][lineIndex]
                .getPiece(color).getPosition();
    }
    
    //TODO: make it take Move as argument
    protected void movePiece(PieceColor color, Orientation orientation, int lineIndex,
            int newPosition) {
        lines[orientation.ordinal()][lineIndex]
                .getPiece(color).setPosition(newPosition);
    }
    
    /**
     * TODO.
     * Makes a new Board with beginning set-up and then moves the Pieces
     * to the same positions as the current board.
     * @return  Copy of the Board.
     */
    public Board getCopy() {
        throw new UnsupportedOperationException("Not supported yet.");
        //Board board_copy = new Board(size);
        
        
    }
            
    @Override
    public String toString() {
        setEmptyBoardRepresentation();
        int x;
        int y;
        //TODO: simplify
        /*
        * Horizontal lines
        */
        for (Line line : lines[0]) { 
            x = line.getNumber()+1;
            y = line.getPiece(PieceColor.RED).getPosition();
            emptyBoardRepresentation[x][y] = RED_HORIZONTAL;
            y = line.getPiece(PieceColor.BLACK).getPosition();
            emptyBoardRepresentation[x][y] = BLACK_HORIZONTAL;
        }
        /*
        * Vertical lines
        */
        for (Line line: lines[1]) {
            y = line.getNumber()+1;
            x = line.getPiece(PieceColor.RED).getPosition();
            emptyBoardRepresentation[x][y] = RED_VERTICAL;
            x = line.getPiece(PieceColor.BLACK).getPosition();
            emptyBoardRepresentation[x][y] = BLACK_VERTICAL;
        }
        
        /*
        * Create a string based on the char array emptyBoardRepresentation.
        */
        String temp = "";
        for (int i=0; i<size+2; i++) {
            for (int j=0; j<size+2; j++) {
                temp += emptyBoardRepresentation[i][j];
            }
            temp += '\n';
        }
        return temp;
    }
    
}

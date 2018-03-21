/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import java.util.Arrays;


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
    
    static final int NUMBER_OF_DIRECTIONS = 2;
    
    private final int size;
    private Line[][] lines;
    private final char[][] emptyBoardRepresentation;

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

    /**
     * Creates the lines of the game and sets them to the beginning position.
     * Setting the line to the beginning position creates the pieces
     * and sets them to the beginning position.
     */
    public void setBeginningPosition() {
        this.lines = new Line[NUMBER_OF_DIRECTIONS][size];
        
        for (int i=0; i<size; i++) {
            this.lines[0][i] = new Line("horizontal", i+1, size+2);
            this.lines[0][i].setBeginningPosition();
        }
        for (int i=0; i<size; i++) {
            this.lines[1][i] = new Line("vertical", i+1, size+2);
            this.lines[1][i].setBeginningPosition();
        }
    }
    
    public void setLines(Line[][] lines) {
        //does not check if the lines are of proper lenght
        this.lines = lines;
    }

    public int getSize() {
        return this.size;
    }
    
    public Line[][] getLines() {
        return lines;
    }
    
    public Board getCopy() {
        Board board_copy = new Board(size);
        Line[][] line_copys = new Line[NUMBER_OF_DIRECTIONS][size];
        for (int i=0; i<size; i++) {
            line_copys[0][i] = lines[0][i].getCopy();
        }
        for (int i=0; i<size; i++) {
            line_copys[1][i] = lines[1][i].getCopy();
        }
        board_copy.setLines(line_copys);
        return board_copy;
    }
            
    @Override
    public String toString() {
        char[][] boardAsChars = Arrays.copyOf(emptyBoardRepresentation, size+2);
        int x;
        int y;
        /*
        * Horizontal lines
        */
        for (Line line : lines[0]) { 
            x = line.getNumber();
            y = line.getPiece("red").getPosition();
            boardAsChars[x][y] = RED_HORIZONTAL;
            y = line.getPiece("black").getPosition();
            boardAsChars[x][y] = BLACK_HORIZONTAL;
        }
        /*
        * Vertical lines
        */
        for (Line line: lines[1]) {
            y = line.getNumber();
            x = line.getPiece("red").getPosition();
            boardAsChars[x][y] = RED_VERTICAL;
            x = line.getPiece("black").getPosition();
            boardAsChars[x][y] = BLACK_VERTICAL;
        }
        
        String temp = "";
        for (int i=0; i<size+2; i++) {
            for (int j=0; j<size+2; j++) {
                temp += boardAsChars[i][j];
            }
            temp += '\n';
        }
        return temp;
    }
    
}

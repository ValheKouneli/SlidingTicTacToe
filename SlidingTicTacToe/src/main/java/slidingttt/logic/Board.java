/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;


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
    private final Line[] lines;

    /**
     * Creates a STTT board with size amount of horizontal and vertical lines.
     * If size is an even number, size will be set to size plus one.
     * @param size  The number of horizontal/vertical lines on the STTT board.
     */
    Board(int size) {
        if (size % 2 == 0) {
            System.out.println("Size has to be an odd number. Size set to "
                    + size + 1 + " instead.");
            size++;
        }
        this.size = size;
        lines = new Line[2*size];
        for (int i=0; i<size; i++) {
            lines[i] = new Line("horizontal", i, size+2);
        }
        for (int i=size; i<2*size; i++) {
            lines[i] = new Line("vertical", i, size+2);
        }
    }
    
    /**
     * Initializes the board to the beginning position.
     */
    public void setBeginningPosition() {
        for (int i=0; i<2*size; i++) {
            lines[i].setBeginningPosition();
        }
    }
    
    public void setBoard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getSize() {
        return this.size;
    }
    
    public Line[] getLines() {
        return lines;
    }
            
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

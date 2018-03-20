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
    
    static final int NUMBER_OF_DIRECTIONS = 2;
    
    private final int size;
    private Line[][] lines;
    private Situation situation;

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
    }

    public void setBeginningPosition() {
        lines = new Line[NUMBER_OF_DIRECTIONS][size];
        for (int i=0; i<size; i++) {
            lines[0][i] = new Line("horizontal", i, size+2);
        }
        for (int i=size; i<size; i++) {
            lines[1][i] = new Line("vertical", i, size+2);
        }
        
        situation = new Situation(size);
        situation.setBeginningSituation();
    }
    
    public void setLines(Line[][] lines) {
        this.lines = lines;
    }

    public int getSize() {
        return this.size;
    }
    
    public Line[][] getLines() {
        return lines;
    }
    
    public Situation getSituation() {
        return situation;
    }
    
    public void setSituation(Situation situation) {
        this.situation = situation;
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
        board_copy.setSituation(situation.getCopy());
        return board_copy;
    }
            
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

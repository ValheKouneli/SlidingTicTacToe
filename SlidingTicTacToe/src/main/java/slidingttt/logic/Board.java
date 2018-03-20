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
    
    
    /** Keeps count of red pieces on the Field.
     */
    private int reds_on_field;
    /** Keeps count of black pieces on the Field.
     */
    private int blacks_on_field;
    private final int size;
    private String winner;

    /**
     * Creates a STTT board with size amount of horizontal and vertical lines.
     * If size is an even number, size will be set to size plus one.
     * @param size  The number of horizontal lines on the STTT board.
     */
    Board(int size) {
        if (size % 2 == 0) {
            System.out.println("Size has to be an odd number. Size set to "
                    + size + 1 + " instead.");
            size++;
        }
        this.size = size;
        reds_on_field = 0;
        blacks_on_field = 0;
        winner = "UNDECIDED";
    }
    
    /**
     * Initializes the board to the beginning position.
     */
    public void initBoard() {
        
    }
    
    public void setBoard(boolean[] horizontalReds, boolean[] verticalReds,
            boolean[] horizontalBlacks, boolean[] verticalBlacks[]) {
        
    }
    
    public boolean moveRedHorizontal(int lineNumber, int destination) {
        return false;
    }
    
    public boolean moveBlackHorizontal(int lineNumber, int destination) {
        return false;
    }
    
    public boolean moveRedVertical(int lineNumber, int destination) {
        return false;
    }
    
    public boolean moveBlackVertical(int lineNumber, int destination) {
        return false;
    }

    public int getSize() {
        return this.size;
    }
    
    public String returnWinner() {
        return winner;
    }
            
    @Override
    public String toString() {
        return "";
    }
    
}

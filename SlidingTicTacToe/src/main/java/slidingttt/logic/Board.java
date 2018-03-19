/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * This class represents the game board for the game Sliding Tic Tac Toe (STTT).
 * The rules of the game are described on /README.md.
 * Class has a public method for moving the pieces on the board.
 * 
 */
public class Board {
    
    private char[][] board;
    /** Field size + 2
    */
    private final int size;
    static int RED = 1;
    static int BLACK = 2;
    static char CORNER = ' ';
    static char EMPTY = '+';
    static char RED_VERTICAL = 'r';
    static char RED_HORIZONTAL = 'R';
    static char BLACK_VERTICAL = 'b';
    static char BLACK_HORIZONTAL = 'B';
    static char BASE_VERTICAL = '|';
    static char BASE_HORIZONTAL = '–';
    /** Keeps count of red pieces on the Field.
     */
    private int reds_on_field;
    /** Keeps count of black pieces on the Field.
     */
    private int blacks_on_field;

    /**
     * Creates a STTT board with size amount of horizontal and vertical lines.
     * If size is an even number, size will be set to size plus one.
     * @param size  The number of horizontal lines on the STTT board.
     */
    Board(int size) {
        this.size = initBoard(size);
        reds_on_field = 0;
        blacks_on_field = 0;
    }
    
    /**
     * Initializes the board to the beginning position.
     * @param size  Number of the horizontal lines on the STTT board. If it is even, one will be added.
     * @return  The size of the array that is created to represent the STTT board.
     */
    private int initBoard(int size) {
        size += 2; /* size is given as the size of the Field, but
                      we'd rather save it as a size of the array */
        
        if (size % 2 == 0) {
            System.out.println("Size has to be an odd number. Size set to "
                    + size + 1 + " instead.");
            size++;
        }
        
        this.board = new char[size][size];
        

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                char temp;

                if ((i==0 || i==size-1) && (j==0 || j==size-1)) {
                    temp = CORNER;
                } else if ((i==0 && j%2==1) || (i==size-1 && j%2==0)) {
                    temp = RED_VERTICAL;
                } else if ((i==0 && j%2==0) || (i==size-1 && j%2==1)) {
                    temp = BLACK_VERTICAL;
                } else if ((j==0 && i%2==1) || (j==size-1 && i%2==0)) {
                    temp = RED_HORIZONTAL;
                } else if ((j==0 && i%2==0) || (j==size-1 && i%2==1)) {
                    temp = BLACK_HORIZONTAL;
                } else {
                    temp = EMPTY;
                }
                this.board[i][j] = temp;
            }
        }
        return size;
    }
    

    /**
     * Moves the playing pieces on the Board.
     * Updates reds_on_field and blacks_on_field when necessary.
     * @param color either 1 for red or 2 for black
     * @param from_x    old x coordinate of the piece being moved
     * @param from_y    old y coordinate of the piece being moved
     * @param to_x  new x coordinate of the piece being moved
     * @param to_y  new y coordinate of the piece being moved
     * @return true if the move is legal, false if not
     */
    public boolean move(int color,
                        int from_x, int from_y, int to_x, int to_y) {
        if (from_x<0 || from_x>size-1 || from_y<0 || from_y>size-1 ||
            to_x<0 || to_x>size-1 || to_y<0 || to_y>size-1) {
            System.out.println("Bad coordinates.");
            return false;
        }
        
        char from = board[from_x][from_y];
        char to = board[to_x][to_y];
        
        char vertical_own, vertical_opp, horizontal_own, horizontal_opp;
        int on_field;
        if (color == RED) {
            vertical_own = RED_VERTICAL;
            vertical_opp = BLACK_VERTICAL;
            horizontal_own = RED_HORIZONTAL;
            horizontal_opp = BLACK_HORIZONTAL;
            on_field = reds_on_field;
        } else {
            vertical_own = BLACK_VERTICAL;
            vertical_opp = RED_VERTICAL;
            horizontal_own = BLACK_HORIZONTAL;
            horizontal_opp = RED_HORIZONTAL;
            on_field = blacks_on_field;
        }
        
        /*
        * Check if the move is legal. If not, print out the reason.
        */
        if (from != vertical_own && from != horizontal_own) {
            System.out.println("Illegal move: You can not move your opponent's"
                    + " piece.");
            return false;
            
        } else if (to != BASE_VERTICAL &&
                   to != BASE_HORIZONTAL &&
                   to != EMPTY) {
            System.out.println("Illegal move: That space is occupied.");
            return false;
            
        } else if (from == vertical_own && from_y != to_y) {
            System.out.println("Illegal move: Vertical Pieces can move only up"
                    + " and down on their own line.");
            return false;
            
        } else if (from == horizontal_own && from_x != to_x) {
            System.out.println("Illegal move: Horizontal Pieces can move only "
                    + "right and left on their own line.");
            return false;
            
        } else if (isInBase(from_x, from_y) && on_field == 3) {
            System.out.println("Illegal move: You already have three pieces on "
                    + "the field.");
            return false;
            
        } else if (from == horizontal_own) {
            /*
            * Go trough all places between the from position and the to
            * position and check for blocking horizontal pieces.
            */
            for (int j=min(from_y, to_y)+1; j<max(from_y, to_y); j++) {
                if (board[from_x][j] == horizontal_opp) {
                    System.out.println("Illegal move: You can not move "
                            + "horizontally past another horizontal piece.");
                    return false;
                }
            }
            
        } else if (from == vertical_own) {
            /*
            * Go trough all places between the from position and the to
            * position and check for blocking vertical pieces.
            */
            for (int i = min(from_x, to_x)+1; i< max(from_x, to_x); i++) {
                if (board[i][from_y] == vertical_opp) {
                    System.out.println("Illegal move: You can not move "
                            + "vertically past another vertical piece.");
                    return false;
                }
            }
        }
        /*
        * Update the number of red/black pieces on board if necessary.
        */
        board[to_x][to_y] = from;
        board[from_x][from_y] = charWhenEmpty(from_x, from_y);
        if (isInBase(from_x, from_y)) {
            if (color == BLACK) {
                blacks_on_field++;
            } else {
                reds_on_field++;
            }
        } else if (isInBase(to_x, to_y)) {
            if (color == BLACK) {
                blacks_on_field--;
            } else {
                reds_on_field--;
            }
        }
        
        return true;
    }
    
    public int getSize(){
        return this.size;
    }
    

    private char charWhenEmpty(int x, int y){
        /* this method should never be called with
           coordinates to corner places
        */
        
        if (x==0 || x==size-1) {
            return BASE_VERTICAL;
        } else if (y==0 || y==size-1) {
            return BASE_HORIZONTAL;
        } else {
            return EMPTY;
        }
        
    }

    /**
     * @return String representation of the Board.
     */
    @Override
    public String toString() {
        String temp = "  ";
        for (int i=0; i<this.size; i++){
            temp += i + " ";
        }
        temp += '\n';
        
        for (int i=0; i<this.size; i++){
            temp += i + " ";
            for (int j=0; j<this.size; j++){
                temp += this.board[i][j] + " ";
            }
            temp += '\n';
        }
        
        return temp;
    }
    
    public char[][] getBoard(){
        return this.board;
    }
    
    /**
     * @param x x coordinate of a place on the board
     * @param y y coordinate of a place on the board
     * @return true if coordinate (x,y) is a base, false if not
     */
    private boolean isInBase(int x, int y) {
        return x==0 || x==size-1 || y==0 || y==size-1;
    }
    
}

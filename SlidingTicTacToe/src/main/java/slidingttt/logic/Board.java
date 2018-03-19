/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 *
 * @author Valhe Kouneli
 */
public class Board {
    
    private char[][] board;
    private final int size; // Field size + 2
    static char CORNER = ' ';
    static char EMPTY = '+';
    static char PLAYER1_VERTICAL = 'r';
    static char PLAYER1_HORIZONTAL = 'R';
    static char PLAYER2_VERTICAL = 'b';
    static char PLAYER2_HORIZONTAL = 'B';
    static char BASE_VERTICAL = '|';
    static char BASE_HORIZONTAL = '–';
    private int reds_on_field;
    private int blacks_on_field;

    Board(int size) {
        this.size = initBoard(size);
        reds_on_field = 0;
        blacks_on_field = 0;
    }
    
    private int initBoard(int size) {
        size += 2; /* size is given as the size of the Field, but
                      we'd rather save it as a size of the array */
        
        if (size % 2 == 0) {
            System.out.println("Size has to be an odd number. Size set to " + size + 1 + " instead.");
            size++;
        }
        
        this.board = new char[size][size];
        

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                char temp;

                if ((i==0 || i==size-1) && (j==0 || j==size-1)) {
                    temp = CORNER;
                } else if ((i==0 && j%2==1) || (i==size-1 && j%2==0)) {
                    temp = PLAYER1_VERTICAL;
                } else if ((i==0 && j%2==0) || (i==size-1 && j%2==1)) {
                    temp = PLAYER2_VERTICAL;
                } else if ((j==0 && i%2==1) || (j==size-1 && i%2==0)) {
                    temp = PLAYER1_HORIZONTAL;
                } else if ((j==0 && i%2==0) || (j==size-1 && i%2==1)) {
                    temp = PLAYER2_HORIZONTAL;
                } else {
                    temp = EMPTY;
                }
                this.board[i][j] = temp;
            }
        }
        return size;
    }
    

    
    public boolean move(char color, int from_x, int from_y, int to_x, int to_y) {
        char from = board[from_x][from_y];
        char to = board[to_x][to_y];
        
        if (Character.toLowerCase(from) != color) {
            System.out.println("Illegal move: You can not move your opponent's piece.");
            return false;
        } else if (to != BASE_VERTICAL && to != BASE_HORIZONTAL && to != EMPTY) {
            System.out.println("Illegal move: That space is occupied.");
            return false;
        } else if ((from == PLAYER1_VERTICAL || from == PLAYER2_VERTICAL) && from_x != to_x) {
            System.out.println("Illegal move: Vertical Pieces can move only up and down on their own line.");
            return false;
        } else if ((from == PLAYER1_HORIZONTAL || from == PLAYER2_HORIZONTAL) && from_y != to_y) {
            System.out.println("Illegal move: Horizontal Pieces can move only right and left on their own line.");
            return false;
        } else if (isInBase(from_x, from_y) && ((reds_on_field == 3 && color == 'r') || (blacks_on_field == 3 && color == 'b'))) {
            System.out.println("Illegal move: You already have three pieces on the field.");
            return false;
        } else if (from == PLAYER1_HORIZONTAL || from == PLAYER2_HORIZONTAL){
            for(int j=min(from_y, to_y)+1; j<max(from_y, to_y); j++){
                if(board[from_x][j] == PLAYER1_HORIZONTAL || board[from_x][j] == PLAYER2_HORIZONTAL) {
                    System.out.println("Illegal move: You can not move horizontally past another horizontal piece.");
                    return false;
                }
            }
        } else if (from == PLAYER1_VERTICAL || from == PLAYER2_VERTICAL){
            for(int i = min(from_x, to_x)+1; i< max(from_x, to_x); i++){
                if(board[i][from_y] == PLAYER1_VERTICAL || board[from_y][i] == PLAYER2_VERTICAL) {
                    System.out.println("Illegal move: You can not move vertically past another vertical piece.");
                    return false;
                }
            }
        }
        
        board[to_x][to_y] = from;
        board[from_x][from_y] = charWhenEmpty(from_x, from_y);
        if (isInBase(from_x, from_y)) {
            if (color == 'b') {
                blacks_on_field++;
            } else {
                reds_on_field++;
            }
        } else if (isInBase(to_x, to_y)) {
            if (color == 'b') {
                blacks_on_field++;
            } else {
                reds_on_field++;
            }
        }
        
        return true;
    }
    
    public int getSize(){
        return this.size;
    }
    
    private char charWhenEmpty(int x, int y){
        
        if (x==0 || x==size-1) {
            return BASE_VERTICAL;
        } else if (y==0 || y==size-1) {
            return BASE_HORIZONTAL;
        } else {
            return EMPTY;
        }
        
    }

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

    private boolean isInBase(int x, int y) {
        return (x==0 || x==size-1) && (y==0 || y==size-1);
    }
    
}

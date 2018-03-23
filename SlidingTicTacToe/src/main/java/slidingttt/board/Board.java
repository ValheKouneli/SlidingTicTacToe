/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.board;

import slidingttt.logic.Const;
import slidingttt.logic.Orientation;
import slidingttt.logic.PieceColor;

/**
 * "Dumb" class representing the state of the board.
 * 
 * @author Valhe Kouneli
 */
public class Board {
    
    private char[][] board;
    private final char[][] emptyBoard;
    int size;

    /**
     * Creates a STTT board with size amount of horizontal and vertical lines.
     * If size is an even number, size will be set to size plus one.
     * @param size  The number of horizontal/vertical lines on the STTT board.
     */
    public Board(int size) {   
        this.size = size;
        board = new char[size+2][size+2];
        emptyBoard = new char[size+2][size+2];
        for (int i=0; i<size+2; i++) {
            for (int j=0; j<size+2; j++) {
                char temp;
                char temp2;

                if ((i==0 || i==size+1) && (j==0 || j==size+1)) {
                    temp = 0;
                    temp2 = Const.CORNER;
                } else if ((i==0 && j%2==1) || (i==size+1 && j%2==0)) {
                    temp = Const.RED_VERTICAL;
                    temp2 = Const.BASE_VERTICAL;
                } else if ((i==0 && j%2==0) || (i==size+1 && j%2==1)) {
                    temp = Const.BLACK_VERTICAL;
                    temp2 = Const.BASE_VERTICAL;
                } else if ((j==0 && i%2==1) || (j==size+1 && i%2==0)) {
                    temp = Const.RED_HORIZONTAL;
                    temp2 = Const.BASE_HORIZONTAL;
                } else if ((j==0 && i%2==0) || (j==size+1 && i%2==1)) {
                    temp = Const.BLACK_HORIZONTAL;
                    temp2 = Const.BASE_HORIZONTAL;
                } else {
                    temp = 0;
                    temp2 = Const.EMPTY;
                }
                this.board[i][j] = temp;
                this.emptyBoard[i][j] = temp2;
            }
        }
    }
    
    public int getSize() {
        return this.size;
    }
    
    public void setBoardXY(int x, int y, char c) {
        board[x][y] = c;
    }
    
    public void move(int x_from, int y_from, int x_to, int y_to) {
        board[x_to][y_to] = board[x_from][y_from];
        board[x_from][y_from] = 0;
    }
           
    public char getBoardXY(int x, int y) {
        return board[x][y];
    }
    
    public Orientation getOrientation(char c) {
        if (Character.isUpperCase(c)) {
            return Orientation.HORIZONTAL;
        } else {
            return Orientation.VERTICAL;
        }
    }
    
    public PieceColor getPieceColor(char c) {
        if (c == 'R' || c == 'r') {
            return PieceColor.RED;
        } else {
            return PieceColor.BLACK;
        }
    }
    
    public PieceColor getPieceColor(int x, int y) {
        return getPieceColor(board[x][y]);
    }
    
    public Orientation getOrientation(int x, int y) {
        return getOrientation(board[x][y]);
    }
    
    public char getCharacter(PieceColor color, Orientation orientation){
        char c;
        if (color == PieceColor.RED) {
            c = 'r';
        } else {
            c = 'b';
        }
        if (orientation == Orientation.HORIZONTAL) {
            c= Character.toUpperCase(c);
        }
        
        return c;
    }
    
    @Override
    public String toString() {
        String temp = "";
        char c;
        for (int i=0; i<size+2; i++) {
            for (int j=0; j<size+2; j++) {
                c = board[i][j];
                if (c==0) {
                    c = emptyBoard[i][j];
                }
                temp += c;
            }
            temp += '\n';
        }
        return temp;
    }
    
}

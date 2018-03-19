/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

/**
 *
 * @author Valhe Kouneli
 */
public class Board {
    
    private char[][] board;
    private final int size;
    static char CORNER = ' ';
    static char EMPTY = '+';
    static char PLAYER1_VERTICAL = 'p';
    static char PLAYER1_HORIZONTAL = 'P';
    static char PLAYER2_VERTICAL = 'm';
    static char PLAYER2_HORIZONTAL = 'M';

    Board(int size) {
        this.size = initBoard(size);
    }
    
    private int initBoard(int size) {
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

    public void printBoard() {
        for (int i=0; i<this.size; i++){
            for (int j=0; j<this.size; j++){
                System.out.print(this.board[i][j]);
            }
            System.out.println();
        }
        
    }
    
}

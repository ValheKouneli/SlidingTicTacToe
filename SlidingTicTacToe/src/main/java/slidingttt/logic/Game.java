/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;
import java.util.Scanner;

/**
 *
 * @author Valhe Kouneli
 */
public class Game {
    
    Board board;
    int winner;
    static int UNDECIDED = 0;
    static int RED = 1;
    static int BLACK = 2;
    static char RED_VERTICAL = 'r';
    static char RED_HORIZONTAL = 'R';
    static char BLACK_VERTICAL = 'b';
    static char BLACK_HORIZONTAL = 'B';
    
    public Game(Board board) {
        this.board = board;
        this.winner = UNDECIDED;
    }
    
    public void start() {
        Scanner reader = new Scanner(System.in);
        int turn = RED;
        String player_in_turn = "red";
        int from_x, from_y, to_x, to_y;
        while (winner == UNDECIDED) {
            System.out.println(board.toString());
            System.out.println("It's " + player_in_turn + "'s turn.");
            System.out.println("> ");
            
            /*
            * Try until you get a legal move.
            */
            do {
                from_x = reader.nextInt();
                from_y = reader.nextInt();
                to_x = reader.nextInt();
                to_y = reader.nextInt();
            } while (!board.move(turn, from_x, from_y, to_x, to_y));
            
            checkForThreeInARow(turn);
            if (turn == RED) {
                turn = BLACK;
                player_in_turn = "black";
            } else {
                turn = RED;
                player_in_turn = "red";
            }
        }
        reader.close();
    }
    
    private void checkForThreeInARow(int color) {
        char [][] board_copy = board.getBoard();
       
        int size = board.getSize();
        char vertical;
        char horizontal;
        if (color == RED) {
            vertical = RED_VERTICAL;
            horizontal = RED_HORIZONTAL;
        } else {
            vertical = BLACK_VERTICAL;
            horizontal = BLACK_HORIZONTAL;
        }
        
        for (int i=1; i<size-1 && winner == UNDECIDED; i++) {
            for (int j=1; j<size-1; j++) {
                if (board_copy[i][j] == vertical ||
                    board_copy[i][j] == horizontal) {
                    if (checkAllDirections(i, j, board_copy,
                                           vertical, horizontal)) {
                        winner = color;
                        break;
                    }
                }
            }
        }
    }
    
    private boolean checkAllDirections(int x, int y, char[][] board_copy,
                                       char vertical, char horizontal){
        int count = 0;
        int size = board.getSize();
        /*
        * Check for horizontal three-in-a-row,
        * then for vertical three-in-a-row,
        * then for diagonal three-in-a-row.
        */
        if (y+2 <= size-2) {
            if ((board_copy[x][y+1] == vertical ||
                 board_copy[x][y+1] == horizontal) &&
                (board_copy[x][y+2] == vertical ||
                 board_copy[x][y+2] == horizontal)) {
                return true;
            }
        } else if (x+2 <= size-2) {
            if ((board_copy[x+1][y] == vertical ||
                 board_copy[x+1][y] == horizontal) &&
                (board_copy[x+2][y] == vertical ||
                 board_copy[x+2][y] == horizontal)) {
                return true;
            }
        } else if (x+2 <= size-2 && y+2 <= size-2) {
            return (board_copy[x+1][y+1] == vertical ||
                    board_copy[x+1][y+1] == horizontal) &&
                    (board_copy[x+2][y+2] == vertical ||
                    board_copy[x+2][y+2] == horizontal);
        }
        return false;
    }
    
}

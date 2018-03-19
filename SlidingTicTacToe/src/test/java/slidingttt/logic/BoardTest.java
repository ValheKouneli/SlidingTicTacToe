/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Valhe Kouneli
 */
public class BoardTest {
    
    static int RED = 1;
    static int BLACK = 2;
    
    Board board;
    
    @Before
    public void setUp(){
        board = new Board(3);
    }
    
    @Test
    public void toStringWorking(){
        assertEquals(
                    "  0 1 2 3 4 \n" +
                    "0   r b r   \n" +
                    "1 R + + + B \n" +
                    "2 B + + + R \n" +
                    "3 R + + + B \n" +
                    "4   b r b   \n", board.toString());
    }
    
    @Test
    public void constructorDoesNotAllowToPutEvenSize() {
        board = new Board(4);
        /* size is given as Field size but saved as array size
           which is Field size + 2 */
        assertEquals(7, board.getSize());
    }
    
    @Test
    public void playerCanNotMoveOpponentsPiece() {
        assertEquals(false, board.move(RED, 0, 2, 1, 2));
        assertEquals(false, board.move(BLACK, 0, 1, 1, 1));
    }
    
    @Test
    public void playerCanMoveOwnPieceWhenNothingIsInTheWay() {
        assertEquals(true, board.move(RED, 0, 1, 3, 1));
        assertEquals(true, board.move(BLACK, 2, 0, 2, 3));
    }
    
    @Test
    public void playerCanNotMoveVerticalPieceHorizontally() {
        board.move(RED, 0, 1, 3, 1);
        assertEquals(false, board.move(RED, 3, 1, 3, 2));
    }
    
    @Test
    public void playerCanNotMoveHorizontalPieceVertically() {
        board.move(BLACK, 2, 0, 2, 1);
        assertEquals(false, board.move(BLACK, 2, 1, 1, 1));
    }
    
    @Test
    public void playerCanNotMoveToOccupiedSpace() {
        board.move(RED, 0, 1, 3, 1);
        assertEquals(false, board.move(BLACK, 3, 4, 3, 1));
        assertEquals(false, board.move(RED, 3, 0, 3, 1));
    }
    
    @Test
    public void noMoreThanThreePiecesOfSameColorAllowedOnField() {
        board.move(RED, 1, 0, 1, 1);
        board.move(RED, 3, 0, 3, 1);
        board.move(RED, 2, 4, 2, 3);
        assertEquals(false, board.move(RED, 4, 2, 3, 2));
    }
    
    @Test
    public void horizontalPieceCanNotMovePastAnotherHorizontal() {
        board.move(RED, 1, 0, 1, 3);
        assertEquals(false, board.move(BLACK, 1, 4, 1, 2));
    }
    
    @Test
    public void verticalPieceCanNotMovePastAnotherVertical() {
        board.move(RED, 0, 1, 3, 1);
        assertEquals(false, board.move(BLACK, 4, 1, 2, 1));
    }
    
    @Test
    public void verticalPieceCanMovePastHorizontal() {
        board.move(RED, 1, 0, 1, 2);
        assertEquals(true, board.move(BLACK, 0, 2, 2, 2));
    }
    
    @Test
    public void horizontalPieceCanMovePastVertical(){
        board.move(RED, 0, 1, 1, 1);
        assertEquals(true, board.move(RED, 1, 0, 1, 2));
    }
    
    @Test
    public void horizontalPieceCanNotMovePastVerticalAndHorizontal(){
        board.move(RED, 0, 1, 1, 1);
        board.move(BLACK, 1, 4, 1, 2);
        assertEquals(false, board.move(RED, 1, 0, 1, 3));
    }
    
    @Test
    public void verticalPieceCanNotMovePastHorizontalAndVertical(){
        board.move(RED, 1, 0, 1, 1);
        board.move(BLACK, 4, 1, 2, 1);
        assertEquals(false, board.move(RED, 0, 1, 3, 1));
    }
   
    
    
}

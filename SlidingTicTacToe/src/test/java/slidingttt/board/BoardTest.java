/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.board;

import slidingttt.board.Board;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import slidingttt.logic.PieceColor;
import slidingttt.logic.Orientation;

/**
 *
 * @author Valhe Kouneli
 */
public class BoardTest {
    
    Board board;
    
    @Before
    public void setUp() {
        /*
        * Even numbers are not accepted, so board size will become 3.
        */
        board = new Board(2);
    }
    
    @Test
    public void constructorSetsSizeCorrectly() {
        assertEquals(3, board.getSize());
        board = new Board(3);
        assertEquals(3, board.getSize());
    }
   
    
    @Test
    public void toStringWorks() {
        String beginningPosition = " rbr \n"
                                 + "R+++B\n"
                                 + "B+++R\n"
                                 + "R+++B\n"
                                 + " brb \n";
        assertEquals(beginningPosition, board.toString());
    }
    
    @Test
    public void toStringWorksAfterOneMove() {
        String nextPosition = " rbr \n"
                            + "–R++B\n"
                            + "B+++R\n"
                            + "R+++B\n"
                            + " brb \n";
        board.movePiece(PieceColor.RED, Orientation.HORIZONTAL, 0, 1);
        assertEquals(nextPosition, board.toString());
    }
    
    //@Test
    public void getCopyWorks() {
        //TODO
    }
    
    
    
    
    
}

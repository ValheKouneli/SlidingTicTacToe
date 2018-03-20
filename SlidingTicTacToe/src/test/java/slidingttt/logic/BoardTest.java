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
    
    Board board;
    
    @Before
    public void setUp() {
        /*
        * Even numbers are not accepted, so board size will become 3.
        */
        board = new Board(2);
    }
    
    @Test
    public void initializationWorks() {
        assertEquals(3, board.getSize());
        board = new Board(3);
        assertEquals(3, board.getSize());
    }
    
    @Test
    public void setBeginningPositionMakesTwoLineArraysOfCorrectSize() {
        board.setBeginningPosition();
        assertEquals(board.getSize(), board.getLines()[0].length);
        assertEquals(board.getSize(), board.getLines()[1].length);
    }
    
    @Test
    public void setBeginningPositionMakesLinesInTheRightPlace() {
        setBeginningPositionMakesLinesInTheRightPlace("horizontal", 0);
        setBeginningPositionMakesLinesInTheRightPlace("vertical", 1);
    }
    
    private void setBeginningPositionMakesLinesInTheRightPlace(String orientation, int place) {
        for (int i=0; i<board.getSize(); i++) {
            assertEquals(orientation, board.getLines()[place][i].getOrientation());
        }
    }
    
    
    
    
    
}

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
        board.setBeginningPosition();
        setBeginningPositionMakesLinesInTheRightPlace("horizontal", 0);
        setBeginningPositionMakesLinesInTheRightPlace("vertical", 1);
    }
    
    private void setBeginningPositionMakesLinesInTheRightPlace(String orientation, int place) {
        for (int i=0; i<board.getSize()-1; i++) {
            assertEquals(orientation, board.getLines()[place][i].getOrientation());
        }
    }
    
    @Test
    public void setBeginningPostitionMakesLinesOfRightNumber() {
        board.setBeginningPosition();
        //random tests
        assertEquals(3, board.getLines()[0][2].getNumber());
        assertEquals(1, board.getLines()[1][0].getNumber());
    }
    
    @Test
    public void setBeginningPositionMakesLinesOfRightLength() {
        board.setBeginningPosition();
        //random test
        assertEquals(5, board.getLines()[0][2].getLength());
    }
    
    @Test
    public void setBeginningPositionMakesNewSituation() {
        board.setBeginningPosition();
        assertEquals(board.getSize(), board.getSituation().getSize());
    }
    
    @Test
    public void setBeginningPositionSetsSituationToBeginning() {
        board.setBeginningPosition();
        assertEquals(0, board.getSituation().getRedsOnField());
    }
    
    @Test
    public void setLinesWorks() {
        Line horizontal = new Line("purple", 1, 3);
        Line vertical = new Line("green", 1, 3);
        Line[][] lines = new Line[2][1];
        lines[0][0] = horizontal;
        lines[1][0] = vertical;
        board.setLines(lines);
        assertEquals("purple", board.getLines()[0][0].getOrientation());
        assertEquals("green", board.getLines()[1][0].getOrientation());
    }
    
    @Test
    public void setSituationWorks() {
        Situation situation = new Situation(board.getSize());
    }
    
    
    
    
    
}

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
    public void constructorSetsSizeCorrectly() {
        assertEquals(3, board.getSize());
        board = new Board(3);
        assertEquals(3, board.getSize());
    }
   
    @Test
    public void constructorMakesTwoLineArraysOfCorrectSize() {
        assertEquals(board.getSize(), board.getLines()[0].length);
        assertEquals(board.getSize(), board.getLines()[1].length);
    }
    
    @Test
    public void constructorMakesLinesOfRightNumber() {
        //random tests
        assertEquals(2, board.getLines()[0][2].getNumber());
        assertEquals(0, board.getLines()[1][0].getNumber());
    }
    
    @Test
    public void constructorMakesLinesOfRightLength() {
        //random test
        assertEquals(5, board.getLines()[0][2].getLength());
    }
    
    //@Test
    public void getCopyWorks() {
        //TODO
    }
    
    
    
    
    
}
